package com.shoe.xtatic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

class SignIn : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signin, container, false)

        val dataBase = DataManager(requireActivity())
        val firstname = view.findViewById<EditText>(R.id.firstName)
        val secondName = view.findViewById<EditText>(R.id.secondName)
        val email = view.findViewById<EditText>(R.id.EmailAddress)
        val zip = view.findViewById<EditText>(R.id.Zip)
        val phone= view.findViewById<EditText>(R.id.phone)
        val password = view.findViewById<EditText>(R.id.password)
        val signIn = view.findViewById<EditText>(R.id.signIn2)

        signIn.setOnClickListener{
            dataBase.insert(firstname.text.toString(),secondName.text.toString(),email.text.toString()
            ,zip.text.toString(),phone.text.toString(),password.text.toString())
        }


        return view
    }

}