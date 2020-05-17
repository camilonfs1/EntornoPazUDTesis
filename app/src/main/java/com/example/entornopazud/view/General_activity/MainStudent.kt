package com.example.entornopazud.view.General_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.entornopazud.viewmodel.Interfaces.iComunicationFragmentsStudent
import com.example.entornopazud.R
import com.example.entornopazud.view.ComunicationModule.MainStudentChat
import com.example.entornopazud.view.EducationalModule.EducationalModule
import com.example.entornopazud.view.QualiModule.statisticsStudent
import com.google.firebase.auth.FirebaseAuth

class MainStudent : AppCompatActivity(), iComunicationFragmentsStudent {
   /* This activity contain the personal login case use for students */
    var FragmentStudent: Fragment? = null
    var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_estudent)
        mAuth = FirebaseAuth.getInstance()
        FragmentStudent =
            MainStudentFragment()//assign the fragment object
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerStudent, FragmentStudent!!).commit()
    }

    //functions inherited from the iComunicationFragmentsStudent class
    override fun Profile() {
        var name = nameUser()
        var course = couserUser()
        var intent = Intent(this, ownProfile::class.java)
        intent.putExtra("roll", "student")
        intent.putExtra("course", course)
        this.startActivity(intent)
    }

    override fun Activities1() {
        var name = nameUser()
        var intent = Intent(this, EducationalModule::class.java)
        intent.putExtra("name", name)
        intent.putExtra("roll","student")
        intent.putExtra("key", mAuth!!.uid)
        this.startActivity(intent)
    }

    override fun Stadistics() {
        var name = nameUser()
        var intent = Intent(this, statisticsStudent::class.java)
        intent.putExtra("name", name)
        intent.putExtra("roll","student")
        intent.putExtra("key", mAuth!!.uid)
        this.startActivity(intent)
    }

    override fun Avatar() {
        var name = nameUser()
        var course = couserUser()
        var intent = Intent(this, ownProfile::class.java)
        intent.putExtra("roll", "student")
        intent.putExtra("course", course)
        this.startActivity(intent)
    }

    override fun Prize() {
        mAuth!!.signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun Chats() {
        var name = nameUser()
        var intent = Intent(this, MainStudentChat::class.java)
        intent.putExtra("name", name)
        intent.putExtra("key", mAuth!!.uid)
        this.startActivity(intent)
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
    fun couserUser(): String {
        var course = intent.getStringExtra("course")
        return course

    }
}
