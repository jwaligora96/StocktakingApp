package com.example.stocktakingapp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat

//klasa głównej aktywności
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sprawdzenie uprawnień
        //jeśli aplikacja ich nie posiada, wyświetla nadanie zgody o ich nadanie
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 12)
        }

        val scanBarcodeButton = findViewById<Button>(R.id.scanBarcodeButton)
        val browseRecordButton = findViewById<Button>(R.id.browseRecordButton)

        scanBarcodeButton.setOnClickListener {
            //otwarcie nowej aktywności po naciśnięciu przycisku
            val intent = Intent(this@MainActivity, BarcodeScanningActivity::class.java)
            startActivity(intent)
        }
        browseRecordButton.setOnClickListener {
        }
    }

    //metoda uruchamiana po pobraniu odpowiedzi z wyświetlonego okna o nadanie uprawnień
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            12 -> if (grantResults.isEmpty() || grantResults[0] !=
                PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(
                    this, getString(R.string.missing_permissions),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
