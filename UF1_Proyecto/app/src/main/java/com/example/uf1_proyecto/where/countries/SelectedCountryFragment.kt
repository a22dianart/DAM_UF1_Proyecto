package com.example.uf1_proyecto.where.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.uf1_proyecto.R

/**
 * A simple [Fragment] subclass.
 * Use the [SelectedCountryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectedCountryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_country, container, false)
    }


}