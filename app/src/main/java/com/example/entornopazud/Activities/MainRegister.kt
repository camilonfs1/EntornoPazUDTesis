package com.example.entornopazud.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main_register.*
import kotlinx.android.synthetic.main.activity_main_register.txtEmail
import kotlinx.android.synthetic.main.activity_main_register.txtPass

class MainRegister : AppCompatActivity() {
    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null


    private var TextEmail: EditText? = null
    private var TextPass: EditText? = null
    private var TextId: EditText? = null
    private var TextName: EditText? = null
    private var TextPassConf: EditText? = null
    private var RadioStud: RadioButton? = null
    private var RadioTech: RadioButton? = null
    private var BtnReg: Button? = null

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
        TextName= txtName
        BtnReg = btnRegister

        mProgressBar = ProgressDialog(this)

        mDatabase = FirebaseDatabase.getInstance()
        mAuth = FirebaseAuth.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
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
        Roll = Radios()


        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Id) && !TextUtils.isEmpty(Email)
            && !TextUtils.isEmpty(Pass) && !TextUtils.isEmpty(PassConf) && !TextUtils.isEmpty(Roll)
        ) {
            if (Pass == PassConf && Pass!!.length >= 6) {
                mProgressBar!!.setMessage("Registrando Usuario...")
                mProgressBar!!.show()

                mAuth!!
                    .createUserWithEmailAndPassword(Email!!, Pass!!)
                    .addOnCompleteListener(this) { task ->
                        mProgressBar!!.hide()
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
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

    private fun verifyEmail() {
        val mUser = mAuth!!.currentUser;
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Verification email sent to " + mUser.getEmail(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Log.e(TAG, "sendEmailVerification", task.exception)
                    Toast.makeText(
                        this,
                        "Failed to send verification email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    fun onClickRegister(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}




