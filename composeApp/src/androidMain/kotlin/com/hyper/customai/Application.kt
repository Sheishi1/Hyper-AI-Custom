package com.hyper.customai

import android.app.Application
import com.hyper.customai.di.initKoin
import org.koin.android.ext.koin.androidContext

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@Application)
        }
    }

    fun getContext(): Application {
        return this
    }
}