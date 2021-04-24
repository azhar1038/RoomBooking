package com.learn.az.roombooking.ui.search

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.az.roombooking.database.MeetingRoomDatabaseDao

class SearchRoomViewModelFactory(
    private val dataSource: MeetingRoomDatabaseDao,
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchRoomViewModel::class.java)) {
            return SearchRoomViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}