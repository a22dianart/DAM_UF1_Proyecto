package com.example.uf1_proyecto

/**
 * Clase que vai ter toda a información das cidades que precisaremos mostrar
 */
class CityProvider {
    companion object{
        val cities = listOf<City>(
            City(
                R.string.album.toString(), //non funciona, devolve int --> Solucionar??
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/santiago.jpg"
            ),
            City(
                "Sevilla",
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/seville.jpg"
            ),
            City(
                "Barcelona",
                "@drawable/barcelona"
            ),
            City(
                "Madrid",
                "@drawable/madrid"
            ),
            City(
                "Málaga",
                "@drawable/malaga"
            )


        )
    }
}