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
import android.widget.*
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_register.*
import kotlinx.android.synthetic.main.activity_main_register.txtEmail
import kotlinx.android.synthetic.main.activity_main_register.txtPass

class MainRegister : AppCompatActivity() {
    /* This activity contain the register case use */
    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    //Initialize variables that use in XML view
    private var TextEmail: EditText? = null
    private var TextPass: EditText? = null
    private var TextId: EditText? = null
    private var TextName: EditText? = null
    private var TextPassConf: EditText? = null
    private var RadioStud: RadioButton? = null
    private var RadioTech: RadioButton? = null
    private var BtnReg: Button? = null

    //Progress Dialog declaration
    private var mProgressBar: ProgressDialog? = null
    private val TAG = "CreateAccountActivity"

    //global variables
    private var Name: String? = null
    private var Id: String? = null
    private var Email: String? = null
    private var Pass: String? = null
    private var PassConf: String? = null
    private var Roll: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)

        initialise()
    }



    private fun initialise() {

        TextEmail = txtEmail
        TextId = txtId
        TextPass = txtPass
        TextPassConf = txtPassConfirm
        RadioStud = RBtnStudReg
        RadioTech = RbtnTechReg
        TextName = txtName
        BtnReg = btnRegister

        mProgressBar = ProgressDialog(this)

        mDatabase = FirebaseDatabase.getInstance()
        mAuth = FirebaseAuth.getInstance()
        mDatabaseReference =
            mDatabase!!.reference!!.child("Users")//Create child Users in firebase database

        BtnReg!!.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser() {
        Name = TextName?.text.toString()
        Id = TextId?.text.toString()
        Email = TextEmail?.text.toString()
        Pass = TextPass?.text.toString()
        PassConf = TextPassConf?.text.toString()
        Roll = Radios()//Call radios function


        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Id) && !TextUtils.isEmpty(Email)
            && !TextUtils.isEmpty(Pass) && !TextUtils.isEmpty(PassConf) && !TextUtils.isEmpty(Roll)//If no box is empty
        ) {
            if (Pass == PassConf && Pass!!.length >= 6) {//Only six characters is good for pass
                mProgressBar!!.setMessage("Registrando Usuario...")
                mProgressBar!!.show()

                mAuth!!
                    .createUserWithEmailAndPassword(Email!!, Pass!!)//Create login with
                    .addOnCompleteListener(this) { task ->
                        mProgressBar!!.hide()

                        if (task.isSuccessful) { // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            val userId = mAuth!!.currentUser!!.uid
                            //Verify Email
                            verifyEmail()
                            //update user profile information
                            val currentUserDb = mDatabaseReference!!.child(userId)
                            currentUserDb.child("Name").setValue(Name)
                            currentUserDb.child("Id").setValue(Id)
                            currentUserDb.child("Email").setValue(Email)
                            currentUserDb.child("Roll").setValue(Roll)

                            updateUserInfoAndUI()
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                this, "Error en la autenticacion.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Error en la contraseña", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun Radios(): String {//Determined which radioButton isSelected
        var Roll = ""
        if (RadioStud!!.isChecked()) {//Which radioButton is selected by user
            Roll = "Aprendiente"//Student radioButton is selected
        } else if (RadioTech!!.isChecked()) {
            Roll = "Docente"//Teacher radioButton is selected
        }
        return Roll
    }

    private fun updateUserInfoAndUI() {
        //Put boxes empty
        TextEmail!!.setText("")
        TextId!!.setText("")
        TextPass!!.setText("")
        TextPassConf!!.setText("")
        TextName!!.setText("")
    }

    private fun verifyEmail() {//This function check de email
        val mUser = mAuth!!.currentUser
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Email correcto " + mUser.getEmail(), Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Log.e(TAG, "sendEmailVerification", task.exception)
                    Toast.makeText(this, "Email incorrecto.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}




