package com.example.chotamnaulitce

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        pushNotification("token", token)
        super.onNewToken(token)
    }

    val CHANNEL_ID_HIGH_PRIORITY = "23rewfr"
    val NOTIFICATION_ID = 15

    fun pushNotification(title: String, text: String) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, CHANNEL_ID_HIGH_PRIORITY).apply {
            setContentTitle(title)
            setContentText(text)
            setSmallIcon(android.R.drawable.btn_dialog)
            priority = NotificationCompat.PRIORITY_HIGH

            val intent = Intent(applicationContext, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, 0)
            setContentIntent(pendingIntent)

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelHigh = NotificationChannel(
                CHANNEL_ID_HIGH_PRIORITY,
                "high",
                NotificationManager.IMPORTANCE_HIGH
            )
            channelHigh.description = "channel info"
            notificationManager.createNotificationChannel(channelHigh)
        }
        notificationManager.notify(NOTIFICATION_ID, notification.build())
    }
}