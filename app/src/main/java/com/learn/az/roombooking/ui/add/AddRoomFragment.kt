package com.learn.az.roombooking.ui.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.learn.az.roombooking.R
import com.learn.az.roombooking.database.MeetingRoomDatabase
import com.learn.az.roombooking.databinding.FragmentAddRoomBinding


class AddRoomFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAddRoomBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_room, container, false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = MeetingRoomDatabase.getInstance(application).meetingRoomDatabaseDao

        val viewModelFactory = AddRoomViewModelFactory(dataSource, application)

        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(AddRoomViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.eventNavigateToSummary.observe(viewLifecycleOwner){
            if(it != null){
                this.findNavController().navigate(
                    AddRoomFragmentDirections.actionAddRoomFragmentToAddSummaryFragment(it))
                viewModel.navigateToSummaryComplete()
            }
        }
        return binding.root
    }
}