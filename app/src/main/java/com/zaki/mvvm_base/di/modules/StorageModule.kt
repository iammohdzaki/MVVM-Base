package com.zaki.mvvm_base.di.modules

import com.zaki.mvvm_base.local.SharedPreferencesStorage
import com.zaki.mvvm_base.local.Storage
import org.koin.dsl.module

val storageModule = module {
    single { SharedPreferencesStorage(get()) as Storage }
}