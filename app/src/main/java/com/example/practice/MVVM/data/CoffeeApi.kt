package com.example.practice.MVVM.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoffeeApi {
    @GET("rapidapi/coffee/coffee_pagination.php")
    suspend fun getCoffeeList( @Query("page_no") page: Int = 1 ): Response<CoffeeResponse>
}
