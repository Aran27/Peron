package com.example.peron.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.peron.database.user.User
import com.example.peron.database.user.UserDao


class UserViewModel(private val userDao: UserDao): ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch {
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
}

class UserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    fun isEntryValid(userName: String, userPassword: String, confirmPassword: String): Boolean {
        if (userName.isBlank() || userPassword.isBlank() || confirmPassword.isBlank()) {
            return false
        }
        if (userPassword == confirmPassword) {
            return false
        }
        return true
    }
}