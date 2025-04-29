package com.example.practice.MVVM.repository

import com.example.practice.MVVM.data.CoffeeApi
import com.example.practice.MVVM.data.CoffeeData
import javax.inject.Inject

class CoffeeRepository @Inject constructor(
    private val api: CoffeeApi,
//    private val dao: CoffeeDAO
) {
    suspend fun fetchCoffee(page: Int): List<CoffeeData> {
        return try {
            val response = api.getCoffeeList(page)
            if (response.isSuccessful) {
                val body = response.body()
                body?.records ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}