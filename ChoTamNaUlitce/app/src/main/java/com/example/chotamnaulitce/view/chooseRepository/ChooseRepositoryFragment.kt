package com.example.chotamnaulitce.view.chooseRepository

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.chotamnaulitce.ChoTamNaUlitceApp
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.utils.REPOSITORY_CHOSEN
import com.example.chotamnaulitce.utils.chosenRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.repository_radiobutton_fragment.*

class ChooseRepositoryFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.repository_radiobutton_fragment, container, false)
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
val textInputRepository = requireActivity().findViewById<TextInputEditText>(R.id.repository_state_text_input)
        super.onViewCreated(view, savedInstanceState)

        repository_okhttp.setOnClickListener{
            chosenRepository = 1
            textInputRepository.setText(resources.getString(R.string.OkHTTP))
            saveRepositoryState(weatherSharedPreferences)
            dismiss()
        }

        repository_retrofit.setOnClickListener{
            chosenRepository = 2
            textInputRepository.setText(resources.getString(R.string.Retrofit))
            saveRepositoryState(weatherSharedPreferences)
            dismiss()
        }

        repository_room.setOnClickListener{
            chosenRepository = 3
            textInputRepository.setText(resources.getString(R.string.Room))
            saveRepositoryState(weatherSharedPreferences)
            dismiss()
        }

        repository_local.setOnClickListener{
            chosenRepository = 4
            textInputRepository.setText(resources.getString(R.string.Local))
            saveRepositoryState(weatherSharedPreferences)
            dismiss()
        }
    }

    private fun saveRepositoryState(weatherSharedPreferences:SharedPreferences){
        weatherSharedPreferences.edit().apply {
            putInt(REPOSITORY_CHOSEN, chosenRepository)
            apply()
        }
    }
}