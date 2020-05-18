package com.example.stocktakingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import java.util.Calendar.*

//klasa aktywności pozwalająca na akcje na zeskanowanym kodzie
class HandleBarcodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_barcode)

        //pobranie kodu przekazanego z poprzedniej aktyności
        val barcode = intent.getStringExtra("barcode")

        val barcodeTextView = findViewById<TextView>(R.id.barcodeTextView)
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val ownerTextView = findViewById<TextView>(R.id.ownerTextView)

        val editNameButton = findViewById<Button>(R.id.editNameButton)
        val editOwnerButton = findViewById<Button>(R.id.editOwnerButton)
        val saveRecordButton = findViewById<Button>(R.id.saveRecordButton)
        val scanAgainButton = findViewById<Button>(R.id.scanAgainButton)
        val returnButton = findViewById<Button>(R.id.returnButton)

        //wyświetlenie zeskanowanego kodu
        barcodeTextView.text = barcode

        //pobranie aktualnej daty
        val date = Calendar.getInstance()
        dateTextView.text = """${date.get(DAY_OF_MONTH)}-${date.get(MONTH)}-""" + date.get(YEAR)

        editNameButton.setOnClickListener{
        }

        editOwnerButton.setOnClickListener{
        }

        saveRecordButton.setOnClickListener{
        }

        scanAgainButton.setOnClickListener{
            finish() //powrót do skanowania kodów
        }

        returnButton.setOnClickListener{
            val intent = Intent(this@HandleBarcodeActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP //usunięcie poprzednich aktywności ze stosu
            startActivity(intent) //powrót do menu
        }
    }
}
