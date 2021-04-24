package com.learn.az.roombooking.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    val userName = MutableLiveData("")

    val password = MutableLiveData("")

    private val _userNameError = MutableLiveData<String?>()
    val userNameError: LiveData<String?>
        get() = _userNameError

    private val _passwordError = MutableLiveData<String?>()
    val passwordError: LiveData<String?>
        get() = _passwordError

    private val _eventNavigateToDashboard = MutableLiveData(false)
    val eventNavigateToDashboard: LiveData<Boolean>
        get() = _eventNavigateToDashboard

    fun formValidate(){
        var isValid = true
        when {
            userName.value.isNullOrEmpty() -> {
                _userNameError.value = "Username cannot be empty"
                isValid = false
            }
            userName.value != "ADMIN" -> {
                _userNameError.value = "Incorrect Username"
                isValid = false
            }
            else -> {
                _userNameError.value = ""
            }
        }
        when {
            password.value.isNullOrEmpty() -> {
                _passwordError.value = "Password cannot be empty"
                isValid = false
            }
            password.value != "TEST" -> {
                _passwordError.value = "Incorrect Password"
                isValid = false
            }
            else -> {
                _passwordError.value = ""
            }
        }
        if(isValid) _eventNavigateToDashboard.value = true
    }

    fun navigateToDashboardComplete(){
        _eventNavigateToDashboard.value = false
    }
}