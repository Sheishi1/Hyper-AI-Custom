package com.hyper.customai

import android.app.Application
import android.content.Context
import com.hyper.customai.di.initKoin
import org.koin.android.ext.koin.androidContext

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initKoin {
            androidContext(this@Application)
        }
    }

    companion object {
        private var instance: Application? = null

        fun getApplicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}