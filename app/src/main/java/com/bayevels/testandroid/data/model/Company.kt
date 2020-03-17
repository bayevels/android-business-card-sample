package com.bayevels.testandroid.data.model

import androidx.room.ColumnInfo

data class Company(
    @ColumnInfo(name = "company_name")
    var name: String?,
    var catchPhrase: String?,
    var bs: String?
)