package com.example.uf1_proyecto


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.databinding.ItemCityBinding
import com.example.uf1_proyecto.SelectedCityFragment
import com.example.uf1_proyecto.R




class CityViewHolder(view:View): RecyclerView.ViewHolder(view){

    val binding = ItemCityBinding.bind(view)

    //val nameCity = view.findViewById<TextView>(R.id.cityName)
    //val imageCity = view.findViewById<ImageView>(R.id.cityImage)
    fun render(cityModel: City){
        binding.cityName.text=cityModel.name
        Glide.with(binding.cityImage.context).load(cityModel.photo).into(binding.cityImage)

        binding.cityImage.setOnClickListener{
            Toast.makeText(binding.cityImage.context, cityModel.name, Toast.LENGTH_SHORT).show()

        }


    }

}