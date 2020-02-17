package com.example.entornopazud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main_register.*

class MainRegister : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)
    }
    private fun registerUser(){
        var TextEmail = txtEmail.text.toString().trim()
        var TextPass = txtPass.text.toString().trim()
        if (!TextEmail.isEmpty() && !TextPass.isEmpty() ){
            mAuth.createUserWithEmailAndPassword(TextEmail,TextPass).addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful) {
                    txtEmail.setText("")
                    txtPass.setText("")
                    Toast.makeText(this, "Successfully registered :)", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
                }
            })
        }else{
            Toast.makeText(this, "Llene las casillas", Toast.LENGTH_LONG).show()
        }
    }

    fun onClick(view: View) {
        registerUser()
    }
}
