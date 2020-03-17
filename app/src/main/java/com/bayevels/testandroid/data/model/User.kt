package com.bayevels.testandroid.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(

    @PrimaryKey
    @SerializedName("id")
    var id: Long?,
    @ColumnInfo
    @SerializedName("name")
    var name: String?,
    @ColumnInfo
    @SerializedName("username")
    var username: String?,
    @ColumnInfo
    @SerializedName("email")
    var email: String?,
    @Embedded
    @SerializedName("address")
    var address: Address?,
    @ColumnInfo
    @SerializedName("phone")
    var phone: String?,
    @ColumnInfo
    @SerializedName("website")
    var website: String?,
    @Embedded
    @SerializedName("company")
    var company: Company?
)