package com.example.entornopazud.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.entornopazud.Clases.Login
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"

    private var mAuth: FirebaseAuth? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null

    private var TextEmail: TextView? = null
    private var TextPass: TextView? = null
    private var BtnEnter: Button? = null
    private var mProgressBar: ProgressDialog? = null

    private var Email: String? = null
    private var Pass: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialise()
    }

    private fun initialise() {
        TextEmail = txtEmail
        TextPass = txtPass
        BtnEnter = btnEnter

        mProgressBar = ProgressDialog(this)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance()

        BtnEnter!!.setOnClickListener { login() }

    }

    private fun login() {
        Email = TextEmail?.text.toString()
        Pass = TextPass?.text.toString()

        if (!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Pass)) {//Only if full boxes is ok
            mProgressBar!!.setMessage("Registering User...")
            mProgressBar!!.show()
            Log.d(TAG, "Logging in user.")
            mAuth!!.signInWithEmailAndPassword(Email!!, Pass!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail:success")
                        updateUI()
                        //Toast.makeText(this, "Datos correctos :)", Toast.LENGTH_LONG).show()
                    } else {
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(this, "Tenemos un error :(", Toast.LENGTH_SHORT).show()
                    }                }
        } else {
            Toast.makeText(this, "Porfavor llena los datos :|", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        startActivity(Intent(this, Login::class.java))

    }



    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainRegister::class.java))
    }
}
