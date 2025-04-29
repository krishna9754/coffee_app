package com.example.practice.MVVM.dto.coffee

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practice.MVVM.data.CoffeeData

@Database(entities = [CoffeeData::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class CoffeeDataBase : RoomDatabase() {
    abstract fun coffeeDao(): CoffeeDAO
}