package com.shoe.xtatic


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.logIn)
        val signIn =findViewById<Button>(R.id.signIn)

        val transaction = supportFragmentManager.beginTransaction()

        login.setOnClickListener{
            val loginForm = Login()
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            transaction.replace(R.id.container,loginForm)
            transaction.commit()
        }
        signIn.setOnClickListener {
            val signInForm = SignIn()
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.replace(R.id.container,signInForm)
        }
    }
}