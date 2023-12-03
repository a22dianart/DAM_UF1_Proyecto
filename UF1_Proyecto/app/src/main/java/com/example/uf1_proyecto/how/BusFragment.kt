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
import com.example.uf1_proyecto.databinding.FragmentBusBinding


class BusFragment : Fragment() {
    private var _binding: FragmentBusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusBinding.inflate(inflater, container, false)
        val view = binding.root
        //recycler
        binding.recyclerbus.layoutManager = LinearLayoutManager(requireContext())
        val mainactivity = requireActivity() as MainActivity
        val adapter = HowAdapter(mainactivity.pasarBusCompanies())
        binding.recyclerbus.adapter = adapter

        //PARA O DE BUSCAR
        binding.busFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Non fai nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredBus = mainactivity.busCompanies.filter { company ->
                    company.name.contains(s.toString(), ignoreCase = true)
                }
                adapter.updateCompanies(filteredBus)


            }

            override fun afterTextChanged(s: Editable?) {
                // Non fai nada
            }
        })
        return view
    }



}