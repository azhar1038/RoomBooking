package com.learn.az.roombooking.ui.add

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.az.roombooking.database.MeetingRoomDatabaseDao

class AddRoomViewModelFactory(
    private val dataSource: MeetingRoomDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddRoomViewModel::class.java)) {
            return AddRoomViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}