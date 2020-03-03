package com.dtsedemo.huaweigoogleservicessingleapk

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.dtsedemo.huaweigoogleservicessingleapk.manager.location.HuaweiGoogleLocationManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_map_view.*
import kotlinx.android.synthetic.main.content_map_view.*


class MapViewActivity : AppCompatActivity() {
    lateinit var locationService: HuaweiGoogleLocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_view)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        locationService = HuaweiGoogleLocationManager(this)

        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle("MapViewBundleKey")
        }
        huaweigoogle_map_view.onCreate(mapViewBundle)

        huaweigoogle_map_view.getMapAsync {
            it.setMyLocationEnabled(true)

            locationService.getLastKnownLocation { location ->
                if (location == null) {
                    locationService.subscribewLocationUpdates { locationUpdate ->
                        it.moveCamera(locationUpdate.latitude.toFloat(), locationUpdate.longitude.toFloat(), 20f)
                        it.addMarker(
                            "Your Location",
                            "${locationUpdate.latitude} - ${locationUpdate.longitude}",
                            locationUpdate.latitude.toFloat(),
                            locationUpdate.longitude.toFloat()
                        )
                    }
                } else {
                    it.moveCamera(location.latitude.toFloat(), location.longitude.toFloat(), 20f)
                    it.addMarker(
                        "Your Location",
                        "${location.latitude} - ${location.longitude}",
                        location.latitude.toFloat(),
                        location.longitude.toFloat()
                    )
                }
            }
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Hellooooooo", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        return when (id) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        locationService.unsubscribeLocationUpdates()
        super.onDestroy()
    }

}
