package com.example.assignment2.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {


    @POST ("{campus}/auth")
    suspend fun login(
        @Path("campus") campus: String,
        @Body body: Map<String, String>
    )


    @GET("objects")
    suspend fun getAllObjects(): List<ResponseItem>

}

@Parcelize
data class ResponseItem(
    @Json(name = "data") val dataSection: Map<String, String>?,
    @Json(name = "id")   val id: String,
    @Json(name = "name") val objectName: String
): Parcelable