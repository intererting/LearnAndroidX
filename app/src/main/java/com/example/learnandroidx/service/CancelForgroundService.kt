package com.example.learnandroidx.service

import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.annotation.RequiresApi

/**
 * @author    yiliyang
 * @date      20-11-12 下午3:43
 * @version   1.0
 * @since     1.0
 */
@RequiresApi(Build.VERSION_CODES.O)
class CancelForgroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "channel";
        val notification = Notification.Builder(this, channelId).apply {
            setContentTitle("notification title")
            setOngoing(false)
        }
        startForeground(0x1, notification.build())
        Handler(Looper.getMainLooper()).postDelayed({
            stopForeground(true)
            notificationManager.cancel(0x1)
            stopSelf()
        }, 2000)

    }
}