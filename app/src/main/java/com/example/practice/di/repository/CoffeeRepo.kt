package com.example.practice.di.repository

import com.example.practice.di.model.dto.CoffeeDto
import com.example.practice.di.service.CoffeeApiService
import javax.inject.Inject


class CoffeeRepo @Inject constructor(
    private val coffeeApiService: CoffeeApiService
) {

    suspend fun getCoffee(): List<CoffeeDto> {
        return coffeeApiService.getCoffee()
    }
}