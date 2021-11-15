package com.example.learnandroidx

import android.app.Application
import kotlin.properties.Delegates

/**
 * @author    yiliyang
 * @date      20-12-31 上午9:22
 * @version   1.0
 * @since     1.0
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val metrics = resources.displayMetrics
        metrics.scaledDensity = 5f
        instance = this
    }

    companion object {

        private var instance by Delegates.notNull<MyApplication>()

        fun getApplicationInstance(): MyApplication {
            return instance
        }
    }
}