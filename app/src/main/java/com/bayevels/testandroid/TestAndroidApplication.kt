package com.bayevels.testandroid

import android.app.Application
import androidx.room.Room
import com.bayevels.testandroid.data.AppDatabase
import com.bayevels.testandroid.data.api.Api


val database: AppDatabase by lazy {
    TestAndroidApplication.database
}

class TestAndroidApplication: Application() {
    companion object {
        lateinit var instance : TestAndroidApplication
            private set
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initialization()
    }

    fun initialization() {
        configApi()
        configDatabase()
    }

    fun configApi() {
        Api.initialize(applicationContext)
    }

    fun configDatabase() {
        database = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "test-android-db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
