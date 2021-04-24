package com.learn.az.roombooking.ui.addSummary

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
import com.learn.az.roombooking.databinding.FragmentAddSummaryBinding
import com.learn.az.roombooking.ui.add.AddRoomViewModel
import com.learn.az.roombooking.ui.add.AddRoomViewModelFactory

class AddSummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentAddSummaryBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_summary, container, false
        )
        val arguments = AddSummaryFragmentArgs.fromBundle(requireArguments())

        val viewModel = ViewModelProvider(this)
            .get(AddSummaryViewModel::class.java)

        viewModel.eventNavigateToDashboard.observe(viewLifecycleOwner){
            if(it == true){
                this.findNavController().popBackStack()
                viewModel.navigateToDashboardComplete()
            }
        }

        binding.room = arguments.room
        binding.viewModel = viewModel
        return binding.root
    }
}