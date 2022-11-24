package com.shoe.xtatic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shoe.xtatic.fragments.*

class Navigationactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val homefrag = homefragment()
        val marketfrag = marketfragment()
        val socialfrag = socialfagment()
        val tredsrag = trendsfragment()
        val shopsfrag = shopsfragment()
        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)




    }
}