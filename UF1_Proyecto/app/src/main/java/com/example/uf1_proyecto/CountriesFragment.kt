package com.example.uf1_proyecto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uf1_proyecto.databinding.FragmentCountriesBinding


/**
 * Fragmento para mostrar todos os países que se atopan en CountryProviders
 */
class CountriesFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.recyclercountries.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CountryAdapter(CountryProvider.countries)
        binding.recyclercountries.adapter = adapter

        //PARA O DE BUSCAR
        binding.countriesFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Non fai nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredCountries = CountryProvider.countries.filter { country ->
                    country.name.contains(s.toString(), ignoreCase = true)
                }
                adapter.updateCountries(filteredCountries)

            }

            override fun afterTextChanged(s: Editable?) {
                // Non fai nada
            }
        })
        return view

    }
}