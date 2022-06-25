package com.example.chotamnaulitce.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.databinding.WeatherFragmentFrameBinding

class WeatherFragment : Fragment() {
    companion object {
        fun newInstance() = WeatherFragment()
    }

    lateinit var binding : WeatherFragmentFrameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WeatherFragmentFrameBinding.inflate(inflater)
        return binding.root
    }

}