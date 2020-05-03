package com.example.entornopazud.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.entornopazud.R
import com.example.entornopazud.data.model.Courses
import com.example.entornopazud.data.model.User
import com.example.entornopazud.viewmodel.FirebaseViewModel
import com.example.entornopazud.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main_register.*

class MainRegister : AppCompatActivity() {
    /* This activity contain the register case use */

    //Initialize ViewModel Objects
    private val viewModel by lazy{ ViewModelProviders.of(this).get(ListViewModel::class.java) }
    private val RegControl = FirebaseViewModel()

    //Initialize variables that use in XML view
    private var TextEmail: EditText? = null
    private var TextPass: EditText? = null
    private var TextId: EditText? = null
    private var TextName: EditText? = null
    private var TextPassConf: EditText? = null
    private var RadioStud: RadioButton? = null
    private var RadioTech: RadioButton? = null
    private var BtnReg: Button? = null
    private var SCourses: Spinner? = null
    private var ini: TextView? = null

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
        SCourses = spinnerCourses
        ini=txtInicio
        readCoursesDb()
        ini!!.setOnClickListener {
            onClickRegister()
        }
        BtnReg!!.setOnClickListener {
            registerUser()
        }
    }

    private fun readCoursesDb() {
        viewModel.fechCoursData().observe(this, Observer {
            updateList(it)
        })
    }
    private fun updateList(lC: ArrayList<Courses>) {
        val b = ArrayList<String>()
        for( x in lC ){
            b.add(x.name)
        }
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,b)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        SCourses!!.setAdapter(adapter)
    }
    private fun registerUser() {
        Name = TextName?.text.toString()
        Id = TextId?.text.toString()
        Email = TextEmail?.text.toString()
        Pass = TextPass?.text.toString()
        PassConf = TextPassConf?.text.toString()
        Roll = Radios()//Call radios function
        var Cours = SCourses?.selectedItem.toString()
        val user = User(Pass.toString(),Name.toString(),Email.toString(),Id.toString(),Roll.toString(),Cours)
        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Id) && !TextUtils.isEmpty(Email)&& !TextUtils.isEmpty(Pass) && !TextUtils.isEmpty(PassConf) && !TextUtils.isEmpty(Roll)//If no box is empty
        ) {
            if (Pass == PassConf && Pass!!.length >= 6) {//Only six characters is good for pass
                RegControl.register(this,Email.toString(),Pass.toString(),user)
            } else {
                Toast.makeText(this, "Error en la contraseña", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show()
        }
    }
    private fun Radios(): String {//Determined which radioButton isSelected
        var Roll = ""
        var curso = SCourses?.selectedItem.toString()
        if (RadioStud!!.isChecked() && !curso.isEmpty()) {//Which radioButton is selected by user
            Roll = "Aprendiente"//Student radioButton is selected
        } else if (RadioTech!!.isChecked()) {
            Roll = "Docente"//Teacher radioButton is selected
        }
        return Roll
    }
    fun onClickRegister() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}





