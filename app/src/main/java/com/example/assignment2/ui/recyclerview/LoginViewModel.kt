package com.example.assignment2.ui.recyclerview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    val loginError = MutableStateFlow<String?>(null)

    fun login(campus: String, userName: String, passWord: String) {
        viewModelScope.launch {

            if (userName == "emilie" && passWord == "8074381" && campus == "footscray") {
                loginError.value = null
            }
            else if (userName != "emilie") {
                loginError.value = "Wrong username"
            }
            else if (passWord != "8074381") {
                loginError.value = "Wrong password"
            }
            else if (campus != "footscray") {
                loginError.value = "Wrong campus"
            }

        }
    }

}