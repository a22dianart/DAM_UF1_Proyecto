package com.example.uf1_proyecto.where.cities


import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.ItemCityBinding
import com.example.uf1_proyecto.where.cities.City


class CityViewHolder(view:View): RecyclerView.ViewHolder(view){

    val binding = ItemCityBinding.bind(view)
    val view2 = view

    fun render(cityModel: City){
        binding.cityName.text=cityModel.name
        Glide.with(binding.cityImage.context).load(cityModel.photo).into(binding.cityImage)


        binding.cityImage.setOnClickListener{


            val bundle = Bundle()
            bundle.putString("cityName", cityModel.name)

            view2.findNavController().navigate(R.id.action_citiesFragment_to_selectedCityFragment, bundle)
        }


    }
}