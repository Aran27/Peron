package com.example.peron.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.peron.database.user.User
import com.example.peron.database.user.UserDao
import com.example.peron.database.user.UserRoomDatabase
import kotlinx.coroutines.Dispatchers


class UserViewModel(private val userDao: UserDao): ViewModel() {

    fun getUser(id : Int): LiveData<User> {
        return userDao.getUser(id)
    }

    fun verifyUser(username: String): LiveData<User> {
        return userDao.verifyUser(username)
    }

    fun insertUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    private fun getNewUserEntry(userName: String, userPassword: String): User {
        return User(
            userName = userName,
            password = userPassword
        )
    }

    fun addNewUser(userName: String, userPassword: String) {
        val newUser = getNewUserEntry(userName,userPassword)
        insertUser(newUser)
    }

    fun isEntryValid(userName: String, password: String, confirmPassword: String): Int {
        if (userName.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            return 1
        }
        if (password != confirmPassword) {
            return 2
        }
        if(verifyUser(userName) != null) {
            return 3
        }
        return 0
    }

    fun isEntryValid2(userName: String, password: String): Int{
        if (userName.isBlank() || password.isBlank()) {
            return 1
        }

//        val user = getUser(userName)
//        if (user == null || user.password == password){
//            return 2
//        }
        return 0
    }
}

class UserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}