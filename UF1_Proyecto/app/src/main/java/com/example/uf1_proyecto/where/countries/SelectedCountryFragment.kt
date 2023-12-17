package com.example.uf1_proyecto.where.countries

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.MainActivity
import com.example.uf1_proyecto.trip.Trip
import com.example.uf1_proyecto.databinding.FragmentSelectedCountryBinding


class SelectedCountryFragment : Fragment() {
    private var _binding: FragmentSelectedCountryBinding? = null
    private val binding get() = _binding!!



    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectedCountryBinding.inflate(inflater, container, false)
        val view = binding.root
        val mainactivity = requireActivity() as MainActivity

        // Recupera el nombre de la ciudad del argumento
        val paises: List<Country> = mainactivity.pasarPaises()
        val countryName = arguments?.getString("countryName")!!
        val pais = obtainCountry(paises, countryName)!! //vai estar si ou si xa que fixen click sobre ese pais

        binding.collapsingToolbar.title=pais.name
        Glide.with(binding.placeImage.context).load(pais.photo).into(binding.placeImage) //cargamos a imaxe de internet
        binding.descriptionPlace.text=pais.description

        //Poñemos as actividades
        binding.activity1txt.text=pais.activities.get(0)
        binding.activity2txt.text=pais.activities.get(1)
        binding.activity3txt.text=pais.activities.get(2)
        binding.activity4txt.text=pais.activities.get(3)
        binding.activity5txt.text=pais.activities.get(4)
        binding.activity6txt.text=pais.activities.get(5)

        //Poñemos os sitios
        binding.place1txt.text=pais.places.get(0)
        binding.place2txt.text=pais.places.get(1)
        binding.place3txt.text=pais.places.get(2)
        binding.place4txt.text=pais.places.get(3)
        binding.place5txt.text=pais.places.get(4)
        binding.place6txt.text=pais.places.get(5)


        //Poñemos a comida
        binding.typical1txt.text=pais.typical.get(0)
        binding.typical2txt.text=pais.typical.get(1)
        binding.typical3txt.text=pais.typical.get(2)
        binding.typical4txt.text=pais.typical.get(3)


        //Para poñer o texto que di o páis no que está e as linguas que se falan
        val configuration = resources.configuration
        val lingua = configuration.locales[0].language

        val linguas =pais.languages
        if (lingua.equals("gl")){
            binding.languages.text="Fálase $linguas"
        }else if (lingua.equals("es")){
            binding.languages.text="Se habla $linguas"
        } else{
            binding.languages.text="People speak $linguas"
        }



        binding.addButton.setOnClickListener{
            var mensaxe : String
            if (lingua.equals("gl")){
                mensaxe="$countryName engadido a As miñas viaxes"
            }else if (lingua.equals("es")){
                mensaxe="$countryName añadido a Mis viajes"
            } else{
                mensaxe="$countryName added to My trips"
            }

            val sharedPreferences=MainActivity.sharedPreferences!!
            val editor = sharedPreferences.edit()

            val numTrips = sharedPreferences.getInt("numTrips", 0)
            val numTrip =numTrips+1

            editor.putInt("numTrips", numTrip)
            editor.putString("name$numTrip", countryName)
            editor.putString("photo$numTrip", pais.photo)
            val numActivities = 6
            for (activityIndex in 1..numActivities) {
                val activity = "$activityIndex"+"activities"
                val selectedActivity="selected$activityIndex"+"Activity"
                editor.putString("$activity$numTrip", pais.activities[activityIndex-1])
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
    fun obtainCountry(paises: List<Country>, nombre: String): Country? {
        return paises.find { it.name == nombre }
    }

}