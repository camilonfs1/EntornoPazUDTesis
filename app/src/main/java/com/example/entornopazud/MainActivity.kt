package com.example.entornopazud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    public var RadioTech: RadioButton? = null
    public var RadioStud: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun login(userRoll: Int) {
        var TextEmail = txtEmail.text.toString()
        var TextPass = txtPass.text.toString()

        if (!TextEmail.isEmpty() && !TextPass.isEmpty()) {//Only if full boxes is ok
            this.mAuth.signInWithEmailAndPassword(TextEmail, TextPass)
                .addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        txtEmail.setText("")
                        txtPass.setText("")
                        if (userRoll == 1) {//Which Student radioButton is selected
                            startActivity(Intent(this, MainEstudent::class.java))
                        } else if (userRoll == 0) {//Which Teacher radioButton is selected
                            startActivity(Intent(this, MainTeacher::class.java))
                        }
                        Toast.makeText(this, "Datos correctos :)", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Tenemos un error :(", Toast.LENGTH_SHORT).show()
                    }
                })
        } else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClick(view: View) {
        RadioStud = RBtnStud as RadioButton
        RadioTech = RbtnTech as RadioButton
        if (!RadioStud!!.isSelected()) {//Which radioButton is selected by user
            login(1)//Student radioButton is selected
        } else {
            login(0)//Teacher radioButton is selected
        }

    }

    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainRegister::class.java))
    }
}
