package com.bayevels.testandroid.data.repository

import com.bayevels.testandroid.data.api.TestAndroidClient
import com.bayevels.testandroid.data.dao.UserDao
import com.bayevels.testandroid.data.repository.utils.BaseRepository
import com.bayevels.testandroid.data.repository.utils.resultLiveData
import com.bayevels.testandroid.database
import kotlinx.coroutines.SupervisorJob

object UserRepository: BaseRepository<UserDao>() {
    override fun dao() = database.userDao()

    var job = SupervisorJob()

    val users = resultLiveData(
        databaseQuery = { dao().getAll() },
        networkCall = { getResult { TestAndroidClient.IMPL.getUsers() } },
        saveCallResult = { dao().insertAll(it) },
        job = job
    )

    fun cancelJobs(){
        job.cancel()
    }
}