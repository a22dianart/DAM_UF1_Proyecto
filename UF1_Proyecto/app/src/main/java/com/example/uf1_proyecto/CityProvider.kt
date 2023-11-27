package com.example.uf1_proyecto

import android.provider.Settings.Global.getString
import androidx.core.content.res.TypedArrayUtils

/**
 * Clase que vai ter toda a información das cidades que precisaremos mostrar
 */
class CityProvider {
    companion object{
        val cities = listOf<City>(
            City(
                "hfsjkfh",
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/santiago.jpg",
                "Summer"

            ),
            City("Seúl",
                "kjsjkf",
                "Summer",

            ),
            City(
                "Sevilla",
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/seville.jpg",
                "Autumn"
            ),
            City(
                "Barcelona",
                "@drawable/barcelona",
                "Autumn"
            ),
            City(
                "Madrid",
                "@drawable/madrid",
                "Autumn"
            ),
            City(
                "Málaga",
                "@drawable/malaga",
                "Winter"
            ),
            City(
                "jkbj",
                "jnscjsn",
                "Autumn"
            ),
            City(
                "dkhakf",
                "fkjjsfk",
                "Autumn"
            ),
            City(
                "hfkhsf",
                "sjdfkds",
                "Autumn"
            ),
            City(
                "Amsterdam",
                "ksfks",
                "Autumn"
            ),
            City(
                "sgfdgg",
                "vkjsjks",
                "Autumn"
            )


        )
    }
}