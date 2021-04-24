package com.learn.az.roombooking.ui.add

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.learn.az.roombooking.database.MeetingRoom
import com.learn.az.roombooking.database.MeetingRoomDatabaseDao
import kotlinx.coroutines.*

class AddRoomViewModel(
    val database: MeetingRoomDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
    val building = MutableLiveData("")
    val floor = MutableLiveData("")
    val roomName = MutableLiveData("")
    val capacity = MutableLiveData("")
    val network = MutableLiveData(false)
    val confPhone = MutableLiveData(false)
    val projector = MutableLiveData(false)
    val internet = MutableLiveData(false)
    val video = MutableLiveData(false)
    val ac = MutableLiveData(false)

    private val _buildingError = MutableLiveData("")
    val buildingError: LiveData<String>
        get() = _buildingError

    private val _floorError = MutableLiveData("")
    val floorError: LiveData<String>
        get() = _floorError

    private val _roomNameError = MutableLiveData("")
    val roomNameError: LiveData<String>
        get() = _roomNameError

    private val _capacityError = MutableLiveData("")
    val capacityError: LiveData<String>
        get() = _capacityError

    private val _eventNavigateToSummary = MutableLiveData<MeetingRoom?>()
    val eventNavigateToSummary: LiveData<MeetingRoom?>
        get() = _eventNavigateToSummary

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+job)


    fun addRoom(){
        var isValid = true
        if(building.value.isNullOrEmpty()){
            isValid = false
            _buildingError.value = "Building cannot be empty"
        }else{
            _buildingError.value = ""
        }

        if(floor.value.isNullOrEmpty()){
            isValid = false
            _floorError.value = "Floor cannot be empty"
        }else{
            _floorError.value = ""
        }

        if(roomName.value.isNullOrEmpty()){
            isValid = false
            _roomNameError.value = "Room Name cannot be empty"
        }else{
            _roomNameError.value = ""
        }

        if(capacity.value.isNullOrEmpty()){
            isValid = false
            _capacityError.value = "Capacity cannot be empty"
        }else if(!capacity.value!!.matches("\\d+".toRegex())){
            isValid = false
            _capacityError.value = "Enter number"
        }else{
            _capacityError.value = ""
        }

        if(isValid){
            addRoomToDatabase()
        }
    }

    private fun getValue(v: Boolean?): Int{
        return when(v){
            true -> 1
            else -> 0
        }
    }

    private fun addRoomToDatabase(){
//        var floorNumber: Int = (floor.value?:0) as Int
        val newRoom = MeetingRoom(
            building = building.value?:"",
            floor = floor.value?:"",
            roomName = roomName.value?:"",
            capacity = (capacity.value?.toIntOrNull())?:0,
            network = getValue(network.value),
            confPhone = getValue(confPhone.value),
            projector = getValue(projector.value),
            internet = getValue(internet.value),
            video = getValue(video.value),
            ac = getValue(ac.value)
        )
        uiScope.launch {
            newRoom.roomId = insert(newRoom)
            _eventNavigateToSummary.value = newRoom
        }
    }

    private suspend fun insert(room: MeetingRoom): Long{
        return withContext(Dispatchers.IO){
            database.insert(room)
        }
    }

//    private suspend fun getRoom(room: MeetingRoom): MeetingRoom{
//        return withContext(Dispatchers.IO){
//            database.insert(room)
//        }
//    }

    fun navigateToSummaryComplete(){
        _eventNavigateToSummary.value = null
    }
}