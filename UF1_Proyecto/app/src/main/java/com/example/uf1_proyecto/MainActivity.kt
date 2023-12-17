package com.example.uf1_proyecto

import android.content.Context
import android.content.SharedPreferences
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
    companion object{
        var sharedPreferences: SharedPreferences? = null

    }

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




        //asociamos un grafo a todas as partes
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)

        if(sharedPreferences==null){
            sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        }




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
                    getString(R.string.amman_photo),
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
                    getString(R.string.amman_latitude).toDouble(),
                    getString(R.string.amman_longitude).toDouble()


                ),
                City(
                    getString(R.string.Madrid),
                    getString(R.string.madrid_photo),
                    getString(R.string.madrid_best),
                    getString(R.string.madrid_country),
                    getString(R.string.madrid_description),
                    listOf(
                        getString(R.string.madrid_activities1),
                        getString(R.string.madrid_activities2),
                        getString(R.string.madrid_activities3),
                        getString(R.string.madrid_activities4),
                        getString(R.string.madrid_activities5),
                        getString(R.string.madrid_activities6)
                    ),
                    listOf(
                        getString(R.string.madrid_places1),
                        getString(R.string.madrid_places2),
                        getString(R.string.madrid_places3),
                        getString(R.string.madrid_places4),
                        getString(R.string.madrid_places5),
                        getString(R.string.madrid_places6)
                    ),
                    listOf(
                        getString(R.string.madrid_typical1),
                        getString(R.string.madrid_typical2),
                        getString(R.string.madrid_typical3),
                        getString(R.string.madrid_typical4)
                    ),
                    getString(R.string.madrid_languages),
                    getString(R.string.madrid_latitude).toDouble(),
                    getString(R.string.madrid_longitude).toDouble()
                ),
                City(
                    getString(R.string.NewYork),
                    getString(R.string.newyork_photo),
                    getString(R.string.newyork_best),
                    getString(R.string.newyork_country),
                    getString(R.string.newyork_description),
                    listOf(
                        getString(R.string.newyork_activities1),
                        getString(R.string.newyork_activities2),
                        getString(R.string.newyork_activities3),
                        getString(R.string.newyork_activities4),
                        getString(R.string.newyork_activities5),
                        getString(R.string.newyork_activities6)
                    ),
                    listOf(
                        getString(R.string.newyork_places1),
                        getString(R.string.newyork_places2),
                        getString(R.string.newyork_places3),
                        getString(R.string.newyork_places4),
                        getString(R.string.newyork_places5),
                        getString(R.string.newyork_places6)
                    ),
                    listOf(
                        getString(R.string.newyork_typical1),
                        getString(R.string.newyork_typical2),
                        getString(R.string.newyork_typical3),
                        getString(R.string.newyork_typical4)
                    ),
                    getString(R.string.newyork_languages),
                    getString(R.string.newyork_latitude).toDouble(),
                    getString(R.string.newyork_longitude).toDouble()
                ),
                City(
                    getString(R.string.Tokyo),
                    getString(R.string.tokyo_photo),
                    getString(R.string.tokyo_best),
                    getString(R.string.tokyo_country),
                    getString(R.string.tokyo_description),
                    listOf(
                        getString(R.string.tokyo_activities1),
                        getString(R.string.tokyo_activities2),
                        getString(R.string.tokyo_activities3),
                        getString(R.string.tokyo_activities4),
                        getString(R.string.tokyo_activities5),
                        getString(R.string.tokyo_activities6)
                    ),
                    listOf(
                        getString(R.string.tokyo_places1),
                        getString(R.string.tokyo_places2),
                        getString(R.string.tokyo_places3),
                        getString(R.string.tokyo_places4),
                        getString(R.string.tokyo_places5),
                        getString(R.string.tokyo_places6)
                    ),
                    listOf(
                        getString(R.string.tokyo_typical1),
                        getString(R.string.tokyo_typical2),
                        getString(R.string.tokyo_typical3),
                        getString(R.string.tokyo_typical4)
                    ),
                    getString(R.string.tokyo_languages),
                    getString(R.string.tokyo_latitude).toDouble(),
                    getString(R.string.tokyo_longitude).toDouble()
                ),
                City(
                    getString(R.string.London),
                    getString(R.string.london_photo),
                    getString(R.string.london_best),
                    getString(R.string.london_country),
                    getString(R.string.london_description),
                    listOf(
                        getString(R.string.london_activities1),
                        getString(R.string.london_activities2),
                        getString(R.string.london_activities3),
                        getString(R.string.london_activities4),
                        getString(R.string.london_activities5),
                        getString(R.string.london_activities6)
                    ),
                    listOf(
                        getString(R.string.london_places1),
                        getString(R.string.london_places2),
                        getString(R.string.london_places3),
                        getString(R.string.london_places4),
                        getString(R.string.london_places5),
                        getString(R.string.london_places6)
                    ),
                    listOf(
                        getString(R.string.london_typical1),
                        getString(R.string.london_typical2),
                        getString(R.string.london_typical3),
                        getString(R.string.london_typical4)
                    ),
                    getString(R.string.london_languages),
                    getString(R.string.london_latitude).toDouble(),
                    getString(R.string.london_longitude).toDouble()
                ),
                City(
                    getString(R.string.Cairo),
                    getString(R.string.cairo_photo),
                    getString(R.string.cairo_best),
                    getString(R.string.cairo_country),
                    getString(R.string.cairo_description),
                    listOf(
                        getString(R.string.cairo_activities1),
                        getString(R.string.cairo_activities2),
                        getString(R.string.cairo_activities3),
                        getString(R.string.cairo_activities4),
                        getString(R.string.cairo_activities5),
                        getString(R.string.cairo_activities6)
                    ),
                    listOf(
                        getString(R.string.cairo_places1),
                        getString(R.string.cairo_places2),
                        getString(R.string.cairo_places3),
                        getString(R.string.cairo_places4),
                        getString(R.string.cairo_places5),
                        getString(R.string.cairo_places6)
                    ),
                    listOf(
                        getString(R.string.cairo_typical1),
                        getString(R.string.cairo_typical2),
                        getString(R.string.cairo_typical3),
                        getString(R.string.cairo_typical4)
                    ),
                    getString(R.string.cairo_languages),
                    getString(R.string.cairo_latitude).toDouble(),
                    getString(R.string.cairo_longitude).toDouble()
                ),
                City(
                    getString(R.string.Sydney),
                    getString(R.string.sydney_photo),
                    getString(R.string.sydney_best),
                    getString(R.string.sydney_country),
                    getString(R.string.sydney_description),
                    listOf(
                        getString(R.string.sydney_activities1),
                        getString(R.string.sydney_activities2),
                        getString(R.string.sydney_activities3),
                        getString(R.string.sydney_activities4),
                        getString(R.string.sydney_activities5),
                        getString(R.string.sydney_activities6)
                    ),
                    listOf(
                        getString(R.string.sydney_places1),
                        getString(R.string.sydney_places2),
                        getString(R.string.sydney_places3),
                        getString(R.string.sydney_places4),
                        getString(R.string.sydney_places5),
                        getString(R.string.sydney_places6)
                    ),
                    listOf(
                        getString(R.string.sydney_typical1),
                        getString(R.string.sydney_typical2),
                        getString(R.string.sydney_typical3),
                        getString(R.string.sydney_typical4)
                    ),
                    getString(R.string.sydney_languages),
                    getString(R.string.sydney_latitude).toDouble(),
                    getString(R.string.sydney_longitude).toDouble()
                ),
                City(
                    getString(R.string.Paris),
                    getString(R.string.paris_photo),
                    getString(R.string.paris_best),
                    getString(R.string.paris_country),
                    getString(R.string.paris_description),
                    listOf(
                        getString(R.string.paris_activities1),
                        getString(R.string.paris_activities2),
                        getString(R.string.paris_activities3),
                        getString(R.string.paris_activities4),
                        getString(R.string.paris_activities5),
                        getString(R.string.paris_activities6)
                    ),
                    listOf(
                        getString(R.string.paris_places1),
                        getString(R.string.paris_places2),
                        getString(R.string.paris_places3),
                        getString(R.string.paris_places4),
                        getString(R.string.paris_places5),
                        getString(R.string.paris_places6)
                    ),
                    listOf(
                        getString(R.string.paris_typical1),
                        getString(R.string.paris_typical2),
                        getString(R.string.paris_typical3),
                        getString(R.string.paris_typical4)
                    ),
                    getString(R.string.paris_languages),
                    getString(R.string.paris_latitude).toDouble(),
                    getString(R.string.paris_longitude).toDouble()
                )









            )




            this.cities= cities
            return cities
        }

    fun pasarPaises(): List<Country> {
        val countries = listOf<Country>(
            Country(
                getString(R.string.Albania),
                getString(R.string.albania_photo),
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
            ),
            Country(
                getString(R.string.Spain),
                getString(R.string.spain_photo),
                getString(R.string.spain_description),
                listOf(
                    getString(R.string.spain_activities1),
                    getString(R.string.spain_activities2),
                    getString(R.string.spain_activities3),
                    getString(R.string.spain_activities4),
                    getString(R.string.spain_activities5),
                    getString(R.string.spain_activities6)
                ),
                listOf(
                    getString(R.string.spain_places1),
                    getString(R.string.spain_places2),
                    getString(R.string.spain_places3),
                    getString(R.string.spain_places4),
                    getString(R.string.spain_places5),
                    getString(R.string.spain_places6)
                ),
                listOf(
                    getString(R.string.spain_typical1),
                    getString(R.string.spain_typical2),
                    getString(R.string.spain_typical3),
                    getString(R.string.spain_typical4)
                ),
                getString(R.string.spain_languages)
            ),
            Country(
                getString(R.string.Japan),
                getString(R.string.japan_photo),
                getString(R.string.japan_description),
                listOf(
                    getString(R.string.japan_activities1),
                    getString(R.string.japan_activities2),
                    getString(R.string.japan_activities3),
                    getString(R.string.japan_activities4),
                    getString(R.string.japan_activities5),
                    getString(R.string.japan_activities6)
                ),
                listOf(
                    getString(R.string.japan_places1),
                    getString(R.string.japan_places2),
                    getString(R.string.japan_places3),
                    getString(R.string.japan_places4),
                    getString(R.string.japan_places5),
                    getString(R.string.japan_places6)
                ),
                listOf(
                    getString(R.string.japan_typical1),
                    getString(R.string.japan_typical2),
                    getString(R.string.japan_typical3),
                    getString(R.string.japan_typical4)
                ),
                getString(R.string.japan_languages)
            ),
            Country(
                getString(R.string.France),
                getString(R.string.france_photo),
                getString(R.string.france_description),
                listOf(
                    getString(R.string.france_activities1),
                    getString(R.string.france_activities2),
                    getString(R.string.france_activities3),
                    getString(R.string.france_activities4),
                    getString(R.string.france_activities5),
                    getString(R.string.france_activities6)
                ),
                listOf(
                    getString(R.string.france_places1),
                    getString(R.string.france_places2),
                    getString(R.string.france_places3),
                    getString(R.string.france_places4),
                    getString(R.string.france_places5),
                    getString(R.string.france_places6)
                ),
                listOf(
                    getString(R.string.france_typical1),
                    getString(R.string.france_typical2),
                    getString(R.string.france_typical3),
                    getString(R.string.france_typical4)
                ),
                getString(R.string.france_languages)
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
            ),
            Company(
                "American Airlines",
                "https://s202.q4cdn.com/986123435/files/doc_downloads/logos/american-airlines/aa_aa__hrz_rgb_grd_pos.png",
                "https://www.aa.com/homePage.do"
            ),
            Company(
                "Ryanair",
                "https://airportparking.ryanair.com/App_Themes/RyanairParking/img/Logo_footer.png",
                "https://www.ryanair.com/"
            ),
            Company(
                "Emirates",
                "https://1000logos.net/wp-content/uploads/2020/03/Emirates-Logo.png",
                "https://www.emirates.com/"
            ),
            Company(
                "Lufthansa",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Lufthansa_Logo_2018.svg/2560px-Lufthansa_Logo_2018.svg.png",
                "https://www.lufthansa.com/"
            ),
            Company(
                "Qatar Airways",
                "https://adventia.org/wp-content/uploads/2021/09/Logo-Qatar-Airways.png",
                "https://www.qatarairways.com/"
            ),
            Company(
                "Delta Air Lines",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Delta_logo.svg/2560px-Delta_logo.svg.png",
                "https://www.delta.com/"
            ),
            Company(
                "Air France",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Air_France_Logo.svg/2560px-Air_France_Logo.svg.png",
                "https://www.airfrance.com/"
            ),
            Company(
                "Turkish Airlines",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Turkish_Airlines_logo_2019_compact.svg/2560px-Turkish_Airlines_logo_2019_compact.svg.png",
                "https://www.turkishairlines.com/"
            ),
            Company(
                "Singapore Airlines",
                "https://images.vasystem.org/wX9RFMLrhgygI3lCEbc0QuWhtmLGo2NFpzoOljtfigU/rt:fill/g:sm/el:1/aHR0cHM6Ly9zdG9yYWdlLnN0YXJhbGxpYW5jZXZpcnR1YWwub3JnL2ltYWdlcy9zdGFyYWxsaWFuY2V2aXJ0dWFsLzdkL2RlLzdkZGU4MjFmYWEwODg4Y2NhZGY4NDVjMTQyYjlmNjc2ZTkxMjY2YzM",
                "https://www.singaporeair.com/"
            )



        )
        this.planeCompanies = planeCompanies
        return planeCompanies

    }

    fun pasarTrainCompanies(): List<Company>{

        val trainCompanies = listOf(
            Company(
                "Renfe",
                "https://seeklogo.com/images/R/Renfe-logo-5CB197E185-seeklogo.com.png",
                "https://www.renfe.com/es/es",
            ),
            Company(
                "Deutsche Bahn",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/DB-Konzern_Logo.svg/2560px-DB-Konzern_Logo.svg.png",
                "https://www.bahn.com/en/view/index.shtml",
            ),
            Company(
                "Amtrak",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Amtrak_logo_2.svg/1200px-Amtrak_logo_2.svg.png",
                "https://www.amtrak.com/",
            ),
            Company(
                "Eurostar",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Eurostar_logo_%282023%29.svg/2560px-Eurostar_logo_%282023%29.svg.png",
                "https://www.eurostar.com/",
            ),
            Company(
                "Trenitalia",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Trenitalia_logo.svg/2560px-Trenitalia_logo.svg.png",
                "https://www.trenitalia.com/",
            ),
            Company(
                "SNCF",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Logo_SNCF_2011.svg/1280px-Logo_SNCF_2011.svg.png",
                "https://www.sncf.com/",
            ),
            Company(
                "OBB",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Logo_ÖBB.svg/600px-Logo_ÖBB.svg.png",
                "https://www.oebb.at/en/",
            ),
            Company(
                "SBB",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/SBB_CFF_FFS_logo.svg/2560px-SBB_CFF_FFS_logo.svg.png",
                "https://www.sbb.ch/en",
            ),
            Company(
                "NS Dutch Railways",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Nederlandse_Spoorwegen_logo.svg/1200px-Nederlandse_Spoorwegen_logo.svg.png",
                "https://www.ns.nl/en",
            )
        )

        this.trainCompanies = trainCompanies
        return trainCompanies

    }

    fun pasarBusCompanies(): List<Company>{

        val busCompanies = listOf(
            Company(
                "Monbus",
                "https://appmonbus.kramagot.com/img/logo/monbus.png",
                "https://www.monbus.es/es"
            ),
            Company(
                "Greyhound",
                "https://assets-global.website-files.com/5a6a36cb0a6e6500019fcb5e/5b39e8ce5b093e1ccbedc822_GreyhoundLogo.png",
                "https://www.greyhound.com/",
            ),
            Company(
                "Megabus",
                "https://uk.megabus.com/siteassets/public/uk_-sid-megabus-intercity-logo---rgb.jpg",
                "https://us.megabus.com/",
            ),
            Company(
                "FlixBus",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flixbus_201x_logo.svg/1280px-Flixbus_201x_logo.svg.png",
                "https://www.flixbus.com/",
            ),
            Company(
                "National Express",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/National_Express_Group_Logo.svg/2560px-National_Express_Group_Logo.svg.png",
                "https://www.nationalexpress.com/",
            ),

            Company(
                "Bus Éireann",
                "https://pbs.twimg.com/media/F_pVerGWsAAVW5d.png",
                "https://www.buseireann.ie/",
            ),
            Company(
                "Eurolines",
                "https://upload.wikimedia.org/wikipedia/en/thumb/7/7b/Eurolines_logo.svg/2560px-Eurolines_logo.svg.png",
                "https://www.eurolines.com/",
            ),
            Company(
                "TransLink",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/TransLink_%28Vancouver%29_Logo.svg/1280px-TransLink_%28Vancouver%29_Logo.svg.png",
                "https://www.translink.ca/"
            )

        )

        this.busCompanies=busCompanies
        return busCompanies
    }

    fun pasarBoatCompanies(): List<Company>{

        val boatCompanies = listOf(
            Company(
                "Direct Ferries",
                "https://theme.zdassets.com/theme_assets/10427784/920a70a52bf6b26aa43a060a276e3da7f4622c72.png",
                "https://www.directferries.es"
            ),
            Company(
                "Blue Star Ferries",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/Blue_star_ferries_logo.svg/1280px-Blue_star_ferries_logo.svg.png",
                "https://www.bluestarferries.com/",
            ),
            Company(
                "Stena Line",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Stena_line_logo.svg/1200px-Stena_line_logo.svg.png",
                "https://www.stenaline.com/",
            ),
            Company(
                "P&O Ferries",
                "https://s3-eu-west-1.amazonaws.com/tpd/logos/4aa6d5d8000064000504b8b2/0x0.png",
                "https://www.poferries.com/",
            ),
            Company(
                "Irish Ferries",
                "https://www.freightlink.co.uk/sites/default/files/field/image/irish-ferries-logo-header_0.png",
                "https://www.irishferries.com/",
            ),
            Company(
                "Minoan Lines",
                "https://assets.ferryscanner.com/media/2022/02/minoan-line-1.png",
                "https://www.minoan.gr/en/",
            ),
            Company(
                "Color Line",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Color_Line_logo.svg/1280px-Color_Line_logo.svg.png",
                "https://www.colorline.com/",
            ),
            Company(
                "Grimaldi Lines",
                "https://upload.wikimedia.org/wikipedia/commons/4/4f/Logogl.png",
                "https://www.grimaldi-lines.com/",
            ),
            Company(
                "Corsica Ferries",
                "https://faehren.net/wp-content/uploads/corsica-ferries-logo.png",
                "https://www.corsica-ferries.fr/en/",
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
            ),
            Company(
                "Expedia",
                "https://upload.wikimedia.org/wikipedia/commons/d/d3/2023-Logo-Expedia.png",
                "https://www.expedia.com/",
            ),
            Company(
                "Airbnb",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Airbnb_Logo_Bélo.svg/2560px-Airbnb_Logo_Bélo.svg.png",
                "https://www.airbnb.com/",
            ),
            Company(
                "Hotels.com",
                "https://upload.wikimedia.org/wikipedia/commons/3/3e/Hotels.com_Logo_2023.png",
                "https://www.hotels.com/",
            ),
            Company(
                "TripAdvisor",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/TripAdvisor_Logo.svg/1024px-TripAdvisor_Logo.svg.png",
                "https://www.tripadvisor.com/",
            ),
            Company(
                "Trivago",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Trivago.svg/1024px-Trivago.svg.png",
                "https://www.trivago.com/",
            ),
            Company(
                "Hilton",
                "https://vacations.united.com/contentassets/96ec812318ea49c3abbf72f5979814a7/hilton-for-the-stay-logo-black-transparent-2023-600x293.png",
                "https://www.hilton.com/",
            ),
            Company(
                "Marriott",
                "https://asset.brandfetch.io/id0DQ-cAhI/idMjSj_tsX.png",
                "https://www.marriott.com/",
            ),
            Company(
                "Agoda",
                "https://upload.wikimedia.org/wikipedia/commons/c/ce/Agoda_transparent_logo.png",
                "https://www.agoda.com/",
            ),
            Company(
                "Hostelworld",
                "https://www.oneplanetnetwork.org/sites/default/files/2021-12/org_473d096b-ab1b-ec11-b6e6-6045bd892a18.PNG",
                "https://www.hostelworld.com/",
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









}