package com.bayevels.testandroid.data.repository.utils

import retrofit2.Call
import timber.log.Timber

abstract class BaseRepository<Dao> {
    abstract fun dao(): Dao

    protected suspend fun <T> getResult(call: suspend () -> Call<T>): Result<T> {
        try {
            val response = call.invoke().execute()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            val message = " ${response.code()} ${response.message()}"
            Timber.e(message)
            return error(message)
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.error("Network call has failed for a following reason: $message")
    }
}