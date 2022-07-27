package com.example.chotamnaulitce.view.mapsGoogle

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.FragmentMapsWithInterfaceBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

class MapsFragment : Fragment() {

    private lateinit var map: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private var _binding: FragmentMapsWithInterfaceBinding? = null
    private val binding: FragmentMapsWithInterfaceBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapsWithInterfaceBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.maps_fragment) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        binding.buttonSearch.setOnClickListener {
            binding.searchAddress.text.toString().let { searchText ->
                val geocoder = Geocoder(requireContext())
                try {
                    val result = geocoder.getFromLocationName(searchText, 1)
                    setMarker(LatLng(result.first().latitude, result.first().longitude), searchText)
                    map.moveCamera(
                        CameraUpdateFactory.newLatLng(
                            LatLng(
                                result.first().latitude,
                                result.first().longitude
                            )
                        )
                    )
                } catch (e: IOException) {
                    Toast.makeText(requireContext(), "Запрос пуст", Toast.LENGTH_SHORT).show()
                } catch (e: NoSuchElementException) {
                    Toast.makeText(
                        requireContext(),
                        "Не удалось найти населенный пункт с таким названием",
                        Toast.LENGTH_SHORT
                    ).show()
                } finally {
                }
            }
        }
    }

    private fun setMarker(
        location: LatLng,
        searchString: String
    ): Marker {
        return map.addMarker(
            MarkerOptions()
                .position(location)
                .title(searchString)
        )
    }
}