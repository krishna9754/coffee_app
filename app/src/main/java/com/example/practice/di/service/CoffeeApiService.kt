package com.example.practice.di.service

import com.example.practice.di.model.dto.CoffeeDto
import com.example.practice.di.module.ApiConstant
import retrofit2.http.GET

interface CoffeeApiService {

    @GET(ApiConstant.END_POINT)
    suspend fun getCoffee(): List<CoffeeDto>
}