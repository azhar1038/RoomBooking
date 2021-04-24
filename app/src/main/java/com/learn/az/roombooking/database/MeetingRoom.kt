package com.learn.az.roombooking.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Rooms")
@Parcelize
data class MeetingRoom(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "room_id")
    var roomId: Long = 0L,
    @ColumnInfo(name="room_name")
    var roomName: String = "",
    @ColumnInfo(name="building")
    var building: String = "",
    @ColumnInfo(name="floor")
    var floor: String = "",
    @ColumnInfo(name="capacity")
    var capacity: Int = 0,
    @ColumnInfo(name="network")
    var network: Int = 0,
    @ColumnInfo(name="conference_phone")
    var confPhone: Int = 0,
    @ColumnInfo(name="projector")
    var projector: Int = 0,
    @ColumnInfo(name="internet")
    var internet: Int = 0,
    @ColumnInfo(name="video")
    var video: Int = 0,
    @ColumnInfo(name="air_conditioner")
    var ac: Int = 0,
): Parcelable