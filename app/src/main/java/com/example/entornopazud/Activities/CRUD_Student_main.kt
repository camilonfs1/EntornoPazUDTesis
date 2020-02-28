package com.example.entornopazud.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.Adapters.Adapter_Students
import com.example.entornopazud.Clases.User
import com.example.entornopazud.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_crud__student_main.*

class CRUD_Student_main : AppCompatActivity() {
    /*This class has the student list */
    var mDatabase: DatabaseReference? = null
    var students: ArrayList<User> = ArrayList<User>()
    var recyclerStudents: RecyclerView? = null
    var adapter: Adapter_Students? = null
    var btnHome: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud__student_main)
        initialise()
    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance().reference
        recyclerStudents = findViewById(R.id.recyclar_Students)
        recyclerStudents!!.layoutManager = LinearLayoutManager(this)
        btnHome=BtnHome
        btnHome!!.setOnClickListener {
            startActivity(Intent(this, MainTeacher::class.java))
        }
        datosFirebase()
    }

    private fun datosFirebase() {

        /*mDatabase!!.child("Aprendientes").addValueEventListener(object : ValueEventListener {
            //call "User" child in database firebase
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                students.clear()//clead de userlist
                if (p0.exists()) {//if User child exist
                    for (e in p0.children) {
                        var key = e.key.toString()
                        var name = e.child("Name").getValue().toString()
                        var email = e.child("Email").getValue().toString()
                        var id = e.child("Id").getValue().toString()
                        var roll = e.child("Roll").getValue().toString()
                        if (roll.equals("Aprendiente")) {
                            students!!.add(User(key,name, email, id, roll))
                        }
                    }
                    adapter = Adapter_Students(
                        students,
                        R.layout.recycler_row
                        )//sent userlist to adapter class
                    recyclerStudents!!.adapter = adapter//assign adapter to recyclerView
                }
            }

        })*/
    }


}

