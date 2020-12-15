package com.zaki.mvvm_base.utils

import com.zaki.mvvm_base.local.Storage
import com.zaki.mvvm_base.model.User
import org.koin.core.KoinComponent

class UserManager(private val storage: Storage) : KoinComponent {

    fun isUserLoggedIn(): Boolean {
        return storage.getUser() != null
    }

    fun setUser(user: User) {
        storage.setUser(user)
    }

    fun getUser(): User? {
        return storage.getUser()
    }

    fun setToken(token: String) {
        storage.setString("token", token)
    }

    fun getToken(): String {
        return storage.getString("token")
    }
}
