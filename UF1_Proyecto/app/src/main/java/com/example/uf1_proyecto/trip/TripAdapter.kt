package com.example.uf1_proyecto.trip



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.MainActivity
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.FragmentTripBinding

import java.util.List;


class TripAdapter(private var tripsList: kotlin.collections.List<Trip>, private var mainActivity: MainActivity, private var fragment: TripFragment) : RecyclerView.Adapter<TripViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var tripViewHolder= TripViewHolder(layoutInflater.inflate(R.layout.item_trip,parent,false))
        tripViewHolder.setActivity(mainActivity)
        tripViewHolder.setFragmento(fragment)
        return tripViewHolder
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val item = tripsList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int { //tamaño do listado que imos ter
        return tripsList.size
    }
    fun updateTrips(tripsList :
                    kotlin.collections.List<Trip>){
        this.tripsList = tripsList
        notifyDataSetChanged()


    }



}