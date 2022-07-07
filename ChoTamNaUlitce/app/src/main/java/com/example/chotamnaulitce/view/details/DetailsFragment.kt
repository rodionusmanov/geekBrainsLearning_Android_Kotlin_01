package com.example.chotamnaulitce.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.databinding.DetailsWeatherFragmentBinding
import com.example.chotamnaulitce.domain.Weather

class DetailsFragment : Fragment() {
    companion object {
        const val BUNDLE_WEATHER_EXTRA = "BWE_key"
        fun newInstance(weather: Weather): DetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(BUNDLE_WEATHER_EXTRA, weather)
            val fr = DetailsFragment()
            fr.arguments = bundle
            return fr
        }
    }

    private var _binding: DetailsWeatherFragmentBinding? = null
    private val binding: DetailsWeatherFragmentBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

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
        if (weather != null) {
            renderData(weather as Weather)
        }
    }

    private fun renderData(weather: Weather) {
        binding.cityName.text = weather.city.name
        binding.latitudeEntry.setText(weather.city.latitude.toString())
        binding.longitudeEntry.setText(weather.city.longitude.toString())
        binding.temperatureActualValue.setText(weather.temperatureActual.toString())
        binding.temperatureFeelsValue.setText(weather.temperatureFeels.toString())
        binding.humidityValue.setText(weather.humidity.toString())
        binding.conditionValue.setText(weather.condition)
        binding.windSpeedValue.setText(weather.windSpeed.toString())
        binding.windDirectionValue.setText(weather.windDirection)
    }
}