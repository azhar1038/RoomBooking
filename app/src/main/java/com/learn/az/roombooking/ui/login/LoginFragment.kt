package com.learn.az.roombooking.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.learn.az.roombooking.R
import com.learn.az.roombooking.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventNavigateToDashboard.observe(viewLifecycleOwner){
            if(it == true){
//                this.findNavController().popBackStack(R.id.loginFragment, true)
                this.findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToDashboardFragment())
                viewModel.navigateToDashboardComplete()
            }
        }

        return binding.root
    }
}