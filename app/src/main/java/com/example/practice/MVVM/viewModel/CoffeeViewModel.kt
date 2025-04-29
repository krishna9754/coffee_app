package com.example.practice.MVVM.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.MVVM.data.CoffeeData
import com.example.practice.MVVM.repository.CoffeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val repository: CoffeeRepository
) : ViewModel() {

    private val _coffeeState = MutableStateFlow<List<CoffeeData>>(emptyList())
    val coffeeState: StateFlow<List<CoffeeData>> = _coffeeState

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 2

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading


    init {
        fetchCoffeeData()
    }

    private fun fetchCoffeeData() {
        viewModelScope.launch {
            _error.value = null
            _isLoading.value = true
            try {
                val remoteCoffeeList = repository.fetchCoffee(page = currentPage)
                if (remoteCoffeeList.isNotEmpty()) {
                    _coffeeState.value += remoteCoffeeList
                } else {
                    _error.value = "No coffee data available. Please try again."
                }
            } catch (e: Exception) {
                _error.value = "Failed to load data: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadNextPage() {
        currentPage++
        fetchCoffeeData()
    }
}