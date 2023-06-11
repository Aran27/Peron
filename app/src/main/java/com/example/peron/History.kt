package com.example.peron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView

class History : AppCompatActivity() {
    private lateinit var back_arrow: AppCompatImageView
    private lateinit var account: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)


        back_arrow = findViewById(R.id.arrow_back_history)

        back_arrow.setOnClickListener {
            val intent = Intent(this@History, Homepage::class.java)
            startActivity(intent)
        }

        account = findViewById(R.id.account_history)

        account.setOnClickListener {
            val intent2 = Intent(this@History, Profile::class.java)
            startActivity(intent2)
        }
    }
}