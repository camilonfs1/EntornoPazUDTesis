package com.example.entornopazud.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.R
import com.example.entornopazud.data.model.Courses
import com.example.entornopazud.data.model.User
import com.example.entornopazud.view.Adapters.Adapter_Students
import com.google.firebase.database.*

class FiresList {
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var coursesList= ArrayList<Courses>()
    private var CoursesList1: ArrayList<String> = ArrayList()
    private var students: ArrayList<User> = ArrayList<User>()
    private var adapter: Adapter_Students? = null




    fun getCoursesData():LiveData<ArrayList<Courses>>{
        mDatabase = FirebaseDatabase.getInstance()
        val mutableData = MutableLiveData<ArrayList<Courses>>()
        mDatabaseReference = mDatabase!!.reference!!.child("Courses")//Create child Courses in firebase database
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            //call "Courses" child in database firebase
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Courses(
                            e.child("Name").getValue().toString()
                        )
                        coursesList.add(cours)
                    }
                    mutableData.value = coursesList
                }
            }
        })
        return mutableData
    }

    //----------------------------------------------------------------------CRUD Students-------------------------------------------------------------
    fun readCoursesDb(mUser: String,context: Context,recyStu: RecyclerView) {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference

        mDatabaseReference = mDatabase!!.reference.child("Courses")//Create child Courses in firebase database
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            //call "Courses" child in database firebase
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                CoursesList1.clear()
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Courses(
                            e.child("Name").getValue().toString()
                        )
                        var teacher =
                            Courses(
                                e.child("Teacher").getValue().toString()
                            )

                        if (teacher.name.equals(mUser)) {
                            CoursesList1.add(cours.name)
                        }
                    }
                   datosFirebase(CoursesList1,mUser,context,recyStu)
                }

            }
        })
    }
    fun datosFirebase(Courses: ArrayList<String>, mUser:String,context: Context,recyStu: RecyclerView) {
        for (value in Courses ){
            System.out.println(value)
            otra(value,mUser,context,recyStu)
        }
    }
    fun otra(it : String,mUser: String, context: Context,recyclerStudents1: RecyclerView ){
        recyclerStudents1!!.layoutManager = LinearLayoutManager(context)
        mDatabaseReference = mDatabase!!.reference.child("Courses").child(it+"").child("Students")
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
                    students.add(User(e.key.toString(),name,email,id,roll,it))
                }
                adapter = Adapter_Students(students,                    R.layout.recycler_row,
                    mUser
                )//sent userlist to adapter class
                recyclerStudents1!!.adapter = adapter
            }
        })
    }




}