package com.example.stocktakingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

//Klasa aktywności uruchamiająca aparat i skanująca kod z wykorzystaniem biblioteki ZBar
class BarcodeScanningActivity : AppCompatActivity(), ZBarScannerView.ResultHandler {

    private lateinit var mScannerView: ZBarScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mScannerView = ZBarScannerView(this)
        setContentView(mScannerView)
    }

    override fun onResume() {
        super.onResume()
        mScannerView.setResultHandler(this)
        mScannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mScannerView.stopCamera()
    }

    //przekazanie zeskanowanego kodu kreskowego do następnej aktywności i uruchomienie jej
    override fun handleResult(result: Result?) {
        Toast.makeText(this, result?.contents, Toast.LENGTH_SHORT).show()

        val intent = Intent(this@BarcodeScanningActivity, HandleBarcodeActivity::class.java).apply {
            putExtra("barcode", result?.contents)
        }
        startActivity(intent)
    }
}
