package com.example.uf1_proyecto


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CityViewHolder(view:View): RecyclerView.ViewHolder(view){

    val nameCity = view.findViewById<TextView>(R.id.cityName)
    val imageCity = view.findViewById<ImageView>(R.id.cityImage)
    fun render(cityModel: City){
        nameCity.text=cityModel.name
        Glide.with(imageCity.context).load(cityModel.photo).into(imageCity)



    }
}