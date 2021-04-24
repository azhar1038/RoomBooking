package com.learn.az.roombooking.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.learn.az.roombooking.R
import com.learn.az.roombooking.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentDashboardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard, container, false
        )

        val viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.eventNavigateToAddRoom.observe(viewLifecycleOwner){
            if(it == true){
                this.findNavController().navigate(
                    DashboardFragmentDirections.actionDashboardFragmentToAddRoomFragment())
                viewModel.navigateToAddRoomComplete()
            }
        }

        viewModel.eventNavigateToRoomList.observe(viewLifecycleOwner){
            if(it == true){
                this.findNavController().navigate(
                    DashboardFragmentDirections.actionDashboardFragmentToListRoomFragment())
                viewModel.navigateToRoomListComplete()
            }
        }

        viewModel.eventNavigateToSearchRoom.observe(viewLifecycleOwner){
            if(it == true){
                this.findNavController().navigate(
                    DashboardFragmentDirections.actionDashboardFragmentToSearchRoomFragment())
                viewModel.navigateToSearchRoomComplete()
            }
        }

        viewModel.eventNavigateToLogin.observe(viewLifecycleOwner){
            if(it == true){
                this.findNavController().navigate(
                    DashboardFragmentDirections.actionDashboardFragmentToLoginFragment())
                viewModel.navigateToLoginComplete()
            }
        }
        return binding.root
    }
}