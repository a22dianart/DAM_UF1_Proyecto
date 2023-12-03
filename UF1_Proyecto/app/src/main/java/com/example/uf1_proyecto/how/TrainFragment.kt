package com.example.uf1_proyecto.how

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uf1_proyecto.MainActivity
import com.example.uf1_proyecto.databinding.FragmentTrainBinding


class TrainFragment : Fragment() {
    private var _binding: FragmentTrainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrainBinding.inflate(inflater, container, false)
        val view = binding.root
        //recycler
        binding.recyclertrain.layoutManager = LinearLayoutManager(requireContext())
        val mainactivity = requireActivity() as MainActivity
        val adapter = HowAdapter(mainactivity.pasarTrainCompanies())
        binding.recyclertrain.adapter = adapter

        //PARA O DE BUSCAR
        binding.trainFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Non fai nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredCities = mainactivity.trainCompanies.filter { company ->
                    company.name.contains(s.toString(), ignoreCase = true)
                }
                adapter.updateCompanies(filteredCities)


            }

            override fun afterTextChanged(s: Editable?) {
                // Non fai nada
            }
        })
        return view
    }



}