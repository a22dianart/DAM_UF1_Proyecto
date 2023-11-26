package com.example.uf1_proyecto

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
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


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cities, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclercities)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CityAdapter(CityProvider.cities)
        recyclerView.adapter = adapter
        //PARA O DE BUSCAR
        val filter : EditText = view.findViewById(R.id.citiesFilter)
        filter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Non fai nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredCities = CityProvider.cities.filter { city ->
                    city.name.contains(s.toString(), ignoreCase = true)
                }
                adapter.updateCities(filteredCities)

            }

            override fun afterTextChanged(s: Editable?) {
                // Non fai nada
            }
        })


        return view
    }




}