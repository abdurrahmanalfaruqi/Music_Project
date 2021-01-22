package com.example.makananApp.retrofit

import com.example.makananApp.model.Makanan
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitBuilder {
    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dev.farizdotid.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun getService() = retrofit.create(TopHeadlines::class.java)
}

interface TopHeadlines{
    @GET("/api/purwakarta/kuliner")

    fun fetchHeadlines(): Call<Makanan>
}