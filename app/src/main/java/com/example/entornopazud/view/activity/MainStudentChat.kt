package com.example.entornopazud.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.data.model.Courses
import com.example.entornopazud.R
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_main_student_chat.*
import kotlinx.android.synthetic.main.recycler_row.view.*

class MainStudentChat : AppCompatActivity() {
    private var Recycler: RecyclerView? = null
    private var BtnBack : Button?=null

    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_student_chat)
        var nameStudent = intent.getStringExtra("name")
        var keyStrudent = intent.getStringExtra("key")
        initialise(nameStudent.toString(), keyStrudent.toString())

    }

    private fun initialise(nameStudent: String, keyStrudent: String) {
        Recycler = recyclar_NewMen_stud
        BtnBack = BtnBackx

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference

        readDb(nameStudent,keyStrudent)

        BtnBack!!.setOnClickListener {
            var intent = Intent(this, MainStudent::class.java)
            intent.putExtra("name", nameStudent)
            intent.putExtra("key", keyStrudent)
            this.startActivity(intent)
        }

    }
    private fun readDb(nameStudent: String, keyStrudent: String){
        val adapter = GroupAdapter<GroupieViewHolder>()
        mDatabaseReference = mDatabase!!.reference.child("Courses")
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Courses(
                            e.child("Name").getValue().toString()
                        )
                        var teacher =
                            Courses(
                                e.child("Teacher").getValue().toString()
                            )
                        mDatabaseReference!!.child(cours.name).child("Students").addValueEventListener(object : ValueEventListener {
                            override fun onCancelled(p0: DatabaseError) {

                            }

                            override fun onDataChange(p1: DataSnapshot) {
                                if (p1.exists()) {
                                    for (e1 in p1.children) {
                                        var studentName = e1.child("Name").getValue().toString()
                                        var studentKey = e1.key
                                        if (studentName.equals(nameStudent)){

                                            searchTeacher(studentName,studentKey+"",teacher.name)

                                        }

                                    }
                                }
                            }

                        })

                    }
                }
            }

        })

    }
    private fun searchTeacher(studentName: String,studentKey: String,teacherName: String){
        val adapter = GroupAdapter<GroupieViewHolder>()
        mDatabaseReference = mDatabase!!.reference.child("Users")
        mDatabaseReference!!.child("Teachers").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                for (e1 in p0.children) {
                    var name = e1.child("Name").getValue().toString()
                    var email = e1.child("Email").getValue().toString()
                    var key = e1.key
                    if(name.equals(teacherName)){
                        println("--->"+name)
                        println("--->"+studentName)
                        println("--->"+studentKey)
                        adapter.add(
                            UserItemStudent(
                                name,
                                email,
                                key + ""
                            )
                        )
                    }


                }
                adapter.setOnItemClickListener { item, view ->
                    val UserItemStudent = item as UserItemStudent
                    val intent = Intent(view.context,
                        ChatLogActivity::class.java)
                    intent.putExtra("UserKeyA",studentKey)
                    intent.putExtra("userNameA",studentName)
                    intent.putExtra("userNameB",UserItemStudent.name)
                    intent.putExtra("UserKeyB",UserItemStudent.key)
                    intent.putExtra("Roll","Student")
                    startActivity(intent )
                    finish()
                }
            }

        })
        Recycler!!.adapter = adapter
    }
}

class UserItemStudent (name:String, email:String, key: String): Item<GroupieViewHolder>() {
     var name: String
     var email: String
    var key: String
    init {
        this.name = name
        this.email = email
        this.key = key
    }
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.txtName.text = name
        viewHolder.itemView.txtId.text = ""
        viewHolder.itemView.txtEmail.text = email
        viewHolder.itemView.txtCourse.text = "Docente"
    }

    override fun getLayout(): Int {
        return R.layout.recycler_row
    }

}
