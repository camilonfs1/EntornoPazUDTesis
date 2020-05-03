package com.example.entornopazud.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.entornopazud.view.Fragments.MainStudentFragment
import com.example.entornopazud.viewmodel.Interfaces.iComunicationFragmentsStudent
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth

class MainStudent : AppCompatActivity(), iComunicationFragmentsStudent {
   /* This activity contain the personal login case use for students */
    var FragmentStudent: Fragment? = null
    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_estudent)
        mAuth = FirebaseAuth.getInstance()
        FragmentStudent = MainStudentFragment()//assign the fragment object
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerStudent, FragmentStudent!!).commit()
    }

    //functions inherited from the iComunicationFragmentsStudent class
    override fun Profile() {
        Toast.makeText(applicationContext, "Perfil", Toast.LENGTH_SHORT).show()
    }

    override fun Activities1() {
        var name = nameUser()
        var intent = Intent(this, EducationalModule::class.java)
        intent.putExtra("name", name)
        intent.putExtra("key", mAuth!!.uid)
        this.startActivity(intent)
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
}
