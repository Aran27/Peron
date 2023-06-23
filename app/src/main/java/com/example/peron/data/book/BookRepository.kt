package com.example.peron.data.book

import androidx.lifecycle.LiveData

class BookRepository(private val bookDao: BookDao) {

    val readAllData: LiveData<List<Book>> = bookDao.readAllData()

    fun searchDatabase(searchQuerry: String): LiveData<List<Book>> {
        return bookDao.searchDatabase(searchQuerry)
    }
}