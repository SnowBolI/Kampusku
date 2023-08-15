package com.cermat.kampusku
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.cermat.kampusku.R

class DialogOptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        val optionView = findViewById<TextView>(R.id.optionView)
        val lihatButton = findViewById<Button>(R.id.lihatButton)
        val updateButton = findViewById<Button>(R.id.updateButton)
        val hapusButton = findViewById<Button>(R.id.hapusButton)

        lihatButton.setOnClickListener {
        }

        updateButton.setOnClickListener {
        }

        hapusButton.setOnClickListener {
            showDeleteConfirmationDialog()
        }
    }

    private fun showDeleteConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi")
            .setMessage("Apakah Anda yakin ingin menghapus data ini?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
            })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialog, which ->
            })
            .show()
    }
}
