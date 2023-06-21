package com.example.peron.database.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE id LIKE :id")
    fun getUser(id : Int): LiveData<User>

    @Query("SELECT * FROM user WHERE user_name LIKE :username LIMIT 1")
    fun verifyUser(username :String): LiveData<User>

    @Query("SELECT * FROM user WHERE user_name LIKE :username AND password LIKE :password")
    fun readAllData(username :String, password :String): LiveData<User>

//    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
//    fun getAll(): Flow<List<Schedule>>
//
//    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
//    fun getByStopName(stopName: String): Flow<List<Schedule>>
}
