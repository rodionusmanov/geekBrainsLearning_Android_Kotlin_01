package com.example.chotamnaulitce.view.details

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.DetailsWeatherFragmentBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.view.citieslist.CitiesListFragment
import com.example.chotamnaulitce.viewmodel.details.DetailsFragmentAppState
import com.example.chotamnaulitce.viewmodel.details.DetailsViewModel
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

    private val viewModel by lazy {
        ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    private lateinit var weatherLocal: Weather
    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
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

        weather?.let { weatherLocal ->
            this.weatherLocal = weatherLocal
            viewModel.getWeather(weatherLocal)
            viewModel.getLiveData().observe(viewLifecycleOwner) {
                renderData(it)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun renderData(detailsFragmentAppState: DetailsFragmentAppState) {

        when (detailsFragmentAppState) {
            is DetailsFragmentAppState.Error -> {}
            DetailsFragmentAppState.Loading -> {}
            is DetailsFragmentAppState.Success -> {
                with(binding) {
                    val weather = detailsFragmentAppState.weatherData
                    cityName.text = weather.city.name
                    latitudeEntry.setText(weatherLocal.city.latitude.toString())
                    longitudeEntry.setText(weatherLocal.city.longitude.toString())
                    temperatureActualValue.setText("${detailsFragmentAppState.weatherData.temperatureActual} C")
                    temperatureFeelsValue.setText("${detailsFragmentAppState.weatherData.temperatureFeels} C")
                    humidityValue.setText("${detailsFragmentAppState.weatherData.humidity} %")
                    conditionValue.setText(conditionToRus(detailsFragmentAppState.weatherData.condition))
                    windSpeedValue.setText("${detailsFragmentAppState.weatherData.windSpeed} м/c")
                    toTextField(
                        windDirectionToRus(detailsFragmentAppState.weatherData.windDirection),
                        ::fieldToString
                    )(
                        windDirectionValue,
                        windDirectionToRus(detailsFragmentAppState.weatherData.windDirection)
                    )
                    view?.withAction(
                        weatherLocal.city.name,
                        getString(R.string.return_to_cities_list)
                    ) {
                        requireActivity()
                            .supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, CitiesListFragment.newInstance())
                            .commit()
                    }

                    val imageLoader = ImageLoader.Builder(requireContext())
                    .components {
                        add(SvgDecoder.Factory())
                    }
                    .build()
                    conditionImageView.load("https://yastatic.net/weather/i/icons/funky/dark/${detailsFragmentAppState.weatherData.icon}.svg", imageLoader){
                        placeholder(android.R.drawable.ic_lock_idle_alarm)
                        error(android.R.drawable.ic_delete)
                    }
                }
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
            "clear" -> return "ясно"
            "partly-cloudy" -> return "малооблачно"
            "cloudy" -> return "малооблачно с прояснениями"
            "overcast" -> return "пасмурно"
            "drizzle" -> return "морось"
            "light-rain" -> return "небольшой дождь"
            "rain" -> return "дождь"
            "moderate-rain" -> return "умеренно сильный дождь"
            "heavy-rain" -> return "сильный дождь"
            "continuous-heavy-rain" -> return " длительный сильный дождь"
            "showers" -> return "ливень"
            "wet-snow" -> return "дождь со снегом"
            "light-snow" -> return "небольшой снег"
            "snow" -> return "снег"
            "snow-showers" -> return "снегопад"
            "hail" -> return " небольшой снег"
            "thunderstorm" -> return "гроза"
            "thunderstorm-with-rain" -> return "дождь с грозой"
            "thunderstorm-with-hail" -> return "гроза с градом"
            else -> return "неизвестно"
        }
    }

    private fun windDirectionToRus(string: String): String {
        return when (string) {
            "n" -> "север"
            "ne" -> "северо-восток"
            "e" -> "восток"
            "se" -> "юго-восток"
            "s" -> "юг"
            "sw" -> "юго-запад"
            "w" -> "запад"
            "nw" -> "северо-запад"
            "c" -> "штиль"
            else -> "неизвестно"
        }
    }
}