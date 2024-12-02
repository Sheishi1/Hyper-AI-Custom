package com.hyper.customai

import android.app.Application
import com.hyper.customai.di.initKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}