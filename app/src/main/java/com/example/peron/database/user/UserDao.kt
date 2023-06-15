package com.example.peron.database.user

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

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Int): Flow<User>

//    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
//    fun getAll(): Flow<List<Schedule>>
//
//    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
//    fun getByStopName(stopName: String): Flow<List<Schedule>>
}
