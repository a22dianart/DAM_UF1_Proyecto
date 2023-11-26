package com.example.uf1_proyecto

/**
 * Clase que vai ter toda a información das cidades que precisaremos mostrar
 */
class CountryProvider {
    companion object{
        val countries = listOf<Country>(
            Country(
                "España",
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/spain.jpg"
            ),
            Country(
                "Portugal",
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/portugal.jpg"
            ),
            Country(
                "Italia",
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/italy.jpg"
            ),
            Country(
                "Francia",
                "https://raw.githubusercontent.com/a22dianart/DAM_UF1_Proyecto/main/UF1_Proyecto/app/src/main/res/drawable/france.jpg"
            )


        )
    }
}