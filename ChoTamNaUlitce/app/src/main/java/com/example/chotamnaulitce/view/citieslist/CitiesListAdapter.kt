package com.example.chotamnaulitce.view.citieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chotamnaulitce.databinding.WeatherFragmentFrameRecyclerItemBinding
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.view.details.IOnItemClick

class CitiesListAdapter(private val dataList: List<Weather>, private val callback: IOnItemClick) :
    RecyclerView.Adapter<CitiesListAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding =
            WeatherFragmentFrameRecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
        return WeatherViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(weather: Weather) {
            WeatherFragmentFrameRecyclerItemBinding.bind(itemView).apply {
                cityNameRecyclerItem.text = weather.city.name
                root.setOnClickListener {
                    callback.onItemClick(weather)
                }
            }
        }
    }
}