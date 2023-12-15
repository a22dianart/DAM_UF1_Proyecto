
package com.example.uf1_proyecto
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uf1_proyecto.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

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
        val ubicacion = LatLng(37.7749, -122.4194) // Latitud y longitud de San Francisco, CA
        val ubicacionSantiago = LatLng(42.8805200,-8.5456900, ) //Ubicacion para santiago de compostela
//        val ubicacionActual = LatLng()
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionSantiago, 12f)) // Zoom de 12

        // Agregar un marcador en la ubicación
        googleMap.addMarker(MarkerOptions().position(ubicacionSantiago).title("Santiago"))
    }


}