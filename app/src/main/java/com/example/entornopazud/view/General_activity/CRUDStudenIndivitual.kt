package com.example.entornopazud.view.General_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.entornopazud.R
import com.example.entornopazud.model.models.User
import com.example.entornopazud.viewmodel.CRUDViewModel
import kotlinx.android.synthetic.main.activity_crudstuden_indivitual.*


class CRUDStudenIndivitual : AppCompatActivity() {


    private val CRUDViewModel = CRUDViewModel()

    private var TextName: TextView? = null
    private var TextID: TextView? = null
    private var TextEmail: TextView? = null
    private var BtnUpdate: Button? = null
    private var BtnDelete: Button? = null
    private var TextKey: TextView? = null

    private var name: String? = null
    private var id: String? = null
    private var email: String? = null
    private var roll: String? = null
    private var course: String? = null
    private var key: String? = null
    private var Teacher: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crudstuden_indivitual)
        TextName = txtNameCrud
        TextID = txtIdCRUD
        TextEmail = txtEmailCRUD
        BtnDelete = findViewById(R.id.BtnDeleteCrud)
        BtnUpdate = findViewById(R.id.BtnUpdateCrud)
        TextKey = txtKey
        getIncomingIntent()
        BtnUpdate?.setOnClickListener {
            updateStudent(course+"",Teacher+"")
        }
        BtnDelete?.setOnClickListener {
            deleteStudent(course+"",Teacher+"")
        }
    }

    private fun updateStudent(course:String,techer:String) {
        var user = User(key.toString(),TextName?.text.toString(),TextEmail?.text.toString(),TextID?.text.toString(),"Aprendiente",course)
        CRUDViewModel.CrudStuden(user,this,techer)
    }

    private fun deleteStudent(course:String,techer:String) {
        var user = User(key.toString(),TextName?.text.toString(),TextEmail?.text.toString(),TextID?.text.toString(),"Aprendiente",course)
        CRUDViewModel.deleteStuden(user,this,techer)
    }

    fun getIncomingIntent() {
        if (intent.hasExtra("name") && intent.hasExtra("id") && intent.hasExtra("email") && intent.hasExtra("roll" )) {
            key = intent.getStringExtra("key")
            name = intent.getStringExtra("name")
            id = intent.getStringExtra("id")
            email = intent.getStringExtra("email")
            roll = intent.getStringExtra("roll")
            course = intent.getStringExtra("course")
            Teacher = intent.getStringExtra("Teacher")
            TextName!!.setText(name)
            TextID!!.setText(id)
            TextEmail!!.setText(email)
        }
    }


}
