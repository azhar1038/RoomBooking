package com.learn.az.roombooking.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel: ViewModel() {
    private val _eventNavigateToAddRoom = MutableLiveData(false)
    val eventNavigateToAddRoom: LiveData<Boolean>
        get() = _eventNavigateToAddRoom

    private val _eventNavigateToRoomList = MutableLiveData(false)
    val eventNavigateToRoomList: LiveData<Boolean>
        get() = _eventNavigateToRoomList

    private val _eventNavigateToSearchRoom = MutableLiveData(false)
    val eventNavigateToSearchRoom: LiveData<Boolean>
        get() = _eventNavigateToSearchRoom

    private val _eventNavigateToLogin = MutableLiveData(false)
    val eventNavigateToLogin: LiveData<Boolean>
        get() = _eventNavigateToLogin

    fun navigateToRoomList(){
        _eventNavigateToRoomList.value = true
    }
    fun navigateToRoomListComplete(){
        _eventNavigateToRoomList.value = false
    }

    fun navigateToSearchRoom(){
        _eventNavigateToSearchRoom.value = true
    }
    fun navigateToSearchRoomComplete(){
        _eventNavigateToSearchRoom.value = false
    }

    fun navigateToAddRoom(){
        _eventNavigateToAddRoom.value = true
    }
    fun navigateToAddRoomComplete(){
        _eventNavigateToAddRoom.value = false
    }

    fun navigateToLogin(){
        _eventNavigateToLogin.value = true
    }
    fun navigateToLoginComplete(){
        _eventNavigateToLogin.value = false
    }

}