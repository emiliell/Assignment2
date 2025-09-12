package com.example.assignment2.data

import com.example.assignment2.network.ApiService
import javax.inject.Inject

class RepClass @Inject constructor(private val apiService: ApiService){

    suspend fun getAllObjectsData() = ApiService.getAllObjects()
}