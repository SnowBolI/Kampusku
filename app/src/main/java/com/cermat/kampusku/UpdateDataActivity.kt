package com.cermat.kampusku

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class UpdateDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)

        val numberEditText = findViewById<TextInputEditText>(R.id.numberEditText)
        val nameEditText = findViewById<TextInputEditText>(R.id.nameEditText)
        val birthDateEditText = findViewById<TextInputEditText>(R.id.birthDateEditText)
        val addressEditText = findViewById<TextInputEditText>(R.id.addressEditText)
        val genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)

        birthDateEditText.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/${month + 1}/$year"
                    birthDateEditText.setText(selectedDate)
                },
                2000, 0, 1
            )
            datePicker.show()
        }

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val number = numberEditText.text.toString()
            val name = nameEditText.text.toString()
            val address = addressEditText.text.toString()
            val selectedGender = when (genderRadioGroup.checkedRadioButtonId) {
                R.id.maleRadioButton -> "Laki-laki"
                R.id.femaleRadioButton -> "Perempuan"
                else -> ""
            }
            val birthDate = birthDateEditText.text.toString()

            val intent = Intent(this, ListDataActivity::class.java)
            intent.putExtra("number", number)
            intent.putExtra("name", name)
            intent.putExtra("address", address)
            intent.putExtra("gender", selectedGender)
            intent.putExtra("birthDate", birthDate)
            startActivity(intent)
        }
    }
}
