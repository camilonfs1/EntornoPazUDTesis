package com.example.entornopazud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun login(){
        var TextEmail = txtEmail.text.toString()
        var TextPass = txtPass.text.toString()

        if(!TextEmail.isEmpty() && !TextPass.isEmpty()){
            this.mAuth.signInWithEmailAndPassword(TextEmail,TextPass).addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                }

            })
        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClick(view: View) {
        login()

    }

    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainRegister::class.java))
    }
}
