package com.zaki.mvvm_base

import android.app.Application
import com.zaki.mvvm_base.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Developer : Mohammad Zaki
 * Created On : 08-03-2020
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

    private fun initializeKoin(){
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    repositoryModules,
                    storageModule,
                    viewModelModule,
                    managerModules
                )
            )
        }
    }

}