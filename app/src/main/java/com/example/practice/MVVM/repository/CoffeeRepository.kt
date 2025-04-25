package com.example.practice.MVVM.repository

import android.util.Log
import com.example.practice.MVVM.data.CoffeeApi
import com.example.practice.MVVM.data.CoffeeData
import javax.inject.Inject

class CoffeeRepository @Inject constructor(
    private val api: CoffeeApi,
//    private val dao: CoffeeDAO
) {
    suspend fun fetchCoffee(): List<CoffeeData> {
        return try {
            val response = api.getCoffeeList(2)
            if (response.isSuccessful) {
                val body = response.body()
                Log.d("CoffeeRepository", "Fetched ${body?.records?.size} items")
                body?.records ?: emptyList()
            } else {
                Log.e("CoffeeRepository", "API Error ${response.code()}: ${response.message()}")
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("CoffeeRepository", "Exception: ${e.localizedMessage}", e)
            emptyList()
        }
    }
}