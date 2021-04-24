package com.learn.az.roombooking.ui.search

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.az.roombooking.database.MeetingRoom
import com.learn.az.roombooking.database.MeetingRoomDatabaseDao
import kotlinx.coroutines.*

class SearchRoomViewModel(
    val database: MeetingRoomDatabaseDao): ViewModel() {
    private val _room = MutableLiveData<MeetingRoom?>()
    val room: LiveData<MeetingRoom?>
        get() = _room

    val roomId = MutableLiveData("")
    val roomIdError = MutableLiveData("")

    val eventDeletePressed = MutableLiveData(false)

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+job)

    fun search(){
        Log.i("TAG", "search: ${roomId.value}")
        if(roomId.value.isNullOrEmpty()){
            Log.i("TAG", "search: IS Null or Empty}")
            roomIdError.value = "Room id is required"
            return
        }
        Log.i("TAG", "search: IS NOT Null or Empty}")
        roomIdError.value = ""
        val id: Long = (roomId.value?:"0").toLong()
        uiScope.launch {
            _room.value = getById(id)
        }
    }

    private suspend fun getById(id: Long): MeetingRoom?{
        return withContext(Dispatchers.IO){
            database.getById(id)
        }
    }

    fun delete(){
        if(room.value != null){
            eventDeletePressed.value = true
        }
    }

    fun startDelete(){
        uiScope.launch {
            deleteFromDatabase()
            _room.value = null
            eventDeletePressed.value = false
        }
    }

    private suspend fun deleteFromDatabase(){
        withContext(Dispatchers.IO){
            database.delete(room.value!!)
        }
    }
}