package com.example.peron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity(R.layout.activity_main) {
//    private lateinit var signUp: MaterialTextView
//    private lateinit var login: AppCompatImageView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        signUp = findViewById(R.id.textView4)
//
//        signUp.setOnClickListener {
//            val intent = Intent(this@MainActivity, SignupFragment::class.java)
//            startActivity(intent)
//        }
//
//        login = findViewById(R.id.login)
//        login.setOnClickListener {
//            val intent2 = Intent(this@MainActivity, HomepageFragment::class.java)
//            startActivity(intent2)
//        }
//    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve NavController from the NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        // Set up the action bar for use with the NavController
        //NavigationUI.setupActionBarWithNavController(this, navController)
    }

    /**
     * Handle navigation when the user chooses Up from the action bar.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
