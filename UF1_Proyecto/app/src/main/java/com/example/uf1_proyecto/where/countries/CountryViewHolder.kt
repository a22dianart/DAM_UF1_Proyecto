package com.example.uf1_proyecto.where.countries

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.ItemCityBinding
import com.example.uf1_proyecto.databinding.ItemCountryBinding
import com.example.uf1_proyecto.where.countries.Country

class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemCountryBinding.bind(view)
    val view2 = view

    fun render(countryModel: Country){
        binding.countryName.text=countryModel.name
        Glide.with(binding.countryImage.context).load(countryModel.photo).into(binding.countryImage)



        binding.countryImage.setOnClickListener{

            val bundle = Bundle()
            bundle.putString("countryName", countryModel.name)

            view2.findNavController().navigate(R.id.action_countriesFragment_to_selectedCountryFragment, bundle)
        }
    }
}