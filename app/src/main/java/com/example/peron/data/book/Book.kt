package com.example.peron.data.book

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize
import org.w3c.dom.Text

@Parcelize
@Entity(tableName = "book_table")
data class Book(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val book_title: String,
    val book_author: String,
    val book_genre: String,
    val book_desc: String,
    val book_content: String
): Parcelable
