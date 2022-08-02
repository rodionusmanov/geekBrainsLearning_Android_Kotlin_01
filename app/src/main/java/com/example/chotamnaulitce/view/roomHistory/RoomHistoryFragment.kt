package com.example.chotamnaulitce.view.roomHistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.chotamnaulitce.ChoTamNaUlitceApp
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.RoomHistoryFragmentBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.utils.conditionToRus
import com.example.chotamnaulitce.utils.convertWeatherEntityToWeather
import com.example.chotamnaulitce.utils.windDirectionToRus

class RoomHistoryFragment : DialogFragment() {

    private var _binding: RoomHistoryFragmentBinding? = null
    private val binding: RoomHistoryFragmentBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RoomHistoryFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Thread {
            ChoTamNaUlitceApp.getWeatherDatabase().weatherDAO()
                .getWeatherAll().let {
                    if (it.size > 0) {
                        for (i in it.size - 1 downTo 0) {
                            writeHistoryItem(convertWeatherEntityToWeather(it).get(i))
                        }
                        convertWeatherEntityToWeather(it).last()
                    } else {
                        getFailureHistory()
                    }
                }
        }.start()
        super.onViewCreated(view, savedInstanceState)
    }

    fun writeHistoryItem(weather: Weather) {
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text = weather.city.name
            textSize = 30f
        })
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text = "${weather.city.latitude} / ${weather.city.longitude}"
            textSize = 30f
        })
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text = "Температура: ${weather.temperatureActual} C"
            textSize = 30f
        })
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text = "Ощущается как: ${weather.temperatureFeels} C"
            textSize = 30f
        })
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text = "Влажность: ${weather.humidity} %"
            textSize = 30f
        })
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text = conditionToRus(weather.condition)
            textSize = 30f
        })
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text =
                "Ветер: направление - ${windDirectionToRus(weather.windDirection)} ${weather.windSpeed} м/с"
            textSize = 30f
        })
        binding.historyContainer.addView(TextView(requireContext()).apply {
            width = maxWidth
            height = 10
            setBackgroundColor(resources.getColor(R.color.black))
        })
    }

    private fun getFailureHistory() {
        binding.historyContainer.addView(TextView(requireContext()).apply {
            text = "История пуста"
            textSize = 30f
        })
    }
}