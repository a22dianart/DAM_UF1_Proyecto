package com.example.uf1_proyecto.how

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R


class HowAdapter(private var companiesList:List<Company>) : RecyclerView.Adapter<HowViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HowViewHolder(layoutInflater.inflate(R.layout.item_button,parent,false));
    }

    override fun onBindViewHolder(holder: HowViewHolder, position: Int) {
        val item = companiesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int { //tamaño do listado que imos ter
        return companiesList.size
    }

    //para o filtro
    fun updateCompanies(companiesList: List<Company>){
        this.companiesList = companiesList
        notifyDataSetChanged()

    }



}