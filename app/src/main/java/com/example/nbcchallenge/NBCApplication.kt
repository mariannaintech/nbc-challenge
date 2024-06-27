package com.example.nbcchallenge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.getstream.log.Priority
import io.getstream.log.android.AndroidStreamLogger

@HiltAndroidApp
class NBCApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidStreamLogger.installOnDebuggableApp(
            application = this,
            minPriority = Priority.VERBOSE
        )
    }
}