package com.example.uf1_proyecto.where.cities

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.MainActivity
import com.example.uf1_proyecto.databinding.FragmentSelectedCityBinding
import com.example.uf1_proyecto.trip.Trip


class SelectedCityFragment : Fragment() {
    private var _binding: FragmentSelectedCityBinding? = null
    private val binding get() = _binding!!



    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectedCityBinding.inflate(inflater, container, false)
        val view = binding.root
        val mainactivity = requireActivity() as MainActivity

        // Recupera el nombre de la ciudad del argumento
        val ciudades: List<City> = mainactivity.pasarCidades()
        val cityName = arguments?.getString("cityName")!!
        val cidade = obtainCity(ciudades, cityName)!! //vai estar si ou si xa que fixen click sobre esa cidade

        binding.collapsingToolbar.title=cidade.name
        Glide.with(binding.placeImage.context).load(cidade.photo).into(binding.placeImage) //cargamos a imaxe de internet
        binding.descriptionPlace.text=cidade.description

        //Poñemos as actividades
        binding.activity1txt.text=cidade.activities.get(0)
        binding.activity2txt.text=cidade.activities.get(1)
        binding.activity3txt.text=cidade.activities.get(2)
        binding.activity4txt.text=cidade.activities.get(3)
        binding.activity5txt.text=cidade.activities.get(4)
        binding.activity6txt.text=cidade.activities.get(5)

        //Poñemos os sitios
        binding.place1txt.text=cidade.places.get(0)
        binding.place2txt.text=cidade.places.get(1)
        binding.place3txt.text=cidade.places.get(2)
        binding.place4txt.text=cidade.places.get(3)
        binding.place5txt.text=cidade.places.get(4)
        binding.place6txt.text=cidade.places.get(5)


        //Poñemos a comida
        binding.typical1txt.text=cidade.typical.get(0)
        binding.typical2txt.text=cidade.typical.get(1)
        binding.typical3txt.text=cidade.typical.get(2)
        binding.typical4txt.text=cidade.typical.get(3)


        //Para poñer o texto que di o páis no que está e as linguas que se falan
        val configuration = resources.configuration
        val lingua = configuration.locales[0].language

        val pais = cidade.country
        val linguas =cidade.languages
        if (lingua.equals("gl")){
            binding.countryAndLanguages.text="Está en $pais e fálase $linguas"
        }else if (lingua.equals("es")){
            binding.countryAndLanguages.text="Está en $pais y se habla $linguas"
        } else{
            binding.countryAndLanguages.text="It is in $pais and people speak $linguas"
        }



        binding.addButton.setOnClickListener{
            var mensaxe : String
            if (lingua.equals("gl")){
                mensaxe="$cityName engadido a As miñas viaxes"
            }else if (lingua.equals("es")){
               mensaxe="$cityName añadido a Mis viajes"
            } else{
               mensaxe="$cityName added to My trips"
            }
            val sharedPreferences=MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()

            val numTrips = sharedPreferences.getInt("numTrips", 0)
            val numTrip =numTrips+1

            editor.putInt("numTrips", numTrip)
            editor.putString("name$numTrip", cityName)
            editor.putString("photo$numTrip", cidade.photo)
            val numActivities = 6
            for (activityIndex in 1..numActivities) {
                val activity = "$activityIndex"+"activities"
                val selectedActivity="selected$activityIndex"+"Activity"
                editor.putString("$activity$numTrip", cidade.activities[activityIndex-1])
                editor.putInt("$selectedActivity$numTrip", -1)
            }
            //valores que ainda non se saben
            editor.putInt("dayStart$numTrip", -1 )
            editor.putInt("monthStart$numTrip", -1)
            editor.putInt("yearStart$numTrip", -1)
            editor.putInt("dayEnd$numTrip", -1)
            editor.putInt("monthEnd$numTrip", -1)
            editor.putInt("yearEnd$numTrip", -1)
            editor.putInt("transport$numTrip",-1)
            editor.putString("stay$numTrip", "")
            editor.putString("notes$numTrip", "")

            editor.apply()

            Toast.makeText(binding.addButton.context, mensaxe, Toast.LENGTH_SHORT).show()

        }

        return view
    }

    /**
     * Función para obter a cidade na que fixemos click
     */
    fun obtainCity(ciudades: List<City>, nombre: String): City? {
        return ciudades.find { it.name == nombre }
    }

}