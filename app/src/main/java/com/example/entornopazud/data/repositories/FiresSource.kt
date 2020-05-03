package com.example.entornopazud.data.repositories

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.entornopazud.data.model.Login
import com.example.entornopazud.data.model.User
import com.example.entornopazud.view.activity.MainRegister
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class FiresSource() {
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    // Function for authentication or user login
    fun login(context: Context,Email :String, Pass: String) {
        mAuth?.signInWithEmailAndPassword(Email,Pass)!!
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    updateUI(context)
                } else {
                    Toast.makeText(
                        context,
                        "Tenemos un error, comprueba tus datos y conexion :(",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun updateUI(context: Context) {
        val mUser = mAuth!!.currentUser
        var intent = Intent(context, Login::class.java)
        intent.putExtra("mUser", mUser)
        context.startActivity(intent)
    }

//---------------------------------------------------registerUser----------------------------------------------------------------------------------

    fun RegisterUser(context: Context,Email :String, Pass: String, user: User){
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Courses").child(user.course).child("Students")//Create child Users in firebase database
        mAuth!!.createUserWithEmailAndPassword(Email!!, Pass!!)//Create login with
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) { // Sign in success, update UI with the signed-in user's information
                    val userId = mAuth!!.currentUser!!.uid
                    //update user profile information
                    val currentUserDb = mDatabaseReference!!.child(userId)
                    currentUserDb.child("Name").setValue(user.name)
                    currentUserDb.child("Id").setValue(user.id)
                    currentUserDb.child("Email").setValue(Email)
                    currentUserDb.child("Roll").setValue(user.roll)
                    Toast.makeText(context,"Usuario registrado!!",Toast.LENGTH_LONG).show()
                    regNew(context)
                } else {
                    Toast.makeText(
                        context, "Error en la autenticacion, verifica tus datos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
    private fun regNew(context: Context) {
        var intent = Intent(context, MainRegister::class.java)
        context.startActivity(intent)
    }

}






