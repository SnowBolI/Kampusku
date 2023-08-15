package com.cermat.kampusku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.cermat.kampusku.InformasiActivity
import com.cermat.kampusku.InputDataActivity
import com.cermat.kampusku.ListDataActivity
import com.cermat.kampusku.R

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val lihatDataButton = findViewById<Button>(R.id.lihatDataButton)
        val inputDataButton = findViewById<Button>(R.id.inputDataButton)
        val informasiButton = findViewById<Button>(R.id.informasiButton)

        lihatDataButton.setOnClickListener(this)
        inputDataButton.setOnClickListener(this)
        informasiButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.lihatDataButton -> {
                val intent = Intent(this, ListDataActivity::class.java)
                startActivity(intent)
            }
            R.id.inputDataButton -> {
                val intent = Intent(this, InputDataActivity::class.java)
                startActivity(intent)
            }
            R.id.informasiButton -> {
                val intent = Intent(this, InformasiActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
