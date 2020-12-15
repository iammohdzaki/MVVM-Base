package com.zaki.mvvm_base.local

import android.content.Context
import com.google.gson.Gson
import com.zaki.mvvm_base.model.User
import com.zaki.mvvm_base.utils.DB_NAME

class SharedPreferencesStorage(context: Context) : Storage {

    private val sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }

    override fun setUser(user: User) {
        with(sharedPreferences.edit()) {
            val writeValueAsString = Gson().toJson(user)
            putString("user", writeValueAsString)
            apply()
        }
    }

    override fun getUser(): User? {
        return when (val user = sharedPreferences.getString("user", null)) {
            null -> null
            else -> {
                Gson().fromJson(user, User::class.java)
            }
        }
    }
}