package com.example.chotamnaulitce

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.chotamnaulitce.utils.CHANNEL_ID_HIGH_PRIORITY
import com.example.chotamnaulitce.utils.NOTIFICATION_ID
import com.example.chotamnaulitce.utils.NOTIFICATION_KEY_BODY
import com.example.chotamnaulitce.utils.NOTIFICATION_KEY_TITLE
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        pushNotification("token", token)
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val data = message.data
        val title = data[NOTIFICATION_KEY_TITLE]
        val body = data[NOTIFICATION_KEY_BODY]
        if (!title.isNullOrEmpty() && !body.isNullOrEmpty()) {
            pushNotification(title, body)
        }
        super.onMessageReceived(message)
    }

    private fun pushNotification(title: String, text: String) {
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