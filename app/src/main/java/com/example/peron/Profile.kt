package com.example.peron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView

class Profile : AppCompatActivity() {
    private lateinit var back_arrow: AppCompatImageView
    private lateinit var logout: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)


        logout = findViewById(R.id.logout)

        logout.setOnClickListener {
            val intent = Intent(this@Profile, MainActivity::class.java)
            startActivity(intent)
        }

        back_arrow = findViewById(R.id.arrow_back)

        back_arrow.setOnClickListener {
            val intent2 = Intent(this@Profile, Homepage::class.java)
            startActivity(intent2)
        }
    }
}