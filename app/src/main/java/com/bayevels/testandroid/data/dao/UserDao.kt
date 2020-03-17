package com.bayevels.testandroid.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.bayevels.testandroid.data.model.User

@Dao
interface UserDao: BaseDao<User> {

    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<User>>
}