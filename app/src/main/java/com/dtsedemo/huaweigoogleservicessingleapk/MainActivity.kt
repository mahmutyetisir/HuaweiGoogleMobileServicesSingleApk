package com.dtsedemo.huaweigoogleservicessingleapk

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.dtsedemo.huaweigoogleservicessingleapk.util.Permissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_open_activity_mapview.setOnClickListener {
            if (Permissions.getLocationPermission(this)) startMapViewActivity()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (Permissions.LOCATION_PERMISSION_KEY == requestCode) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                startMapViewActivity()
            } else {
                AlertDialog.Builder(this).setTitle("İzinler").setMessage("Konum izni vermeden map sayfasını açamazsınız. Lütfen uygulamaya konum izni veriniz.").setPositiveButton("Tamam"){ dialog: DialogInterface?, which: Int -> }.show()
            }
        }
    }

    private fun startMapViewActivity():Unit = startActivity(Intent(this, MapViewActivity::class.java))
}
