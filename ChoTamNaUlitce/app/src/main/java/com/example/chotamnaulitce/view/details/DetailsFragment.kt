package com.example.chotamnaulitce.view.details

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.BuildConfig.WEATHER_API_KEY
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.DetailsWeatherFragmentBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.utils.getLines
import com.example.chotamnaulitce.view.weatherlist.WeatherFrameFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

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

        val weather = arguments?.let { it.getParcelable<Weather>(BUNDLE_WEATHER_EXTRA) }

        weather?.let {
            val uri =
                URL("https://api.weather.yandex.ru/v2/informers?lat=${it.city.latitude}&lon=${it.city.longitude}")
            var weatherConnection: HttpsURLConnection? = null

            weatherConnection = uri.openConnection() as HttpsURLConnection
            weatherConnection.readTimeout = 5000
            weatherConnection.addRequestProperty("X-Yandex-API-Key", WEATHER_API_KEY)
            val handler = Handler(Looper.myLooper()!!)
            Thread {
                val reader = BufferedReader(InputStreamReader(weatherConnection.inputStream))

                val weatherDataTransferObject =
                    Gson().fromJson(getLines(reader), WeatherDataTransferObject::class.java)

                requireActivity().runOnUiThread {
                    renderData(it.apply {
                        temperatureActual = weatherDataTransferObject.fact.temp
                        temperatureFeels = weatherDataTransferObject.fact.feelsLike
                        humidity = weatherDataTransferObject.fact.humidity
                        condition = weatherDataTransferObject.fact.condition
                        windSpeed = weatherDataTransferObject.fact.windSpeed
                        windDirection = weatherDataTransferObject.fact.windDir
                    })
                }
            }.start()
        }




        if (weather != null) {
            renderData(weather as Weather)
        }
    }

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
            requireView().withAction(
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

    private fun conditionToRus(string:String):String{
        when (string){
            "clear" -> {return "ясно"}
            "partly-cloudy" -> {return "малооблачно"}
            "cloudy" -> {return "малооблачно с прояснениями"}
            "overcast" -> {return "пасмурно"}
            "drizzle" -> {return "морось"}
            "light-rain" -> {return "небольшой дождь"}
            "rain" -> {return "дождь"}
            "moderate-rain" -> {return "умеренно сильный дождь"}
            "heavy-rain" -> {return "сильный дождь"}
            "continuous-heavy-rain" -> {return " длительный сильный дождь"}
            "showers" -> {return "ливень"}
            "wet-snow" -> {return "дождь со снегом"}
            "light-snow" -> {return "небольшой снег"}
            "snow" -> {return "cнег"}
            "snow-showers" -> {return "снегопад"}
            "hail" -> {return " небольшой снег"}
            "thunderstorm" -> {return "гроза"}
            "thunderstorm-with-rain" -> {return "дождь с грозой"}
            "thunderstorm-with-hail" -> {return "гроза с градом"}
            else -> return "неизвестно"
        }
    }

    private fun windDirectionToRus(string:String):String{
        when (string){
            "n" -> {return "север"}
            "ne" -> {return "северо-восток"}
            "e" -> {return "восток"}
            "se" -> {return "юго-восток"}
            "s" -> {return "юг"}
            "sw" -> {return "юго-запад"}
            "w" -> {return "запад"}
            "nw" -> {return "северо-запад"}
            "c" -> {return "штиль"}
            else -> return "неизвестно"
        }
    }
}