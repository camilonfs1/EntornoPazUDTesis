package com.example.entornopazud.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.Adapters.Adapter_Students
import com.example.entornopazud.Clases.Courses
import com.example.entornopazud.Clases.User
import com.example.entornopazud.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_crud__student_main.*

class CRUD_Student_main : AppCompatActivity() {
    /*This class has the student list */
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null
    var students: ArrayList<User> = ArrayList<User>()
    var recyclerStudents: RecyclerView? = null
    var adapter: Adapter_Students? = null
    var btnHome: Button? = null
    private var CoursesList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud__student_main)
        initialise()
    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference
        recyclerStudents = findViewById(R.id.recyclar_Students)
        recyclerStudents!!.layoutManager = LinearLayoutManager(this)
        btnHome = BtnHome

        var name = intent.getStringExtra("name")

        btnHome!!.setOnClickListener {
            var intent = Intent(this, MainTeacher::class.java)
            intent.putExtra("name", name)
            this.startActivity(intent)
        }

        if (!name.isEmpty()){
            readCoursesDb(name)
        }

    }

    private fun readCoursesDb(mUser: String) {

        mDatabaseReference = mDatabase!!.reference!!.child("Courses")//Create child Courses in firebase database
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            //call "Courses" child in database firebase
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                CoursesList.clear()
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Courses(e.child("Name").getValue().toString())
                        var teacher = Courses(e.child("Teacher").getValue().toString())

                        if (teacher.name.equals(mUser)) {
                            CoursesList.add(cours.name)
                        }
                    }
                    datosFirebase(CoursesList,mUser)
                }

            }
        })
    }

    private fun datosFirebase(Courses: ArrayList<String>, mUser:String) {
        for (value in 0..Courses.size-1 ){
            otra(Courses[value],mUser) }
    }
fun otra(it : String,mUser: String){
    mDatabaseReference = mDatabase!!.reference!!.child("Courses").child(it+"").child("Students")
    mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
        //call "User" child in database firebase
        override fun onCancelled(p0: DatabaseError) {
        }
        override fun onDataChange(p0: DataSnapshot) {
            for (e in p0.children) {
                var name = e.child("Name").getValue().toString()
                var email = e.child("Email").getValue().toString()
                var id = e.child("Id").getValue().toString()
                var roll = e.child("Roll").getValue().toString()
                students!!.add(User(e.key.toString(), name, email, id, roll,it))
            }
            adapter = Adapter_Students( students,R.layout.recycler_row,mUser )//sent userlist to adapter class
            recyclerStudents!!.adapter =
                adapter

        }
    })
}



}



