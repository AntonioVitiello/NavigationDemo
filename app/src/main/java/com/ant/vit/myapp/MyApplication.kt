package com.ant.vit.myapp

import android.app.Application
import android.content.Context

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class MyApplication: Application() {
    companion object {
        lateinit var staticApplicationContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        staticApplicationContext = applicationContext
    }
}