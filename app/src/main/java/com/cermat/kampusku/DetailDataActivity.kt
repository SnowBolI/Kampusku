package com.cermat.kampusku

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_data)

        val number = intent.getStringExtra("number") ?: ""
        val name = intent.getStringExtra("name") ?: ""
        val address = intent.getStringExtra("address") ?: ""
        val gender = intent.getStringExtra("gender") ?: ""
        val birthDate = intent.getStringExtra("birthDate") ?: ""

        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val addressTextView = findViewById<TextView>(R.id.addressTextView)
        val genderTextView = findViewById<TextView>(R.id.genderTextView)
        val birthDateTextView = findViewById<TextView>(R.id.birthDateTextView)

        numberTextView.text = "Nomor: $number"
        nameTextView.text = "Nama: $name"
        addressTextView.text = "Alamat: $address"
        genderTextView.text = "Jenis Kelamin: $gender"
        birthDateTextView.text = "Tanggal Lahir: $birthDate"
    }
}
