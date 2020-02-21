package com.example.entornopazud.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.entornopazud.Fragments.MainTeacherFragment
import com.example.entornopazud.Interfaces.iComunicationFragmentsTeacher
import com.example.entornopazud.R

class MainTeacher : AppCompatActivity(), iComunicationFragmentsTeacher {

    var FragmentTeacher: Fragment?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher)

        FragmentTeacher = MainTeacherFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FragmentTeacher!!).commit()
    }


    override fun Students() {
        Toast.makeText(applicationContext,"Aprendientes",Toast.LENGTH_SHORT).show()
    }

    override fun Courses() {
        Toast.makeText(applicationContext,"Cursos",Toast.LENGTH_SHORT).show()
    }

    override fun Stadistics() {
        Toast.makeText(applicationContext,"Estadisticas",Toast.LENGTH_SHORT).show()
    }

    override fun DataBases() {
        Toast.makeText(applicationContext,"Bases de datos",Toast.LENGTH_SHORT).show()
    }

    override fun Activitys() {
        Toast.makeText(applicationContext,"Actividades",Toast.LENGTH_SHORT).show()
    }

    override fun Chats() {
        Toast.makeText(applicationContext,"Chats",Toast.LENGTH_SHORT).show()
    }


}
