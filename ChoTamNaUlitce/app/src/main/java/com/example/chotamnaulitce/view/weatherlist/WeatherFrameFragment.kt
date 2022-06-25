package com.example.chotamnaulitce.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chotamnaulitce.databinding.WeatherFragmentFrameBinding
import com.example.chotamnaulitce.viewmodel.AppState

class WeatherFrameFragment : Fragment() {
    companion object {
        fun newInstance() = WeatherFrameFragment()
    }

    lateinit var binding : WeatherFragmentFrameBinding
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
        viewModel.liveData.observe(viewLifecycleOwner, object : Observer<AppState>{
            override fun onChanged(t: AppState) {
                Toast.makeText(requireContext(), "Success отработал", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.sentRequest()
    }
}