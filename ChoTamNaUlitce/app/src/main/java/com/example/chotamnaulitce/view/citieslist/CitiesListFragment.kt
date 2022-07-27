package com.example.chotamnaulitce.view.citieslist

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chotamnaulitce.ChoTamNaUlitceApp
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.WeatherFragmentFrameBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.utils.LOCATION_CITIES_LIST
import com.example.chotamnaulitce.utils.REPOSITORY_CHOSEN
import com.example.chotamnaulitce.utils.REQUEST_CODE_READ_CONTACTS
import com.example.chotamnaulitce.utils.chosenRepository
import com.example.chotamnaulitce.view.chooseRepository.ChooseRepositoryFragment
import com.example.chotamnaulitce.view.details.DetailsFragment
import com.example.chotamnaulitce.view.details.IOnItemClick
import com.example.chotamnaulitce.viewmodel.citieslist.CitiesListFragmentAppState
import com.example.chotamnaulitce.viewmodel.citieslist.CitiesListViewModel

class CitiesListFragment : Fragment(), IOnItemClick {
    companion object {
        fun newInstance() = CitiesListFragment()
    }

    private val weatherSharedPreferences = ChoTamNaUlitceApp.getChoTamNaUlitce()
        .getSharedPreferences("Prefs", Context.MODE_PRIVATE)
    private var locationSwitchForFAB = weatherSharedPreferences.getInt(LOCATION_CITIES_LIST, 1)

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

        chosenRepository = weatherSharedPreferences.getInt(REPOSITORY_CHOSEN, 4)
        viewModel = ViewModelProvider(this).get(CitiesListViewModel::class.java)
        viewModel.let {
            it.getLiveData().observe(viewLifecycleOwner) { t -> renderData(t) }
        }

        binding.chooseLocationFloatingActionButton.setOnClickListener {
            locationSwitchForFAB = (locationSwitchForFAB + 1) % 2
            weatherSharedPreferences.edit().apply {
                putInt(LOCATION_CITIES_LIST, locationSwitchForFAB)
                apply()
            }
            showCitiesWithCorrectLocation()
        }
        showCitiesWithCorrectLocation()
        weatherSharedPreferences.edit().apply {
            putInt(LOCATION_CITIES_LIST, locationSwitchForFAB)
            apply()
        }

        binding.chooseRepositoryFloatingActionButton.setOnClickListener {
            val dialog = ChooseRepositoryFragment()
            dialog.show(requireActivity().supportFragmentManager, "repo")
        }

        binding.mapLocationFloatingActionButton.setOnClickListener {
            checkPermission(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private val REQUEST_CODE_LOCATION = 666

    private fun permissionRequest(permission: String) {
        requestPermissions(arrayOf(permission), REQUEST_CODE_LOCATION)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_LOCATION) {
            for (permsIndex in permissions.indices) {
                if (permissions[permsIndex] == Manifest.permission.ACCESS_FINE_LOCATION && grantResults[permsIndex] == PackageManager.PERMISSION_GRANTED) {
                    getLocation()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun checkPermission(perm : String) {
        val permResult = ContextCompat.checkSelfPermission(
            requireContext(),
            perm
        )
        PackageManager.PERMISSION_GRANTED
        if (permResult == PackageManager.PERMISSION_GRANTED) {
            getLocation()
        } else if (shouldShowRequestPermissionRationale(perm)) {
            AlertDialog.Builder(requireContext())
                .setTitle("Доступ к геоданным")
                .setMessage("Запрос на доступ к геоданным. В случае отказа, доступ можно будет предоставить только в настройках приложения.")
                .setPositiveButton("Открыть окно предоставления доступа") { _, _ ->
                    permissionRequest(perm)
                }
                .setNegativeButton("Отказать в запросе") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        } else {
            permissionRequest(perm)
            AlertDialog.Builder(requireContext())
                .setTitle("Доступ к геоданным")
                .setMessage("Доступ к геоданным отсутствует. Доступ можно будет предоставить только в настройках приложения.")
                .setPositiveButton("Закрыть сообщение") { dialog, _ ->
                    dialog.dismiss()

                    requireActivity().supportFragmentManager.apply {
                        beginTransaction()
                            .replace(R.id.container, (CitiesListFragment()))
                            .addToBackStack(null)
                            .commitAllowingStateLoss()
                    }
                }
                .create()
                .show()
        }
    }

    private fun getLocation() {
        val locationManager =
            requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            val criteria = Criteria()
            criteria.accuracy = Criteria.ACCURACY_FINE
            val provider = locationManager.getBestProvider(criteria, true)
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0L,
                1000F,
                object : LocationListener {
                    override fun onLocationChanged(location: Location) {
                        Toast.makeText(requireContext(), "${location.latitude} / ${location.longitude}", Toast.LENGTH_SHORT).show()
                    }
                })
        }
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
    }
}