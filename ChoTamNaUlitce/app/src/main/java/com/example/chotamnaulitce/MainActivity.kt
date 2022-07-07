package com.example.chotamnaulitce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chotamnaulitce.databinding.ActivityMainBinding
import com.example.chotamnaulitce.view.weatherlist.WeatherFrameFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.container, WeatherFrameFragment
                        .newInstance()
                ).commit()
        }
    }
}