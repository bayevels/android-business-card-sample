package com.bayevels.testandroid.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bayevels.testandroid.data.dao.UserDao
import com.bayevels.testandroid.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}