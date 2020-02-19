package com.example.entornopazud.Activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.entornopazud.Fragments.MainTeacherFragment
import com.example.entornopazud.Interfaces.iComunicationFragments
import com.example.entornopazud.R
import com.google.android.gms.dynamic.SupportFragmentWrapper
import kotlinx.android.synthetic.main.activity_main_teacher.*

class MainTeacher : AppCompatActivity(), MainTeacherFragment.OnFragmentInteractionListener, iComunicationFragments {

    var Fragment: MainTeacherFragment?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher)
        Fragment = MainTeacherFragment()

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, Fragment!!).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun iniciarjuego() {
        Toast.makeText(applicationContext,"Iniciar juego",Toast.LENGTH_SHORT).show()
    }


}
