package com.example.peron

import android.app.Application
import com.example.peron.database.book.BookRoomDatabase
import com.example.peron.database.user.UserRoomDatabase

class PeronApplication : Application() {

    val userDatabase: UserRoomDatabase by lazy { UserRoomDatabase.getDatabase(this) }
    val bookDatabase: BookRoomDatabase by lazy { BookRoomDatabase.getDatabase(this) }
}