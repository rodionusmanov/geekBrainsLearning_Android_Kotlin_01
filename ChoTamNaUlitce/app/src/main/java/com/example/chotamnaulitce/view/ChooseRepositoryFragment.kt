package com.example.chotamnaulitce.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.ChoTamNaUlitceApp
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.RepositoryRadiobuttonFragmentBinding
import com.example.chotamnaulitce.utils.LOCATION_CITIES_LIST
import com.example.chotamnaulitce.utils.REPOSITORY_CHOSEN
import com.example.chotamnaulitce.utils.chosenRepository
import com.example.chotamnaulitce.view.citieslist.CitiesListFragment
import kotlinx.android.synthetic.main.repository_radiobutton_fragment.*

class ChooseRepositoryFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var rootView : View = inflater.inflate(R.layout.repository_radiobutton_fragment, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val weatherSharedPreferences = ChoTamNaUlitceApp.getChoTamNaUlitce()
            .getSharedPreferences("Prefs", Context.MODE_PRIVATE)

        when (chosenRepository) {
            1 -> {repository_okhttp.isChecked = true}
            2 -> {repository_retrofit.isChecked = true}
            3 -> {repository_room.isChecked = true}
            4 -> {repository_local.isChecked = true}
        }

        super.onViewCreated(view, savedInstanceState)

        repository_okhttp.setOnClickListener{
            chosenRepository = 1
            Toast.makeText(requireContext(),"OkHTTP",Toast.LENGTH_SHORT).show()
            saveRepositoryState(weatherSharedPreferences)
            dismiss()

        }

        repository_retrofit.setOnClickListener{
            chosenRepository = 2
            Toast.makeText(requireContext(),"Retrofit",Toast.LENGTH_SHORT).show()
            saveRepositoryState(weatherSharedPreferences)
            dismiss()
        }

        repository_room.setOnClickListener{
            chosenRepository = 3
            Toast.makeText(requireContext(),"Room",Toast.LENGTH_SHORT).show()
            saveRepositoryState(weatherSharedPreferences)
            dismiss()
        }

        repository_local.setOnClickListener{
            chosenRepository = 4
            Toast.makeText(requireContext(),"Local",Toast.LENGTH_SHORT).show()
            saveRepositoryState(weatherSharedPreferences)
            dismiss()
        }
    }

    fun saveRepositoryState(weatherSharedPreferences:SharedPreferences){
        weatherSharedPreferences.edit().apply {
            putInt(REPOSITORY_CHOSEN, chosenRepository)
            apply()
        }
    }
}