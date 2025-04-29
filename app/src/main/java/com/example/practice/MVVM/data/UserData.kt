package com.example.practice.MVVM.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val address: String?,
    val phone: String?,
    val pincode: String?,
    val city: String?,
    val state: String?,
)
