package com.example.uf1_proyecto.where.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R


class CountryAdapter(private var countriesList:List<Country>) : RecyclerView.Adapter<CountryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(layoutInflater.inflate(R.layout.item_country,parent,false));
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = countriesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int { //tamaño do listado que imos ter
        return countriesList.size
    }
    fun updateCountries(countriesList : List<Country>){
        this.countriesList = countriesList
        notifyDataSetChanged()

    }



}