package com.cermat.kampusku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.cermat.kampusku.R

class WelcomeLogin : AppCompatActivity() {

    private val delayMillis: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val handler = Handler()
        handler.postDelayed({
            // Navigate to DashboardActivity or the desired next activity
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        },5000 )
    }
}
