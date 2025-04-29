package com.example.practice.MVVM.dto.user

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practice.MVVM.data.UserData

@Database(entities = [UserData::class], version = 2)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}