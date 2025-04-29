package com.example.practice.MVVM.dto.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.practice.MVVM.data.UserData
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * From user")
    fun getAllUserData(): Flow<List<UserData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserData(userData: UserData)

    @Update
    suspend fun updateUserData(userData: UserData)

    @Delete
    suspend fun deleteUserData(userData: UserData)
}