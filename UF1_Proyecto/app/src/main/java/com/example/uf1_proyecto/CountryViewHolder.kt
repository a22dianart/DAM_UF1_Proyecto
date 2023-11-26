package com.example.uf1_proyecto

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){

    val nameCountry = view.findViewById<TextView>(R.id.countryName)
    val imageCountry = view.findViewById<ImageView>(R.id.countryImage)
    fun render(countryModel: Country){
        nameCountry.text=countryModel.name
        Glide.with(imageCountry.context).load(countryModel.photo).into(imageCountry)

    }
}