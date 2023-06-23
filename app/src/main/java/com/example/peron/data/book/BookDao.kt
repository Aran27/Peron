package com.example.peron.data.book

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {

    @Query("SELECT * FROM book_table ORDER BY book_title ASC")
    fun readAllData(): LiveData<List<Book>>

    @Query("SELECT * FROM book_table WHERE book_title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<Book>>

}