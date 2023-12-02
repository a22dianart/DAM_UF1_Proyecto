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
                    getString(R.string.Amman),
                    "https://i.natgeofe.com/n/cb246f4f-035b-4054-9176-34936da16865/king-abdullah-mosque-amman-jordan.jpg",
                    getString(R.string.amman_best),
                    getString(R.string.amman_country),
                    getString(R.string.amman_description),
                    listOf(
                        getString(R.string.amman_activities1),
                        getString(R.string.amman_activities2),
                        getString(R.string.amman_activities3),
                        getString(R.string.amman_activities4),
                        getString(R.string.amman_activities5),
                        getString(R.string.amman_activities6)
                    ),
                    listOf(
                        getString(R.string.amman_places1),
                        getString(R.string.amman_places2),
                        getString(R.string.amman_places3),
                        getString(R.string.amman_places4),
                        getString(R.string.amman_places5),
                        getString(R.string.amman_places6)
                    ),
                    listOf(
                        getString(R.string.amman_typical1),
                        getString(R.string.amman_typical2),
                        getString(R.string.amman_typical3),
                        getString(R.string.amman_typical4)
                    ),
                    getString(R.string.amman_languages)
                )

            )



            this.cities= cities
            return cities
        }



}