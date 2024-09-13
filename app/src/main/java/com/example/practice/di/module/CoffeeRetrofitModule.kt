package com.example.practice.di.module

import com.example.practice.di.service.CoffeeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoffeeRetrofitModule {

    @Provides
    @Singleton
    fun provideCoffeeApi(retrofit: Retrofit): CoffeeApiService {
        return retrofit.create(CoffeeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() // Create Retrofit object here
    }
}
