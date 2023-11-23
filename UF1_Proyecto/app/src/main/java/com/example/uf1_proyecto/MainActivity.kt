package com.example.uf1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //PARA A BARRA DE ARRIBA
        //Facer que a nosa barra de actividade sexa a barra principal
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)  //hai que seleccionar o toolbar de google
        setSupportActionBar(toolbar)

        //Host de navegación (grafo asociado)
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //Configuracion da barra de navegacion(toolbar)
        val builderApp = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builderApp.build()

        toolbar.setupWithNavController(navController, appBarConfiguration)

        //PARA A BARRA DE ABAIXO(bottombar)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setupWithNavController(navController) //levanos a inbox se lle damos para atrass

        //PANEL LATERAL
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        builderApp.setOpenableLayout(drawerLayout)

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


}