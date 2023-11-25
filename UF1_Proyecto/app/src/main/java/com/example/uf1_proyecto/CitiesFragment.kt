package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CitiesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CitiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cities, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclercities)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CityAdapter(CityProvider.cities) // Necesitarás crear un adaptador según tus necesidades
        recyclerView.adapter = adapter

        return view
    }




}