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
        private const val BUNDLE_WEATHER_EXTRA = "BWE_key"
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
        with(binding) {
            cityName.text = weather.city.name
            latitudeEntry.setText(weather.city.latitude.toString())
            longitudeEntry.setText(weather.city.longitude.toString())
            temperatureActualValue.setText(weather.temperatureActual.toString())
            temperatureFeelsValue.setText(weather.temperatureFeels.toString())
            humidityValue.setText(weather.humidity.toString())
            conditionValue.setText(weather.condition)
            windSpeedValue.setText(weather.windSpeed.toString())
            windDirectionValue.setText(weather.windDirection)
        }
    }
}