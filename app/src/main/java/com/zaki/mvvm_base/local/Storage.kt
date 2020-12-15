package com.zaki.mvvm_base.local

import com.zaki.mvvm_base.model.User

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
    fun setUser(user: User)
    fun getUser() : User?
}