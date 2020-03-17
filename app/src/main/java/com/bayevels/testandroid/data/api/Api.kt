package com.bayevels.testandroid.data.api

import android.content.Context
import com.bayevels.testandroid.data.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {

    const val HOST_GANK = "https://jsonplaceholder.typicode.com/"
    lateinit var RETROFIT_GANK: Retrofit
    lateinit var CONTEXT: Context
    lateinit var CLIENT: OkHttpClient
    lateinit var GSON: Gson

    fun initialize(context: Context) {
        CONTEXT = context

        CLIENT = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
        GSON = GsonBuilder()
            .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss")
            .create()

        RETROFIT_GANK = Retrofit.Builder()
            .baseUrl(HOST_GANK)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .client(CLIENT)
            .build()
    }

}