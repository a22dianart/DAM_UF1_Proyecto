package com.example.uf1_proyecto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uf1_proyecto.databinding.FragmentCitiesBinding



/**
 * Fragmento para mostrar todas as cidades que se atopan en CityProviderS
 */
class CitiesFragment : Fragment() {
    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCitiesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.recyclercities.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CityAdapter(CityProvider.cities)
        binding.recyclercities.adapter = adapter

        //PARA O DE BUSCAR
        binding.citiesFilter.addTextChangedListener(object : TextWatcher {
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