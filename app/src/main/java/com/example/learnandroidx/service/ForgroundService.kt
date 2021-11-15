package com.example.learnandroidx.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi

/**
 * @author    yiliyang
 * @date      20-11-12 下午3:26
 * @version   1.0
 * @since     1.0
 */
@RequiresApi(Build.VERSION_CODES.O)
class ForgroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "channel";
        val channelName = "default channel"
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_MIN)
        notificationManager.createNotificationChannel(channel)
        val notification = Notification.Builder(this, channelId).apply {
            setContentTitle("notification title")
            setOngoing(false)
        }
        startForeground(0x1, notification.build())
        startForegroundService(Intent(this, CancelForgroundService::class.java))
    }
}