package com.example.entornopazud.Activities

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.example.entornopazud.Clases.Login
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /* This activity contain the login case use  */
    private val TAG = "LoginActivity"

    //Firebase references
    private var mAuth: FirebaseAuth? = null
    private var mDatabase: FirebaseDatabase? = null
    //Initialize variables that use in XML view
    private var TextEmail: TextView? = null
    private var TextPass: TextView? = null
    private var BtnEnter: Button? = null
    private var Email: String? = null
    private var Pass: String? = null
    private var TextInternetConection: TextView? = null

    //Initialize progressBar
    private var mProgressBar: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        internetCon()
        initialise()
    }

    public fun internetCon() {
        TextInternetConection = txtInternetConection1
        val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnectedOrConnecting) {
            TextInternetConection!!.setText("")
        } else {
            TextInternetConection!!.setText("--> Error de conexion <--")
        }
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
            mProgressBar!!.setMessage("Buscando usuario...")
            mProgressBar!!.show()
            Log.d(TAG, "Logging in user.")
            mAuth!!.signInWithEmailAndPassword(
                Email!!,
                Pass!!
            )//call sigInWithEmail.. firebase function
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {//If login is succesfull
                        Log.d(TAG, "signInWithEmail:success")
                        updateUI()
                    } else {//If login isn't succesfull
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            this,
                            "Tenemos un error, comprueba tus datos y conexion :(",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        } else {
            Toast.makeText(this, "Porfavor llena los datos :|", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val mUser = mAuth!!.currentUser
        var intent = Intent(this, Login::class.java)
        intent.putExtra("mUser", mUser)
        this.startActivity(intent)
    }

    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainRegister::class.java))//Open Register Ac
    }

    /*override fun onStart() {
        super.onStart()

        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this, Login::class.java))//Open Login Activity
        }
    }*/
}
