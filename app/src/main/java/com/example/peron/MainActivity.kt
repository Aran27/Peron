package com.example.peron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    private lateinit var signUp: MaterialTextView
    private lateinit var login: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUp = findViewById(R.id.textView4)

        signUp.setOnClickListener {
            val intent = Intent(this@MainActivity, SignupActivity::class.java)
            startActivity(intent)
        }

        login = findViewById(R.id.login)
        login.setOnClickListener {
            val intent2 = Intent(this@MainActivity, Homepage::class.java)
            startActivity(intent2)
        }
    }

}
