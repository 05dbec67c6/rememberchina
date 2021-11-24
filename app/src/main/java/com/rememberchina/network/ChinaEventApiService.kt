package com.rememberchina.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://eyeonchina.net/wp-json/wp/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// The Retrofit build
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Defines how Retrofit talks to the web server using HTTP requests
interface EventApiService {
    @GET("posts")
    suspend fun getChinaEvents(): List<ChinaEvent>
}

// Public object to initialize the Retrofit service
// Used public object because only needs one Retrofit service instance, exposed to the rest of the app

object ChinaEventApi {
    val retrofitService: EventApiService by lazy {
        retrofit.create(EventApiService::class.java)
    }
}
