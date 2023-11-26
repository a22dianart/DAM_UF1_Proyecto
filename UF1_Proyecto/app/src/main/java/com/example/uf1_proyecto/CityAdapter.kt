package com.example.uf1_proyecto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CityAdapter(private var citiesList:List<City>) : RecyclerView.Adapter<CityViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CityViewHolder(layoutInflater.inflate(R.layout.item_city,parent,false));
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val item = citiesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int { //tamaño do listado que imos ter
        return citiesList.size
    }
    fun updateCities(citiesList : List<City>){
        this.citiesList = citiesList
        notifyDataSetChanged()

    }



}