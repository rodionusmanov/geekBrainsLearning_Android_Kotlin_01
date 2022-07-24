package com.example.chotamnaulitce

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chotamnaulitce.databinding.ActivityMainBinding
import com.example.chotamnaulitce.utils.isConnected
import com.example.chotamnaulitce.view.citieslist.CitiesListFragment
import com.example.chotamnaulitce.view.contacts.ContactsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contacts_fragment.*

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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contacts_menu, menu)
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