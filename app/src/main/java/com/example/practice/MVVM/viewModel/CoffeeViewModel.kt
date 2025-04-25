package com.example.practice.MVVM.viewModel

import android.util.Log
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

    init {
        fetchCoffeeData()
    }

    private fun fetchCoffeeData() {
        viewModelScope.launch {
            _error.value = null
            try {
                val remoteCoffeeList = repository.fetchCoffee()
                if (remoteCoffeeList.isNotEmpty()) {
                    _coffeeState.value = remoteCoffeeList
                    Log.d("CoffeeViewModel", "Fetched ${remoteCoffeeList.size} coffee items")
                } else {
                    _error.value = "No coffee data available. Please try again."
                    Log.w("CoffeeViewModel", "No coffee data received")
                }
            } catch (e: Exception) {
                _error.value = "Failed to load data: ${e.localizedMessage}"
                Log.e("CoffeeViewModel", "API Error: ${e.localizedMessage}", e)
            }
        }
    }
}