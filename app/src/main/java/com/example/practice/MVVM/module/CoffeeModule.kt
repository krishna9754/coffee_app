package com.example.practice.MVVM.module

import android.content.Context
import com.example.practice.MVVM.data.CoffeeApi
import com.example.practice.MVVM.dto.CoffeeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import androidx.room.Room
import com.example.practice.MVVM.dto.CoffeeDAO


@Module
@InstallIn(SingletonComponent::class)
object CoffeeModule {

    @Provides
    fun provideBaseUrl() = "https://apis-for-coffee-analysis.p.rapidapi.com/"

    @Provides
    @Singleton
    fun provideRetrofit(provideBaseUrl: String): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("x-rapidapi-key", "169af423c7mshbbb5231caeee726p13e9b7jsncd91fce329d6")
                    .addHeader("x-rapidapi-host", "apis-for-coffee-analysis.p.rapidapi.com")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(provideBaseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): CoffeeApi =
        retrofit.create(CoffeeApi::class.java)


    //DataBase
//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context): CoffeeDataBase =
//        Room.databaseBuilder(
//            context,
//            CoffeeDataBase::class.java,
//            "coffee_database"
//        ).build()
//
//    @Provides
//    fun provideCoffeeDao(database: CoffeeDataBase): CoffeeDAO =
//        database.coffeeDao()
}