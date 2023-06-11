package com.example.peron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView

class Homepage : AppCompatActivity() {
    private lateinit var account: AppCompatImageView
    private lateinit var menu: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        account = findViewById(R.id.account_home)

        account.setOnClickListener {
            val intent = Intent(this@Homepage, Profile::class.java)
            startActivity(intent)
        }

        menu = findViewById(R.id.menu_list)
        menu.setOnClickListener{
            val intent3 = Intent(this@Homepage,History::class.java )
            startActivity(intent3)
        }
    }
}