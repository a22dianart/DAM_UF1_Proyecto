package com.example.uf1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.uf1_proyecto.databinding.ActivityMainBinding
import com.example.uf1_proyecto.how.Company
import com.example.uf1_proyecto.trip.Trip
import com.example.uf1_proyecto.where.cities.City
import com.example.uf1_proyecto.where.countries.Country

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    public lateinit var cities : List<City>
    public lateinit var countries : List<Country>
    public lateinit var planeCompanies: List<Company>
    public lateinit var trainCompanies: List<Company>
    public lateinit var busCompanies: List<Company>
    public lateinit var boatCompanies: List<Company>
    public lateinit var stayCompanies: List<Company>
    public lateinit var tripList: MutableList<Trip>

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
                R.id.tripFragment
            ), binding.drawerLayout
        )
        builder.build()

        //cambiando o estilo do bottom navigation
        binding.bottomNavigation.itemIconSize=80

        //lista
        tripList= mutableListOf()


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
                    getString(R.string.amman_languages),
                    31.8359454,
                    35.7824803


                )

            )




            this.cities= cities
            return cities
        }

    fun pasarPaises(): List<Country> {
        val countries = listOf<Country>(
            Country(
                getString(R.string.Albania),
                "https://img2.rtve.es/i/?w=1600&i=1637232083339.jpg",
                getString(R.string.albania_description),
                listOf(
                    getString(R.string.albania_activities1),
                    getString(R.string.albania_activities2),
                    getString(R.string.albania_activities3),
                    getString(R.string.albania_activities4),
                    getString(R.string.albania_activities5),
                    getString(R.string.albania_activities6)
                ),
                listOf(
                    getString(R.string.albania_places1),
                    getString(R.string.albania_places2),
                    getString(R.string.albania_places3),
                    getString(R.string.albania_places4),
                    getString(R.string.albania_places5),
                    getString(R.string.albania_places6)
                ),
                listOf(
                    getString(R.string.albania_typical1),
                    getString(R.string.albania_typical2),
                    getString(R.string.albania_typical3),
                    getString(R.string.albania_typical4)
                    ),
                getString(R.string.albania_languages)
            )

        )



        this.countries= countries
        return countries
    }
    fun pasarPlaneCompanies(): List<Company>{

        val planeCompanies = listOf<Company>(
            Company(
                "Iberia",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Logotipo_de_Iberia.svg/400px-Logotipo_de_Iberia.svg.png",
                 "https://www.iberia.com/?language=en&cq_src=google_ads&cq_cmp=224138906&cq_con=12961709546&cq_term=iberia%20airline&cq_med=&cq_plac=&cq_net=g&cq_plt=gp&gad_source=1&gclid=Cj0KCQiA67CrBhC1ARIsACKAa8Sc7EghifporTgBmVDvAH_GAMGmYcgNb457GU7joOamERdxeIT2B4waAgx8EALw_wcB",
            )

        )
        this.planeCompanies = planeCompanies
        return planeCompanies

    }

    fun pasarTrainCompanies(): List<Company>{

        val trainCompanies = listOf<Company>(
            Company(
                "Renfe",
                "https://seeklogo.com/images/R/Renfe-logo-5CB197E185-seeklogo.com.png",
                "https://www.renfe.com/es/es",
            )

        )
        this.trainCompanies = trainCompanies
        return trainCompanies

    }

    fun pasarBusCompanies(): List<Company>{

        val busCompanies = listOf<Company>(
            Company(
                "Monbus",
                "https://appmonbus.kramagot.com/img/logo/monbus.png",
                "https://www.monbus.es/es"
            )
        )
        this.busCompanies=busCompanies
        return busCompanies
    }

    fun pasarBoatCompanies(): List<Company>{

        val boatCompanies = listOf<Company>(
            Company(
                "Direct Ferries",
                "https://theme.zdassets.com/theme_assets/10427784/920a70a52bf6b26aa43a060a276e3da7f4622c72.png",
                "https://www.directferries.es"
            )
        )
        this.boatCompanies=boatCompanies
        return boatCompanies
    }

    fun pasarStayCompanies(): List<Company>{
        val stayCompanies = listOf(
            Company(
                "Booking",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Booking.com_logo.svg/2560px-Booking.com_logo.svg.png",
                "https://www.booking.com/?aid=2230195"
            )
        )
        this.stayCompanies=stayCompanies
        return stayCompanies
    }


        fun tripName(): String {

            val configuration = resources.configuration
            val lingua = configuration.locales[0].language
            var tripName: String
            if (lingua.equals("gl")) {
                tripName = "Viaxe a "
            } else if (lingua.equals("es")) {
                tripName = "Viaje a "
            } else {
                tripName = "Trip to "
            }
            return tripName

        }

    fun pasarViaxes(): List<Trip>{
//        val tripList = listOf(
//            Trip(
//                id = 1,
//                name = "Paris",
//                photo = "https://png.pngtree.com/background/20230612/original/pngtree-wolf-animals-images-wallpaper-for-pc-384x480-picture-image_3180467.jpg",
//                activities = listOf("Visit Eiffel Tower", "Louvre Museum", "Cruise on Seine River", "4", "5", "6")
//            ),
//            Trip(
//                id = 2,
//                name = "Beach Vacation",
//                photo = "https://ethic.es/wp-content/uploads/2023/03/imagen.jpg",
//                activities = listOf("algo"," algo2", "algo3", "algo4", "algo5", "algo6")
//            )
//        )
        return this.tripList

    }
    fun addViaxe(trip: Trip){
        this.tripList.add(trip)

    }







}