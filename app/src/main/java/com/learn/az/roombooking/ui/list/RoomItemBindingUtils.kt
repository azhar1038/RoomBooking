package com.learn.az.roombooking.ui.list

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.learn.az.roombooking.database.MeetingRoom

@BindingAdapter("roomId")
fun TextView.setRoomId(item: MeetingRoom?){
    item?.let {
        text = item.roomId.toString()
    }
}

@BindingAdapter("roomName")
fun TextView.setRoomName(item: MeetingRoom?){
    item?.let {
        text = item.roomName
    }
}