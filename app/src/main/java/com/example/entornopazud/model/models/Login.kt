package com.example.entornopazud.model.models

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.entornopazud.view.General_activity.MainStudent
import com.example.entornopazud.view.General_activity.MainTeacher
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class Login : AppCompatActivity() {
    /* This class select diferent activity to Teachers or Students */
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var mUserReference: DatabaseReference? = null
    private var CoursesList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialise()
    }
    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference
        mAuth = FirebaseAuth.getInstance()

    }

    override fun onStart() {
        super.onStart()
        val mUser = mAuth!!.currentUser
        mUserReference = mDatabaseReference!!.child("Users").child("Teachers").child(mUser!!.uid)
        mUserReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {

                    var name = snapshot.child("Name").value as String
                    var Roll = snapshot.child("Roll").value as String

                    roll(Roll, name,"")

                } else {
                    System.out.println("--------------------------------No User")
                    readCoursesDb(mUser)
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    private fun readCoursesDb(mUser: FirebaseUser) {
        mDatabaseReference =
            mDatabase!!.reference.child("Courses")//Create child Courses in firebase database
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            //call "Courses" child in database firebase
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                CoursesList.clear()
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Courses(
                            e.child("Name").getValue().toString()
                        )
                        //println(cours.name)
                        CoursesList.add(cours.name)
                    }
                    StudentsRead(CoursesList, mUser)
                } else {
                    mens()
                }
            }
        })
    }

    private fun mens() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    private fun StudentsRead(listaCourses: ArrayList<String>, mUser: FirebaseUser) {
        var user = mUser
        mDatabaseReference = mDatabase!!.reference
        for (f in listaCourses) {
            mUserReference =
                mDatabaseReference!!.child("Courses").child(f).child("Students").child(user.uid)
            mUserReference?.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    mens()
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        var name = snapshot.child("Name").value as String
                        var Roll = snapshot.child("Roll").value as String
                        var course = f
                        roll(Roll, name,course)
                    }
                }
            })
        }
    }

    private fun roll(roll: String, name: String, course: String) {

        if (roll.equals("Docente") || roll.equals("Teacher")) {
            System.out.println("-------------------------------- User :"+name)
            var intent = Intent(this, MainTeacher::class.java)
            intent.putExtra("name", name)
            this.startActivity(intent)
        } else if (roll.equals("Aprendiente")|| roll.equals("student") ) {
            var intent = Intent(this, MainStudent::class.java)
            intent.putExtra("name", name)
            intent.putExtra("course", course)
            this.startActivity(intent)
        }
    }
}
