package com.example.learnandroidx.databinding

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * @author    yiliyang
 * @date      20-12-11 下午1:58
 * @version   1.0
 * @since     1.0
 */
class RemoteService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        println("onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        println("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.apply {
            println(intent.getStringExtra("name"))
        } ?: println("no intent")
        return START_STICKY
    }

    override fun onDestroy() {
        println("service onDestroy")
        super.onDestroy()
    }
}