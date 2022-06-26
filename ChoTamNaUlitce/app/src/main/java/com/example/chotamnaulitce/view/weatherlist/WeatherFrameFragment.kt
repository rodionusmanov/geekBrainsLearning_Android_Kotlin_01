package com.example.chotamnaulitce.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.WeatherFragmentFrameBinding
import com.example.chotamnaulitce.viewmodel.AppState
import kotlin.random.Random

class WeatherFrameFragment : Fragment() {
    companion object {
        fun newInstance() = WeatherFrameFragment()
    }

    lateinit var binding: WeatherFragmentFrameBinding
    lateinit var viewModel: WeatherFrameViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WeatherFragmentFrameBinding.inflate(inflater)
        return binding.weatherFrameFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherFrameViewModel::class.java)
        viewModel.liveData.observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                renderData(t)
//                Toast.makeText(requireContext(), "$t отработал", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.sentRequest()

        val button = binding.buttonChoTam
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                viewModel.sentRequest()
            }
        })
    }



    private fun renderData(appState: AppState) {
        val loadingLayout = requireActivity().findViewById<FrameLayout>(R.id.loading_layout)
        when (appState) {
            is AppState.Error -> {loadingLayout.visibility = View.GONE
                Toast.makeText(requireContext(), "сломался, не отработал", Toast.LENGTH_SHORT).show()}
            AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                loadingLayout.visibility = View.GONE
                val result = appState.weatherData
                Toast.makeText(requireContext(), "$result отработал", Toast.LENGTH_SHORT).show()
            }
        }
    }
}