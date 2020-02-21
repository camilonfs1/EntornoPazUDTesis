package com.example.entornopazud.Activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.entornopazud.Fragments.MainTeacherFragment
import com.example.entornopazud.Interfaces.iComunicationFragments
import com.example.entornopazud.R

class MainTeacher : AppCompatActivity(), iComunicationFragments {

    var FragmentTeacher: Fragment?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher)
        FragmentTeacher = MainTeacherFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FragmentTeacher!!).commit()
    }


    override fun iniciarjuego() {
        Toast.makeText(applicationContext,"Iniciar app",Toast.LENGTH_SHORT).show()
    }


}
