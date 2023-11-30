package com.example.uf1_proyecto

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uf1_proyecto.databinding.FragmentCalendarBinding
import com.example.uf1_proyecto.databinding.FragmentCitiesBinding
import java.time.LocalDate
import java.util.Locale


/**
 * Fragmento principal. Contén un calendario e os mellores destinos
 */
class CalendarFragment : Fragment() {
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val view = binding.root
        //recycler
        binding.recyclerbetterplaces.layoutManager = LinearLayoutManager(requireContext())
        val mainactivity = requireActivity() as MainActivity
        val adapter = CityBestAdapter(mainactivity.pasarCidades(), binding.calendarView)
        binding.recyclerbetterplaces.adapter = adapter

        //edit text segun lingua que se esté usando no móbil
        val configuration = resources.configuration
        val lingua = configuration.locales[0].language

        val mesActual = LocalDate.now().monthValue
        val diaActual = LocalDate.now().dayOfMonth
        val anoActual = LocalDate.now().year
        val mes:String
        val texto: String
        if (lingua.equals("gl")){
            mes = when (mesActual) {
                1 -> "Xaneiro"
                2 -> "Febreiro"
                3 -> "Marzo"
                4 -> "Abril"
                5 -> "Maio"
                6 -> "Xuño"
                7 -> "Xullo"
                8 -> "Agosto"
                9 -> "Setembro"
                10 -> "Outubro"
                11-> "Novembro"
                else -> "Decembro"
            }
            texto ="Hoxe é o $diaActual de $mes de $anoActual"
        }else if (lingua.equals("es")){
            mes = when (mesActual) {
                1 -> "Enero"
                2 -> "Febrero"
                3 -> "Marzo"
                4 -> "Abril"
                5 -> "Mayo"
                6 -> "Junio"
                7 -> "Julio"
                8 -> "Agosto"
                9 -> "Septiembre"
                10 -> "Octubre"
                11-> "Noviembre"
                else -> "Diciembre"

            }
            texto ="Hoy es el $diaActual de $mes de $anoActual"

        }else{ //o móbil podería estar en inglés ou en outro idioma(por ddefecto colle o inglés)
            mes = when (mesActual) {
                1 -> "January"
                2 -> "February"
                3 -> "March"
                4 -> "April"
                5 -> "May"
                6 -> "June"
                7 -> "July"
                8 -> "August"
                9 -> "September"
                10 -> "October"
                11-> "November"
                else -> "December"
            }
            texto ="Today is $mes $diaActual, $anoActual"

        }
        binding.calendarView.setOnDateChangeListener{view, year, month, dayOfMonth ->
            adapter.pasarMes(month)
            adapter.notifyDataSetChanged()
        }



        binding.TodayTextView.setText(texto)
        return view
    }

}