
package com.example.uf1_proyecto
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.where.cities.CityAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.CameraPosition

class MapsFragment : Fragment() {

    private lateinit var googleMap: GoogleMap


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // inicializar el fragmento del mapa
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            // Configure the GoogleMap
            googleMap = map
            configurarMapa()

        }
    }

    private fun configurarMapa() {
        // Configuración adicional del mapa
        // Ejemplo: Mover la cámara a una ubicación específica y agregar un marcador

        // Mover la cámara a una ubicación específica (por ejemplo, latitud y longitud de un lugar)
        val ubicacion= LatLng(30.3995242, 10.3995242) //ubicacion inicials

        // Configurar la cámara con una rotación de 0 grados
        val cameraPosition = CameraPosition.Builder()
            .target(ubicacion)
            .zoom(1f)
            .bearing(0f) // Rotación de la cámara en grados (0 significa sin rotación)
            .tilt(0f) // Inclinación de la cámara en grados (0 significa sin inclinación)
            .build()

        // Mover la cámara a la posición configurada
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        // Agregar un marcador en la ubicación
        val mainactivity = requireActivity() as MainActivity
        val cities =mainactivity.pasarCidades()
        var ubicationCity= LatLng(0.0, 0.0)
        for(city in cities){
            ubicationCity=LatLng(city.latitude, city.longitude)
            googleMap.addMarker(MarkerOptions().position(ubicationCity).title(city.name))
        }
    }



}