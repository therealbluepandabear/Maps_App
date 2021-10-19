package com.realtomjoney.mapsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.realtomjoney.mapsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding

    lateinit var myMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.button.setOnClickListener {
            val coordinates = LatLng(49.284670, -123.121539)

            val markerOptions: MarkerOptions =
                MarkerOptions().position(coordinates).title("Downtown Vancouver")

            myMap.addMarker(markerOptions)
            myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 12.0f))
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        myMap = p0
        myMap.setOnMarkerClickListener { marker ->
            marker.showInfoWindow()
            true
        }
    }

}