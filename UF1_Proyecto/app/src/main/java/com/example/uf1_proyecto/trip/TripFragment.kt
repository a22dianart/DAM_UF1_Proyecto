package com.example.uf1_proyecto.trip

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
        val adapter = TripAdapter(mainactivity.pasarViaxes(), mainactivity)
        if(mainactivity.pasarViaxes().isEmpty()){
            binding.noTrips.visibility=View.VISIBLE //non ocupa espazo nin é visible

        }else{
            binding.noTrips.visibility=View.GONE
        }

        binding.recyclertrips.adapter = adapter

        return view
    }


}