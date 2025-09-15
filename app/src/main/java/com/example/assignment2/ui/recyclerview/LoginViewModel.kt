package com.example.assignment2.ui.recyclerview

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    suspend fun login(campus: String, userName: String, passWord: String): String? {
        return withContext(Dispatchers.Default) {
            when {
                userName != "emilie" -> "Wrong username"
                passWord != "8074381" -> "Wrong password"
                campus != "footscray" -> "Wrong campus"
                else -> null
            }
        }
    }

}