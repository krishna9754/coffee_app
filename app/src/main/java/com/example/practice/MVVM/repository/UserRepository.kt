package com.example.practice.MVVM.repository

import com.example.practice.MVVM.data.UserData
import com.example.practice.MVVM.dto.user.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    fun getAllUser(): Flow<List<UserData>> = userDao.getAllUserData()
    suspend fun insertUser(user: UserData) = userDao.insertUserData(user)
}