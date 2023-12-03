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
import com.example.uf1_proyecto.databinding.FragmentBoatBinding


class BoatFragment : Fragment() {
    private var _binding: FragmentBoatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBoatBinding.inflate(inflater, container, false)
        val view = binding.root
        //recycler
        binding.recyclerboat.layoutManager = LinearLayoutManager(requireContext())
        val mainactivity = requireActivity() as MainActivity
        val adapter = HowAdapter(mainactivity.pasarBoatCompanies())
        binding.recyclerboat.adapter = adapter

        //PARA O DE BUSCAR
        binding.boatFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Non fai nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredCompanies = mainactivity.boatCompanies.filter { company ->
                    company.name.contains(s.toString(), ignoreCase = true)
                }
                adapter.updateCompanies(filteredCompanies)


            }

            override fun afterTextChanged(s: Editable?) {
                // Non fai nada
            }
        })
        return view
    }



}