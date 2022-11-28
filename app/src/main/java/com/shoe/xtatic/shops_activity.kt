package com.shoe.xtatic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView

class ShopsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)

        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_nav)


        bottomNav.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.market -> {
                    startActivity(Intent(this, MarketActivity::class.java))
                    true
                }
                R.id.social -> {
                    startActivity(Intent(this, SocialActivity::class.java))
                    true
                }
                R.id.trends -> {
                    startActivity(Intent(this, TrendsActivity::class.java))
                    true
                }
                R.id.shops-> {
                    startActivity(Intent(this, ShopsActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}