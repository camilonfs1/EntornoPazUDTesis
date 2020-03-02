package com.example.entornopazud.Activities;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_main_teacher_chat.*

class MainTeacherChat : AppCompatActivity() {

    private var BtnHome: Button? = null
    private var BtnNewMen: Button? = null

    private var nameTeacher: String? = null
    private var keyTeacher: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher_chat)
        nameTeacher = intent.getStringExtra("name")
        keyTeacher = intent.getStringExtra("key")
        initialise(nameTeacher!!, keyTeacher!!)
    }

    private fun initialise(nameTeacher: String, keyTeacher : String) {
        BtnHome = BtnHomeTeacher
        BtnNewMen = BtnNewMenMain

        BtnHome!!.setOnClickListener {
            var intent = Intent(this, MainTeacher::class.java)
            intent.putExtra("name", nameTeacher)
            intent.putExtra("key", keyTeacher)
            this.startActivity(intent)
        }
        BtnNewMen!!.setOnClickListener {
            var intent = Intent(this, NewMessageTeacher::class.java)
            intent.putExtra("name", nameTeacher)
            intent.putExtra("key", keyTeacher)
            this.startActivity(intent)
        }
    }
}
