package com.shoe.xtatic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment



class Login :  Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_form,container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = view.findViewById<EditText>(R.id.email)
        val login2 = view.findViewById<Button>(R.id.login2)
        val password2 = view.findViewById<EditText>(R.id.password1)


        val dataBase = DataManager(requireActivity())

        login2.setOnClickListener{
            val search = dataBase.search(email.text.toString(),password2.text.toString())

            if (search.count > 0){
                val duration :Int = Toast.LENGTH_LONG
                val toast : Toast = Toast.makeText(context,"successfully logged in",duration)
                toast.show()
            }
        }


    }





}