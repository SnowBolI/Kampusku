package com.cermat.kampusku

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class ListDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)

        val nameTextView = findViewById<TextView>(R.id.nameTextView)

        // Menerima data dari InputDataActivity (jika diperlukan)
        val number = intent.getStringExtra("number") ?: ""
        val name = intent.getStringExtra("name") ?: ""
        val address = intent.getStringExtra("address") ?: ""
        val gender = intent.getStringExtra("gender") ?: ""
        val birthDate = intent.getStringExtra("birthDate") ?: ""

        nameTextView.text = name

        nameTextView.setOnClickListener {
            val options = arrayOf("Lihat Data", "Update Data", "Hapus Data")
            val builder = AlertDialog.Builder(this)
            builder.setTitle(name)
                .setItems(options) { _, which ->
                    when (which) {
                        0 -> {
                            val intent = Intent(this, DetailDataActivity::class.java)
                            intent.putExtra("number", number)
                            intent.putExtra("name", name)
                            intent.putExtra("address", address)
                            intent.putExtra("gender", gender)
                            intent.putExtra("birthDate", birthDate)
                            startActivity(intent)
                        }
                        1 -> {
                            val updateIntent = Intent(this, UpdateDataActivity::class.java)
                            updateIntent.putExtra("number", number)
                            updateIntent.putExtra("name", name)
                            updateIntent.putExtra("address", address)
                            updateIntent.putExtra("gender", gender)
                            updateIntent.putExtra("birthDate", birthDate)
                            startActivity(updateIntent)
                        }
                        2 -> {
                            val deleteConfirmationBuilder = AlertDialog.Builder(this)
                            deleteConfirmationBuilder.setTitle("Konfirmasi Hapus")
                                .setMessage("Apakah Anda yakin ingin menghapus data ini?")
                                .setPositiveButton("Iya") { _, _ ->
                                    // Handle penghapusan data dari ListDataActivity
                                    intent.removeExtra("number")
                                    intent.removeExtra("name")
                                    intent.removeExtra("address")
                                    intent.removeExtra("gender")
                                    intent.removeExtra("birthDate")

                                    // Setelah penghapusan selesai, Anda dapat kembali ke ListDataActivity
                                    val intent = Intent(this, ListDataActivity::class.java)
                                    startActivity(intent)
                                }
                                .setNegativeButton("Tidak", null)
                            deleteConfirmationBuilder.show()

                        }
                    }
                }
            builder.show()
        }
        val inputDataButton = findViewById<ImageView>(R.id.inputDataButton)
        inputDataButton.setOnClickListener {
            val intent = Intent(this, InputDataActivity::class.java)
            startActivity(intent)
        }
    }
}
