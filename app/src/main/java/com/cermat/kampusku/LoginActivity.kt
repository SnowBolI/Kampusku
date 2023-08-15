package com.cermat.kampusku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Mock authentication (Replace this with your actual authentication logic)
            if (isValidCredentials(username, password)) {
                // Login successful, navigate to welcome page
                val intent = Intent(this, WelcomeLogin::class.java)
                startActivity(intent)
                finish()
            } else {
                // Login failed, show error message
                Toast.makeText(this, "Login gagal. Mohon Cek Kembali.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Implement your authentication logic here
        // Return true if authentication is successful, otherwise false
        // Example: return username == "admin" && password == "password"
        return username == "admin" && password == "123"
    }
}
