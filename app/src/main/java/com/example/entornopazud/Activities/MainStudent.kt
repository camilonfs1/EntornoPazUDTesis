package com.example.entornopazud.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.entornopazud.Fragments.MainStudentFragment
import com.example.entornopazud.Interfaces.iComunicationFragmentsStudent
import com.example.entornopazud.R

class MainStudent : AppCompatActivity(), iComunicationFragmentsStudent {
   /* This activity contain the personal login case use for students */
    var FragmentStudent: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_estudent)

        FragmentStudent = MainStudentFragment()//assign the fragment object
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerStudent, FragmentStudent!!).commit()
    }

    //functions inherited from the iComunicationFragmentsStudent class
    override fun Profile() {
        Toast.makeText(applicationContext, "Perfil", Toast.LENGTH_SHORT).show()
    }

    override fun Activities1() {
        Toast.makeText(applicationContext, "Aprender", Toast.LENGTH_SHORT).show()
    }

    override fun Stadistics() {
        Toast.makeText(applicationContext, "Estadisticas", Toast.LENGTH_SHORT).show()
    }

    override fun Avatar() {
        Toast.makeText(applicationContext, "Avatar", Toast.LENGTH_SHORT).show()
    }

    override fun Prize() {
        Toast.makeText(applicationContext, "Premios", Toast.LENGTH_SHORT).show()
    }

    override fun Chats() {
        Toast.makeText(applicationContext, "chat", Toast.LENGTH_SHORT).show()
    }
}
