package com.bayevels.testandroid.data.api

import com.bayevels.testandroid.data.model.User
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class UsersAdapter: JsonDeserializer<List<User>> {

    override fun deserialize(json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<User> {
        val items = ArrayList<User>()
        json?.let {
            val itemsJsonArray = it.asJsonArray
            itemsJsonArray.forEach {jsonElement ->
                val jsonObject = jsonElement.asJsonObject
                val id = jsonObject.get("id").asLong
                val name = jsonObject.get("name").asString
                items.add(User(id = id, name = name,address = null, company = null, email = null, phone = null, username = null, website = null))
            }
        }
        return items
    }
}