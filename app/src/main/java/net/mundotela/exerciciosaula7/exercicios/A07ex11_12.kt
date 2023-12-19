package net.mundotela.exerciciosaula7.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import net.mundotela.exerciciosaula7.R

class A07ex11_12 : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var map: MapView

    val casa = LatLng(-20.5556704559015, -48.55806629051066)
    val texugoimports = LatLng(-20.55837090583091, -48.56507767699024)
    val ifsp = LatLng(-20.535253120344297, -48.53332292504352)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex11)

        map = findViewById(R.id.mapView)
        map.onCreate(savedInstanceState)
        map.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //Add a marker in Sydney and move the camera

        mMap.addMarker(MarkerOptions().position(casa).title("Casa do Henrique"))
        mMap.addMarker(MarkerOptions().position(ifsp).title("IFSP Barretos"))
        mMap.addMarker(MarkerOptions().position(texugoimports).title("Loja de Importados Texugo"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(casa))
        mMap.setMinZoomPreference(15f)
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    fun mudaMapa(view: View) {

        when(view.id){

            R.id.btnMaps1 -> mMap.moveCamera(CameraUpdateFactory.newLatLng(texugoimports))

            R.id.btnMaps2 -> mMap.moveCamera(CameraUpdateFactory.newLatLng(casa))

            R.id.btnMap3 -> mMap.moveCamera(CameraUpdateFactory.newLatLng(ifsp))
        }


    }
}