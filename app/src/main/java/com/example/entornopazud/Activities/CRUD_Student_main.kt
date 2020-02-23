package com.example.entornopazud.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.Adapters.Adapter_Students
import com.example.entornopazud.Clases.User
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CRUD_Student_main : AppCompatActivity() {

    var mDatabase: DatabaseReference? = null
    var students: ArrayList<User> = ArrayList<User>()
    var recicler: RecyclerView? = null
    var adapter: Adapter_Students? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud__student_main)
        initialise()
    }

    private fun initialise() {

        mDatabase = FirebaseDatabase.getInstance().reference
        recicler = findViewById(R.id.recyclar_Students)
        recicler!!.layoutManager = LinearLayoutManager(this)
        datosFirebase()
    }

    private fun datosFirebase() {
        mDatabase!!.child("Users").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                students.clear()
                if (p0.exists()) {
                    for (e in p0.children) {
                        var name = e.child("Name").getValue().toString()
                        var email = e.child("Email").getValue().toString()
                        var id = e.child("Id").getValue().toString()
                        var roll = e.child("Roll").getValue().toString()
                        students!!.add(User(name, email,id,roll))
                    }
                    adapter = Adapter_Students(students, R.layout.recycler_row)
                    recicler!!.adapter = adapter
                }
            }

        })
    }


}

