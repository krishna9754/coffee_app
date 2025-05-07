package com.example.practice.MVVM.module

import android.content.Context
import androidx.room.Room
import com.example.practice.MVVM.data.CoffeeApi
import com.example.practice.MVVM.dto.user.UserDao
import com.example.practice.MVVM.dto.user.UserDataBase
import com.example.practice.MVVM.repository.UserRepository
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


@Module
@InstallIn(SingletonComponent::class)
object CoffeeModule {

    // Provide Base URL
    @Provides
    fun provideBaseUrl(): String = "https://apis-for-coffee-analysis.p.rapidapi.com/"

    // Provide Retrofit Instance
    @Provides
    @Singleton
    fun provideRetrofit(provideBaseUrl: String): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
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

    // Provide Coffee API
    @Provides
    @Singleton
    fun provideCoffeeApi(retrofit: Retrofit): CoffeeApi =
        retrofit.create(CoffeeApi::class.java)

    // Provide Room Database
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDataBase {
        return Room.databaseBuilder(
            context,
            UserDataBase::class.java,
            "user_database"
        ).fallbackToDestructiveMigration().build()
    }

    // Provide User DAO
    @Provides
    @Singleton
    fun provideUserDao(database: UserDataBase): UserDao = database.userDao()

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)
}
