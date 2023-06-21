package com.example.peron.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.peron.database.book.Book
import com.example.peron.database.book.BookDao
import com.example.peron.database.user.UserDao

class BookViewModel(private val bookDao: BookDao): ViewModel() {

    val allBooks: LiveData<List<Book>> = bookDao.getBooks().asLiveData()
}

class BookViewModelFactory(private val bookDao: BookDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookViewModel(bookDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}