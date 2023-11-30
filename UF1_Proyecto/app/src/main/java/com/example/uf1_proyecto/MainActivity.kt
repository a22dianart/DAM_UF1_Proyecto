package com.example.uf1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    public lateinit var cities : List<City>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //PARA A BARRA DE ARRIBA (toolbar)
        setSupportActionBar(binding.toolbar) //hai que seleccionar o toolbar de google

        //Host de navegación (grafo asociado)
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //Configuracion da barra de navegacion(toolbar)
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(binding.drawerLayout) //PANEL LATERAL


        val appBarConfiguration = AppBarConfiguration( //facemos que estos fragmentos sexan tamén principal, para que non apareza o botón de ir para atrás
            setOf(
                R.id.calendarFragment,
                R.id.mapsFragment,
                R.id.helpFragment
            ), binding.drawerLayout
        )
        builder.build()



        //asociamos un grafo a todas as partes
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.onNavDestinationSelected(item, navController)
                ||super.onOptionsItemSelected(item)
    }
        fun pasarCidades(): List<City> {
            val cities = listOf<City>(
                City(
                    getString(R.string.how),
                    "fisfh",
                    "Summer"

                ),
                City(
                    "Seúl",
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
            this.cities= cities
            return cities
        }



}