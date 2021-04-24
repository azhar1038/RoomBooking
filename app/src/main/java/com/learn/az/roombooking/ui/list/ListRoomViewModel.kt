package com.learn.az.roombooking.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.az.roombooking.database.MeetingRoom
import com.learn.az.roombooking.database.MeetingRoomDatabaseDao
import kotlinx.coroutines.*

class ListRoomViewModel(
    val database: MeetingRoomDatabaseDao): ViewModel() {

    val rooms = database.getAll()

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+job)
}