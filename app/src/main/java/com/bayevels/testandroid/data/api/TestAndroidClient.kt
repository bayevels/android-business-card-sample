package com.bayevels.testandroid.data.api

import com.bayevels.testandroid.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface TestAndroidClient {

    companion object {
        val IMPL: TestAndroidClient = Api.RETROFIT_GANK.create(TestAndroidClient::class.java)
    }

    @GET("users")
    fun getUsers(): Call<List<User>>
}