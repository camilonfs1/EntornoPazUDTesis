package com.example.entornopazud.Clases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entornopazud.Activities.MainStudent
import com.example.entornopazud.Activities.MainTeacher
import com.example.entornopazud.Fragments.MainTeacherFragment
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Login : AppCompatActivity() {
    /* This class select diferent activity to Teachers or Students */
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialise()
    }
    private fun initialise(){
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()

    }
    override fun onStart() {
        super.onStart()
        val mUser = mAuth!!.currentUser
        val mUserReference = mDatabaseReference!!.child(mUser!!.uid)
        mUserReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val roll =snapshot.child("Roll").value as String
                val name =snapshot.child("Name").value as String
                roll(roll, name)
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
    private fun roll(roll:String, name:String){
        if(roll.equals("Docente")){
            var intent = Intent(this,MainTeacher::class.java)
            intent.putExtra("name",name)
            this.startActivity(intent)
        }else if(roll.equals("Aprendiente")){
            startActivity(Intent(this, MainStudent::class.java))
        }
    }
}
