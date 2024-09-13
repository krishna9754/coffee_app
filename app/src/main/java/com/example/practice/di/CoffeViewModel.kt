package com.example.practice.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.di.model.dto.CoffeeDto
import com.example.practice.di.repository.CoffeeRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoffeeViewModel @Inject constructor(
    private val coffeeRepo: CoffeeRepo
): ViewModel() {
    private val _state = MutableStateFlow(emptyList<CoffeeDto>())
    val state: StateFlow<List<CoffeeDto>>
        get() = _state

    init {
        viewModelScope.launch {
            val charactersData = coffeeRepo
            _state.value = charactersData.getCoffee()
        }
    }
}