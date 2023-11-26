package com.example.uf1_proyecto

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import kotlin.properties.Delegates


class CityBestAdapter(private var citiesList:List<City>, private var calendar: CalendarView) : RecyclerView.Adapter<CityBestViewHolder>(){

    private lateinit var bestCitiesList: List<City>
    @RequiresApi(Build.VERSION_CODES.O)
    private var mes:Int = LocalDate.now().monthValue
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityBestViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CityBestViewHolder(layoutInflater.inflate(R.layout.item_best,parent,false));
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CityBestViewHolder, position: Int) {
        bestCitiesList = obtainBestCities(citiesList)
        val item = bestCitiesList[position]
        holder.render(item)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getItemCount(): Int { //tamaño do listado que imos ter
        bestCitiesList = obtainBestCities(citiesList)
        return bestCitiesList.size
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun obtainBestCities(cityList: List<City>): List<City> {

        val estacion = when (mes) {
            in 3..5 -> "Spring" //marzo, abril, maio
            in 6..8 -> "Summer" //xuño, xullo, agosto
            in 9..11 -> "Autumn" //setembro, outubro, novembro
            else -> "Winter" //decembro, xaneiro, febreiro
        }
        return cityList.filter { it.best == estacion }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun pasarMes(month: Int){
        mes=month+1
    }



}