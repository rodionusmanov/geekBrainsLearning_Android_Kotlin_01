package com.example.chotamnaulitce.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.WeatherFragmentFrameBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.view.details.DetailsFragment
import com.example.chotamnaulitce.view.details.IOnItemClick
import com.example.chotamnaulitce.viewmodel.AppState

class WeatherFrameFragment : Fragment(), IOnItemClick {
    companion object {
        fun newInstance() = WeatherFrameFragment()
    }

    private var locationSwitchForFAB = 1

    private var _binding: WeatherFragmentFrameBinding? = null
    private val binding: WeatherFragmentFrameBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private lateinit var viewModel: WeatherFrameViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WeatherFragmentFrameBinding.inflate(inflater)
        return binding.weatherFrameFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherFrameViewModel::class.java)
        viewModel.run {
            getLiveData().observe(viewLifecycleOwner) { t -> renderData(t) }
        }

        binding.chooseLocationFloatingActionButton.setOnClickListener {
            showCitiesWithCorrectLocation()
        }
        showCitiesWithCorrectLocation()

    }

    private fun renderData(appState: AppState) {
        val loadingLayout = requireActivity().findViewById<FrameLayout>(R.id.loading_layout)
        when (appState) {
            is AppState.Error -> {
                loadingLayout.visibility = View.GONE
                Toast.makeText(requireContext(), "сломался, не отработал", Toast.LENGTH_SHORT)
                    .show()
            }
            AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
            is AppState.SuccessSingle -> {
                loadingLayout.visibility = View.GONE
            }
            is AppState.SuccessMulti -> {
                loadingLayout.visibility = View.GONE
                binding.citiesFragmentRecyclerView.adapter =
                    WeatherListAdapter(appState.weatherList, this)
            }
        }
    }

    override fun onItemClick(weather: Weather) {
        requireActivity()
            .supportFragmentManager
            .beginTransaction().hide(this)
            .add(R.id.container, DetailsFragment.newInstance(weather))
            .addToBackStack(null)
            .commit()
    }

    private fun showCitiesWithCorrectLocation() {
        if (locationSwitchForFAB == 1) {
            viewModel.getWeatherListForRus()
            binding.chooseLocationFloatingActionButton.setImageResource(R.drawable.rus)
        } else {
            viewModel.getWeatherListForWorld()
            binding.chooseLocationFloatingActionButton.setImageResource(R.drawable.earth)
        }
        locationSwitchForFAB = (locationSwitchForFAB + 1) % 2
    }
}