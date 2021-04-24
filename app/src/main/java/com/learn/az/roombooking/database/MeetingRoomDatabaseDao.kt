package com.learn.az.roombooking.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MeetingRoomDatabaseDao {
    @Insert
    fun insert(room: MeetingRoom): Long

    @Query("SELECT * FROM Rooms ORDER BY room_id")
    fun getAll(): LiveData<List<MeetingRoom>>

    @Query("SELECT * FROM Rooms WHERE room_id = :key")
    fun getById(key: Long): MeetingRoom?

    @Delete
    fun delete(room: MeetingRoom)
}