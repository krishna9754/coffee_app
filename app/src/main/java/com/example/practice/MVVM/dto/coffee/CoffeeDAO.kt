package com.example.practice.MVVM.dto.coffee

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.practice.MVVM.data.CoffeeData
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDAO {
    @Query("SELECT * FROM coffee")
    fun getAllCoffee(): Flow<List<CoffeeData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffee(coffee: List<CoffeeData>)
}