package com.visuallatam.besafe.Activity

import com.facebook.drawee.backends.pipeline.Fresco
import android.app.Application

class Application : Application(){
    companion object {
        lateinit var instance: com.visuallatam.besafe.Activity.Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this)
    }
}