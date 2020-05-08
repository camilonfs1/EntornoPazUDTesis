package com.example.entornopazud.view.General_activity

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.entornopazud.R
import com.example.entornopazud.viewmodel.FirebaseViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /* This activity contain the login case use  */
    private val AuthControl = FirebaseViewModel()

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

    private fun internetCon() {
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
        BtnEnter!!.setOnClickListener { login() }
    }

    private fun login() {
        Email = TextEmail?.text.toString()
        Pass = TextPass?.text.toString()
        AuthControl.login(this,Email+"",Pass+"")
    }

    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainRegister::class.java))//Open Register Ac
    }

}
