package com.zaki.mvvm_base.di.modules

import com.zaki.mvvm_base.utils.UserManager
import org.koin.dsl.module

val managerModules = module {
    single { UserManager(get()) }
}