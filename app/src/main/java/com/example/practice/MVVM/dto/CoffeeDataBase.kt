package com.example.practice.MVVM.dto

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practice.MVVM.data.CoffeeData

@Database(entities = [CoffeeData::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class CoffeeDataBase : RoomDatabase() {
    abstract fun coffeeDao(): CoffeeDAO
}