package com.example.peron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.peron.viewmodels.UserViewModel
import com.example.peron.viewmodels.UserViewModelFactory
import com.google.android.material.textview.MaterialTextView

class SignupActivity : AppCompatActivity() {
    private lateinit var login: MaterialTextView
    private lateinit var homepage: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        login = findViewById(R.id.textView6)

        login.setOnClickListener {
            val intent = Intent(this@SignupActivity, MainActivity::class.java)
            startActivity(intent)
        }

        homepage = findViewById(R.id.sign_up_button)

        homepage.setOnClickListener {
            val intent2 = Intent(this@SignupActivity, MainActivity::class.java)
            startActivity(intent2)
        }
    }


}
