package com.example.peron.database.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book (
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "book_title")
    val bookTitle : String,

    @ColumnInfo(name = "book_genre")
    val bookGenre: String,

    @ColumnInfo(name = "book_desc")
    val bookDesc: String,

    @ColumnInfo(name = "book_content")
    val bookContent: String
)