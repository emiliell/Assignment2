package com.example.assignment2.data

import com.example.assignment2.network.ApiService
import com.example.assignment2.network.DashboardResponse
import javax.inject.Inject

class RepClass @Inject constructor(private val apiService: ApiService){

    suspend fun login(campus: String, username:String, password:String) =
        apiService.login(campus, mapOf("username" to username, "password" to password))

    suspend fun getDashboard(keypass: String): DashboardResponse{
        return apiService.dashboard(keypass)
    }

    suspend fun getAllObjectsData() = apiService.getAllObjects()
}