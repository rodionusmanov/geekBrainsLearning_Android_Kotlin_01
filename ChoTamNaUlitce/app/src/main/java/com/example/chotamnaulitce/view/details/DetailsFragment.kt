package com.example.chotamnaulitce.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.databinding.DetailsWeatherFragmentBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.view.weatherlist.WeatherFrameFragment
import com.example.chotamnaulitce.view.weatherlist.WeatherFrameViewModel

class DetailsFragment : Fragment() {
    companion object {
        val BUNDLE_WEATHER_EXTRA = "BWE_key"
        fun newInstance(weather: Weather): DetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(BUNDLE_WEATHER_EXTRA, weather)
            val fr = DetailsFragment()
            fr.arguments = bundle
            return fr
        }
    }

    var locationSwitchForFAB = 1

    private var _binding: DetailsWeatherFragmentBinding? = null
    private val binding: DetailsWeatherFragmentBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    lateinit var viewModel: WeatherFrameViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsWeatherFragmentBinding.inflate(inflater)
        return binding.weatherDetailsFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = arguments?.get(BUNDLE_WEATHER_EXTRA)
        if (weather != null){
            renderData(weather as Weather)
        }
    }

    private fun renderData(weather: Weather) {
        binding.cityName.text = weather.city.name
        binding.latitudeEntry.setText(weather.city.latitude.toString())
        binding.longtitudeEntry.setText(weather.city.longtitude.toString())
        binding.temperatureActualValue.text = weather.temperatureActual.toString()
        binding.temperatureFeelsValue.text = weather.temperatureFeels.toString()
    }
}