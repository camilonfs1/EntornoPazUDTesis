package com.example.entornopazud.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.entornopazud.Fragments.MainTeacherFragment
import com.example.entornopazud.Interfaces.iComunicationFragmentsTeacher
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_main_teacher.*

class MainTeacher : AppCompatActivity(), iComunicationFragmentsTeacher {
    /* This activity contain the personal login case use for students */
    var FragmentTeacher: Fragment? = null
    var mAuth: FirebaseAuth? = null
    var TextUserN: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher)

        TextUserN = findViewById(R.id.txtxUserName)



        mAuth = FirebaseAuth.getInstance()
        FragmentTeacher = MainTeacherFragment()//assign the fragment object
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FragmentTeacher!!)
            .commit()
    }

    //functions inherited from the iComunicationFragmentsTeacher class
    override fun Students() {
        startActivity(Intent(this, CRUD_Student_main::class.java))
    }

    override fun Courses() {
        Toast.makeText(applicationContext, "Cursos", Toast.LENGTH_SHORT).show()
    }

    override fun Stadistics() {
        Toast.makeText(applicationContext, "Estadisticas", Toast.LENGTH_SHORT).show()
    }

    override fun DataBases() {
        Toast.makeText(applicationContext, "Bases de datos", Toast.LENGTH_SHORT).show()
    }

    override fun Activitys() {
        Toast.makeText(applicationContext, "Actividades", Toast.LENGTH_SHORT).show()
    }

    override fun Chats() {
        Toast.makeText(applicationContext, "Chats", Toast.LENGTH_SHORT).show()
    }

    override fun SigOut() {
        mAuth!!.signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun nameUser(): String {
            var name = intent.getStringExtra("name")
       return name

    }


}
