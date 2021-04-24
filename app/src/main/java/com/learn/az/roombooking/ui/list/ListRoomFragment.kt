package com.learn.az.roombooking.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learn.az.roombooking.R
import com.learn.az.roombooking.database.MeetingRoomDatabase
import com.learn.az.roombooking.databinding.FragmentListRoomBinding
import com.learn.az.roombooking.databinding.FragmentSearchRoomBinding
import com.learn.az.roombooking.ui.search.SearchRoomViewModel
import com.learn.az.roombooking.ui.search.SearchRoomViewModelFactory

class ListRoomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application = requireNotNull(this.activity).application
        val dataSource = MeetingRoomDatabase.getInstance(application).meetingRoomDatabaseDao

        val viewModelFactory = ListRoomViewModelFactory(dataSource)

        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListRoomViewModel::class.java)
        val binding: FragmentListRoomBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list_room, container, false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val adapter = MeetingRoomAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.rooms.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it)
            }
        }
        return binding.root
    }
}