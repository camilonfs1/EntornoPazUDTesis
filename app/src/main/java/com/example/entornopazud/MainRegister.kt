package com.example.entornopazud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main_register.*
import kotlinx.android.synthetic.main.activity_main_register.txtEmail
import kotlinx.android.synthetic.main.activity_main_register.txtPass

class MainRegister : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    private lateinit var database: DatabaseReference
    private var RadioStud: RadioButton?=null
    private var RadioTech: RadioButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)
        database = FirebaseDatabase.getInstance().reference
        RadioStud = RBtnStudReg
        RadioTech = RbtnTechReg
    }

    private fun registerUser() {
        var TextEmail = txtEmail.text.toString().trim()
        var TextPass = txtPass.text.toString().trim()
        var TextName = txtName.text.toString().trim()
        var TextId = txtId.text.toString().trim()
        var TextPassCon = txtPassConfirm.text.toString().trim()
        var Roll = Radios()

        if (!TextEmail.isEmpty() && !TextPass.isEmpty() && !TextPass.isEmpty() && !TextId.isEmpty() && !Roll.isEmpty() && !TextPassCon.isEmpty()) {//decide if boxes is or isn't empty
            if (TextPass.length >= 6 && TextPassCon.length >= 6) {//decide if password & password confirm it has more than 6 digits
                if (TextPass == TextPassCon) {//decide if password & password confirm is equals
                    FirebaseCharge(TextId, TextName, Roll, TextEmail, TextPass)
                } else {
                    Toast.makeText(
                        this,
                        "Error en la confirmacion de contraseña",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                txtPass.setHint("6 DIGITOS")
                txtPassConfirm.setHint(" 6 DIGITOS")
            }
        } else {
            Toast.makeText(this, "Llene las casillas", Toast.LENGTH_LONG).show()
        }
    }

    private fun Radios(): String {//Determined which radioButton isSelected
        var Roll = ""
        if (RadioStud!!.isChecked()) {//Which radioButton is selected by user
            Roll =  "Aprendiente"//Student radioButton is selected
        } else if(RadioTech!!.isChecked()){
            Roll = "Docente"//Teacher radioButton is selected
        }
        return Roll
    }
    fun FirebaseCharge(id: String, name: String, roll: String, email: String, pass: String) {
        mAuth.createUserWithEmailAndPassword(email, pass)//Add to user and email autentication
            .addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful) {
                    writeNewUser(id, name, roll, email)
                    //Toast.makeText(this, "Agregado a BD :)", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(
                        this,
                        "Error haciendo el registro, intenta nuevamente :(",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
    data class User(
        var id: String? = "",
        var name: String? = "",
        var roll: String? = "",
        var email: String? = ""
    )
    private fun writeNewUser(Id: String, name: String, roll: String, email: String) {
        val user = User(Id, name, roll, email)
        Toast.makeText(
            this,
            roll,
            Toast.LENGTH_LONG
        ).show()
        if(roll.equals("Docente")){

            database.child("Teachers").child(Id).setValue(user)//Add child to DB
        }else if(roll.equals("Aprendiente")){
            database.child("Students").child(Id).setValue(user)//Add child to DB
        }
    }
    fun onClick(view: View) {
        registerUser()
    }
    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}




