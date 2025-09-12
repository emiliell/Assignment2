package com.example.assignment2.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitClient {

    private val BASE_URL = "https://nit3213api.onrender.com/"

    @Provides @Singleton
    fun providesLogging(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides @Singleton
    fun providesClient(logging: HttpLoggingInterceptor) :
            OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

    @Provides @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides @Singleton
    fun providesRetrofit(moshi: Moshi, client: OkHttpClient):
            Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()

    @Provides @Singleton
    fun providesApiService(retrofit: Retrofit):
            ApiService = retrofit.create(ApiService::class.java)
}