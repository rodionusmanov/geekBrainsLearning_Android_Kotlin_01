package com.example.chotamnaulitce

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.chotamnaulitce.databinding.ActivityMainBinding
import com.example.chotamnaulitce.utils.isConnected
import com.example.chotamnaulitce.view.citieslist.CitiesListFragment
import com.example.chotamnaulitce.view.contacts.ContactsFragment
import com.example.chotamnaulitce.view.mapsGoogle.MapsFragment
import com.example.chotamnaulitce.view.roomHistory.RoomHistoryFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(toolbar)

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkStateReceiver, filter)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.container, CitiesListFragment
                        .newInstance()
                ).commit()
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener {
            if (!it.isSuccessful) {
                return@OnCompleteListener
            }
            val token = it.result
            Log.d("keyToken",token)
            pushNotification("token, повторный вывод", token)
        })
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.contacts_item -> {
            supportFragmentManager.apply {
                beginTransaction()
                    .replace(R.id.container, (ContactsFragment()))
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
            true
        }
        R.id.room_history -> {
            val dialog = RoomHistoryFragment()
            dialog.show(supportFragmentManager, "history")
            true
        }
        R.id.maps -> {
            supportFragmentManager.apply {
                beginTransaction()
                    .replace(R.id.container, (MapsFragment()))
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private var networkStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val noConnectivity =
                intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
            if (!noConnectivity) {
                onConnectionFound()
            } else {
                onConnectionLost()
            }
        }
    }

    fun onConnectionLost() {
        toolbar.setNavigationIcon(android.R.drawable.presence_offline)
        isConnected = false
    }

    fun onConnectionFound() {
        toolbar.setNavigationIcon(android.R.drawable.presence_online)
        isConnected = true
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkStateReceiver)
    }
}