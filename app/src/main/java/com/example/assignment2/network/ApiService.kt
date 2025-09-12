package com.example.assignment2.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import retrofit2.http.GET

interface ApiService {

    @GET("objects")
    suspend fun getAllObjects(): List<ResponseItem>

}

@Parcelize
data class ResponseItem(
    @Json(name = "data") val dataSection: Map<String, String>?,
    @Json(name = "id")   val id: String,
    @Json(name = "name") val objectName: String
): Parcelable