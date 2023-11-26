package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



/**
 * A simple [Fragment] subclass.
 * Use the [SelectedCityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectedCityFragment : Fragment() {

    companion object {
        fun newInstance(nameCity: String): SelectedCityFragment {
            val fragment = SelectedCityFragment()
            val args = Bundle()
            args.putString("nameCity", nameCity)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_city, container, false)
    }


}