package com.example.chotamnaulitce.view.details

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.DetailsWeatherFragmentBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.utils.BUNDLE_LAT_KEY
import com.example.chotamnaulitce.utils.BUNDLE_WEATHER_DTO_KEY
import com.example.chotamnaulitce.utils.WAVE_KEY
import com.example.chotamnaulitce.view.weatherlist.WeatherFrameFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

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
    lateinit var weatherLocal: Weather
    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let {
                it.getParcelableExtra<WeatherDataTransferObject>(BUNDLE_WEATHER_DTO_KEY)
                    ?.let {
                        requireActivity().runOnUiThread {
                            renderData(weatherLocal.apply {
                                temperatureActual = it.fact.temp
                                temperatureFeels = it.fact.feelsLike
                                humidity = it.fact.humidity
                                condition = it.fact.condition
                                windSpeed = it.fact.windSpeed
                                windDirection = it.fact.windDir
                            })
                        }
                    }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(receiver)
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

        val weather = arguments?.let { it.getParcelable<Weather>(BUNDLE_WEATHER_EXTRA) }

        weather?.let {weatherLocal ->
            this.weatherLocal = weatherLocal
            LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
                receiver, IntentFilter(WAVE_KEY)
            )

            requireActivity().startService(
                Intent(
                    requireContext(),
                    DetailsServiceIntent::class.java
                ).apply {
                    putExtra(BUNDLE_LAT_KEY, weatherLocal.city.latitude)
                    putExtra(BUNDLE_LAT_KEY, weatherLocal.city.longitude)
                })
        }

        if (weather != null) {
            renderData(weather)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun renderData(weather: Weather) {
        with(binding) {
            cityName.text = weather.city.name
            latitudeEntry.setText(weather.city.latitude.toString())
            longitudeEntry.setText(weather.city.longitude.toString())
            temperatureActualValue.setText("${weather.temperatureActual} C")
            temperatureFeelsValue.setText("${weather.temperatureFeels} C")
            humidityValue.setText("${weather.humidity} %")
            conditionValue.setText(conditionToRus(weather.condition))
            windSpeedValue.setText("${weather.windSpeed} м/c")
            toTextField(windDirectionToRus(weather.windDirection), ::fieldToString)(
                windDirectionValue,
                windDirectionToRus(weather.windDirection)
            )
            view?.withAction(
                weather.city.name,
                getString(R.string.return_to_cities_list)
            ) {
                requireActivity()
                    .supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, WeatherFrameFragment.newInstance())
                    .commit()
            }
        }
    }

    private fun View.withAction(
        text: String,
        returnText: String,
        returnAction: () -> Unit
    ) {
        Snackbar.make(requireView(), text, Snackbar.LENGTH_INDEFINITE)
            .setAction(returnText) {
                returnAction()
            }.show()
    }


    private fun toTextField(
        textInput: Any,
        fToString: (Any) -> String
    ): (TextInputEditText, String) -> Unit {
        return ::returnToTextField
    }

    private fun fieldToString(field: Any): String {
        return field.toString()
    }

    private fun returnToTextField(value: TextInputEditText, string: String) {
        return value.setText(string)
    }

    private fun conditionToRus(string: String): String {
        when (string) {
            "clear" -> {
                return "ясно"
            }
            "partly-cloudy" -> {
                return "малооблачно"
            }
            "cloudy" -> {
                return "малооблачно с прояснениями"
            }
            "overcast" -> {
                return "пасмурно"
            }
            "drizzle" -> {
                return "морось"
            }
            "light-rain" -> {
                return "небольшой дождь"
            }
            "rain" -> {
                return "дождь"
            }
            "moderate-rain" -> {
                return "умеренно сильный дождь"
            }
            "heavy-rain" -> {
                return "сильный дождь"
            }
            "continuous-heavy-rain" -> {
                return " длительный сильный дождь"
            }
            "showers" -> {
                return "ливень"
            }
            "wet-snow" -> {
                return "дождь со снегом"
            }
            "light-snow" -> {
                return "небольшой снег"
            }
            "snow" -> {
                return "снег"
            }
            "snow-showers" -> {
                return "снегопад"
            }
            "hail" -> {
                return " небольшой снег"
            }
            "thunderstorm" -> {
                return "гроза"
            }
            "thunderstorm-with-rain" -> {
                return "дождь с грозой"
            }
            "thunderstorm-with-hail" -> {
                return "гроза с градом"
            }
            else -> return "неизвестно"
        }
    }

    private fun windDirectionToRus(string: String): String {
        return when (string) {
            "n" -> {
                "север"
            }
            "ne" -> {
                "северо-восток"
            }
            "e" -> {
                "восток"
            }
            "se" -> {
                "юго-восток"
            }
            "s" -> {
                "юг"
            }
            "sw" -> {
                "юго-запад"
            }
            "w" -> {
                "запад"
            }
            "nw" -> {
                "северо-запад"
            }
            "c" -> {
                "штиль"
            }
            else -> "неизвестно"
        }
    }
}