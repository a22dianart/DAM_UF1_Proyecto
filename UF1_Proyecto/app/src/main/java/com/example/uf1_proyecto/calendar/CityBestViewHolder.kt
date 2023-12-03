package com.example.uf1_proyecto.calendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.databinding.ItemBestBinding
import com.example.uf1_proyecto.where.cities.City

class CityBestViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemBestBinding.bind(view)

    fun render(cityModel: City){
        binding.bestChoice.text=cityModel.name

    }

}