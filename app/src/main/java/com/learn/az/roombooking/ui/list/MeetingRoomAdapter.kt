package com.learn.az.roombooking.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learn.az.roombooking.R
import com.learn.az.roombooking.database.MeetingRoom
import com.learn.az.roombooking.databinding.RoomListItemViewBinding

class MeetingRoomAdapter: ListAdapter<MeetingRoom, RoomItemViewHolder>(RoomItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomItemViewHolder {
        return RoomItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RoomItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RoomItemViewHolder private constructor(val binding: RoomListItemViewBinding)
        : RecyclerView.ViewHolder(binding.root){

    fun bind(room: MeetingRoom){
        binding.room = room
    }

    companion object{
        fun from(parent: ViewGroup): RoomItemViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: RoomListItemViewBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.room_list_item_view, parent, false)
            return RoomItemViewHolder(binding)
        }
    }
}

class RoomItemDiffCallback: DiffUtil.ItemCallback<MeetingRoom>(){
    override fun areItemsTheSame(oldItem: MeetingRoom, newItem: MeetingRoom): Boolean {
        return oldItem.roomId == newItem.roomId
    }

    override fun areContentsTheSame(oldItem: MeetingRoom, newItem: MeetingRoom): Boolean {
        return oldItem == newItem
    }

}
