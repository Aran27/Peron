package com.example.peron.database.book

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM book WHERE id = :id")
    fun getBook(id: Int): Flow<Book>

    @Query("SELECT * FROM book ORDER BY book_title ASC")
    fun getBooks(): Flow<List<Book>>

//    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
//    fun getAll(): Flow<List<Schedule>>
//
//    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
//    fun getByStopName(stopName: String): Flow<List<Schedule>>
}