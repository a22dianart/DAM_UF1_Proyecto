package com.example.uf1_proyecto.trip

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uf1_proyecto.MainActivity
import com.example.uf1_proyecto.databinding.FragmentTripBinding


class TripFragment : Fragment() {

    private var _binding: FragmentTripBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTripBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.recyclertrips.layoutManager = LinearLayoutManager(requireContext())

        val mainactivity = requireActivity() as MainActivity
        //mainactivity.pasarViaxes()
        val adapter = TripAdapter(getTrips(mainactivity), mainactivity, this)
        showMessageNoTrips(mainactivity)
        binding.recyclertrips.adapter = adapter

        return view
    }

    fun getTrips(mainActivity: MainActivity): MutableList<Trip> {
        val sharedPreferences=MainActivity.sharedPreferences!!
        val numTrips = sharedPreferences.getInt("numTrips", 0)
        var tripList: MutableList<Trip> = mutableListOf()
        if(numTrips!=0){
            for (tripIndex in 1..numTrips) {
                val id = tripIndex
                val name = sharedPreferences.getString("name$tripIndex", "")!!
                val photo =sharedPreferences.getString("photo$tripIndex", "")!!

                var activitiesList: MutableList<String> = mutableListOf()
                for (activityIndex in 1..6) {
                    val unit = "$activityIndex"+"activities"
                    val activity = sharedPreferences.getString("$unit$tripIndex", "")!!
                    activitiesList.add(activity)

                }
                val selected1Activity = sharedPreferences.getInt("selected1Activity$tripIndex", -1)
                val selected2Activity = sharedPreferences.getInt("selected2Activity$tripIndex", -1)
                val selected3Activity = sharedPreferences.getInt("selected3Activity$tripIndex", -1)
                val selected4Activity = sharedPreferences.getInt("selected4Activity$tripIndex", -1)
                val selected5Activity = sharedPreferences.getInt("selected5Activity$tripIndex", -1)
                val selected6Activity = sharedPreferences.getInt("selected6Activity$tripIndex", -1)

                val dayStart= sharedPreferences.getInt("dayStart$tripIndex", -1)
                val monthStart =sharedPreferences.getInt("monthStart$tripIndex", -1)
                val yearStart= sharedPreferences.getInt("yearStart$tripIndex", -1)
                val dayEnd =sharedPreferences.getInt("dayEnd$tripIndex", -1)
                val monthEnd= sharedPreferences.getInt("monthEnd$tripIndex", -1)
                val yearEnd = sharedPreferences.getInt("yearEnd$tripIndex", -1)
                val transport = sharedPreferences.getInt("transport$tripIndex", -1)
                val stay = sharedPreferences.getString("stay$tripIndex", "")
                val notes = sharedPreferences.getString("notes$tripIndex", "")


                val trip = Trip(id, name, photo, activitiesList, selected1Activity,selected2Activity, selected3Activity, selected4Activity, selected5Activity, selected6Activity, dayStart, monthStart, yearStart, dayEnd, monthEnd, yearEnd, transport,stay, notes)

                tripList.add(trip)
            }
        }

        return tripList


    }

    fun showMessageNoTrips(mainActivity: MainActivity){
        if(getTrips(mainActivity).isEmpty()){
            binding.noTrips.visibility=View.VISIBLE //non ocupa espazo nin é visible

        }else{
            binding.noTrips.visibility=View.GONE
        }


    }


}