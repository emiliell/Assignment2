package com.example.assignment2.ui.recyclerview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.data.RepClass
import com.example.assignment2.network.ApiService
import com.example.assignment2.network.DashboardResponse
import com.example.assignment2.network.KeypassResponse
import com.example.assignment2.network.ResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: RepClass) : ViewModel() {

    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            val result = repository.getDashboard(keypass)
            apiResponseObjects.value = result.entities
        }
    }
}