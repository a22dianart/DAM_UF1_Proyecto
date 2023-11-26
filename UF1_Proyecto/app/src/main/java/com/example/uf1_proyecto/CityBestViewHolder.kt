package com.example.uf1_proyecto

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.databinding.ItemBestBinding
import com.example.uf1_proyecto.databinding.ItemCityBinding

class CityBestViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemBestBinding.bind(view)

    fun render(cityModel: City){
        binding.bestChoice.text=cityModel.name



    }

}