package com.example.uf1_proyecto.trip


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.MainActivity
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.FragmentTripBinding
import com.example.uf1_proyecto.databinding.ItemCityBinding
import com.example.uf1_proyecto.databinding.ItemCountryBinding
import com.example.uf1_proyecto.databinding.ItemTripBinding
import com.example.uf1_proyecto.where.countries.Country

class TripViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemTripBinding.bind(view)
    val view2 = view

    lateinit var mainActivity:MainActivity

    fun setActivity(mainActivity: MainActivity){
        this.mainActivity=mainActivity

    }
    fun render(tripModel: Trip){

        binding.tripName.text=mainActivity.tripName()+tripModel.name
        var actividades = tripModel.activities
        if (actividades != null) {
            binding.groupActivities1.text= actividades[0]
            binding.groupActivities2.text= actividades[1]
            binding.groupActivities3.text= actividades[2]
            binding.groupActivities4.text= actividades[3]
            binding.groupActivities5.text= actividades[4]
            binding.groupActivities6.text= actividades[5]
        }
        Glide.with(binding.cityImage.context).load(tripModel.photo).into(binding.cityImage)

        binding.eraseButton.setOnClickListener{
            mainActivity.tripList.removeIf { trip -> trip.id == tripModel.id }
            render(tripModel)

        }
    }
}