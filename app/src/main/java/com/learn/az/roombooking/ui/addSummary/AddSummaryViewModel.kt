package com.learn.az.roombooking.ui.addSummary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.az.roombooking.database.MeetingRoom
import com.learn.az.roombooking.database.MeetingRoomDatabaseDao
import kotlinx.coroutines.*

class AddSummaryViewModel: ViewModel() {
    private val _eventNavigateToDashboard = MutableLiveData(false)
    val eventNavigateToDashboard: LiveData<Boolean>
        get() = _eventNavigateToDashboard

    fun navigateToDashboard(){
        _eventNavigateToDashboard.value = true
    }

    fun navigateToDashboardComplete(){
        _eventNavigateToDashboard.value = false
    }
}