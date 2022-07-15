package com.example.chotamnaulitce.view.citieslist

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
import com.example.chotamnaulitce.viewmodel.citieslist.CitiesListViewModel
import com.example.chotamnaulitce.viewmodel.citieslist.CitiesListFragmentAppState

class CitiesListFragment : Fragment(), IOnItemClick {
    companion object {
        fun newInstance() = CitiesListFragment()
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

    private lateinit var viewModel: CitiesListViewModel
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
        viewModel = ViewModelProvider(this).get(CitiesListViewModel::class.java)
        viewModel?.let {
            it.getLiveData().observe(viewLifecycleOwner) { t -> renderData(t) }
        }

        binding.chooseLocationFloatingActionButton.setOnClickListener {
            showCitiesWithCorrectLocation()
        }
        showCitiesWithCorrectLocation()

    }

    private fun renderData(appState: CitiesListFragmentAppState) {
        val loadingLayout = requireActivity().findViewById<FrameLayout>(R.id.loading_layout)
        when (appState) {
            is CitiesListFragmentAppState.Error -> {
                loadingLayout.visibility = View.GONE
                Toast.makeText(requireContext(), "сломался, не отработал", Toast.LENGTH_SHORT)
                    .show()
            }
            CitiesListFragmentAppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
            is CitiesListFragmentAppState.SuccessSingle -> {
                loadingLayout.visibility = View.GONE
            }
            is CitiesListFragmentAppState.SuccessMulti -> {
                loadingLayout.visibility = View.GONE
                binding.citiesFragmentRecyclerView.adapter =
                    CitiesListAdapter(appState.weatherList, this)
            }
        }
    }

    override fun onItemClick(weather: Weather) {
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .hide(this)
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