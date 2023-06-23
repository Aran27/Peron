package com.example.peron.data.user

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    fun readData(username: String, password: String): User = userDao.readData(username, password)

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}