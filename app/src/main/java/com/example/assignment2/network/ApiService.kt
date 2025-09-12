package com.example.assignment2.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {


    @POST ("{campus}/auth")
    suspend fun login(
        @Path("campus") campus: String,
        @Body body: Map<String, String>
    ) : KeypassResponse


    @GET("dashboard/{keypass}")
    suspend fun dashboard(@Path("keypass") keypass: String
    ): DashboardResponse

}

data class KeypassResponse(val keypass:String)
data class DashboardResponse(val ResponseItems: List<ResponseItem>)

@Parcelize
data class ResponseItem(
    @Json(name = "artistName") val artist_name: String?,
    @Json(name = "albumTitle")   val album_title: String?,
    @Json(name = "releaseYear") val release_year: String?,
    @Json(name = "genre") val genre: String?,
    @Json(name = "trackCount")   val track_count: String?,
    @Json(name = "Description") val description: String?,
    @Json(name = "popularTrack") val popular_track: String?
): Parcelable