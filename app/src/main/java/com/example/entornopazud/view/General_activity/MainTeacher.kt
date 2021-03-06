package com.example.entornopazud.view.General_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.entornopazud.viewmodel.Interfaces.iComunicationFragmentsTeacher
import com.example.entornopazud.R
import com.example.entornopazud.view.ComunicationModule.MainTeacherChat
import com.example.entornopazud.view.EducationalModule.EducationalModule
import com.example.entornopazud.view.QualiModule.StatisticStudentsList
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.*

class MainTeacher : AppCompatActivity(), iComunicationFragmentsTeacher {
    /* This activity contain the personal login case use for students */

    var FragmentTeacher: Fragment? = null
    var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher)
        mAuth = getInstance()
        FragmentTeacher =
            MainTeacherFragment()//assign the fragment object
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FragmentTeacher!!)
            .commit()
    }

    //functions inherited from the iComunicationFragmentsTeacher class
    override fun Students() {
        var name = nameUser()
        var intent = Intent(this, List_Student_main::class.java)
        intent.putExtra("name", name)
        this.startActivity(intent)
    }

    override fun Courses() {
        var name = nameUser()
        var intent = Intent(this, CRUD_Courses::class.java)
        intent.putExtra("name", name)
        this.startActivity(intent)
    }

    override fun Stadistics() {
        var name = nameUser()
        var intent = Intent(this, StatisticStudentsList::class.java)
        intent.putExtra("name", name)
        this.startActivity(intent)
    }

    override fun DataBases() {
        var intent = Intent(this, ownProfile::class.java)
        intent.putExtra("roll","teacher" )
        this.startActivity(intent)
    }

    override fun Activitys() {
        var name = nameUser()
        var intent = Intent(this, EducationalModule::class.java)
        intent.putExtra("name", name)
        intent.putExtra("roll","teacher")
        intent.putExtra("key", mAuth!!.uid)
        this.startActivity(intent)
    }

    override fun Chats() {
        var name = nameUser()
        var intent = Intent(this, MainTeacherChat::class.java)
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


}
