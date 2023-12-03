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

import com.example.uf1_proyecto.databinding.FragmentStayBinding


class StayFragment : Fragment() {
    private var _binding: FragmentStayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStayBinding.inflate(inflater, container, false)
        val view = binding.root
        //recycler
        binding.recyclerstay.layoutManager = LinearLayoutManager(requireContext())
        val mainactivity = requireActivity() as MainActivity
        val adapter = HowAdapter(mainactivity.pasarStayCompanies())
        binding.recyclerstay.adapter = adapter

        //PARA O DE BUSCAR
        binding.stayFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Non fai nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredStay = mainactivity.stayCompanies.filter { company ->
                    company.name.contains(s.toString(), ignoreCase = true)
                }
                adapter.updateCompanies(filteredStay)


            }

            override fun afterTextChanged(s: Editable?) {
                // Non fai nada
            }
        })
        return view
    }



}