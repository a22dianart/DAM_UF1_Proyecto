package com.example.uf1_proyecto


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.databinding.ItemCityBinding
import com.example.uf1_proyecto.SelectedCityFragment
import com.example.uf1_proyecto.R




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