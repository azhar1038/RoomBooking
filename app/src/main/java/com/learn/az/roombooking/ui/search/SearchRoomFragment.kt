package com.learn.az.roombooking.ui.search

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learn.az.roombooking.R
import com.learn.az.roombooking.database.MeetingRoomDatabase
import com.learn.az.roombooking.databinding.FragmentSearchRoomBinding

class SearchRoomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val application = requireNotNull(this.activity).application
        val dataSource = MeetingRoomDatabase.getInstance(application).meetingRoomDatabaseDao

        val viewModelFactory = SearchRoomViewModelFactory(dataSource)

        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(SearchRoomViewModel::class.java)
        val binding: FragmentSearchRoomBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_search_room, container, false
        )
        viewModel.eventDeletePressed.observe(viewLifecycleOwner){
            if(it){
                AlertDialog.Builder(this.context)
                    .setTitle("Are you sure you want to delete this entry?")
                    .setPositiveButton("DELETE"
                    ) { p0, p1 -> viewModel.startDelete() }
                    .setNegativeButton("CANCEL", null)
                    .show()
            }
        }

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}