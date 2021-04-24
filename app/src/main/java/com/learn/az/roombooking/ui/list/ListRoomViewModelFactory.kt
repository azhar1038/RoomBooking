package com.learn.az.roombooking.ui.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.az.roombooking.database.MeetingRoomDatabaseDao

class ListRoomViewModelFactory(
    private val dataSource: MeetingRoomDatabaseDao,
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListRoomViewModel::class.java)) {
            return ListRoomViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}