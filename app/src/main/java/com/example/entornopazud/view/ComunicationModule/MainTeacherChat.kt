package com.example.entornopazud.view.ComunicationModule;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.entornopazud.model.models.Courses
import com.example.entornopazud.R
import com.example.entornopazud.view.General_activity.MainTeacher
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_main_teacher_chat.*
import kotlinx.android.synthetic.main.row_lates_message.view.*

class MainTeacherChat : AppCompatActivity() {
    private var BtnHome: Button? = null
    private var BtnNewMen: Button? = null

    private var nameTeacher: String? = null
    private var keyTeacher: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher_chat)
        nameTeacher = intent.getStringExtra("name")
        keyTeacher = intent.getStringExtra("key")
        initialise(nameTeacher!!, keyTeacher!!)
        recyLatesMessages.adapter = adapter

    }

    private fun initialise(nameTeacher: String, keyTeacher: String) {
        BtnHome = BtnHomeTeacher
        BtnNewMen = BtnNewMenMain

        BtnHome!!.setOnClickListener {
            var intent = Intent(this, MainTeacher::class.java)
            intent.putExtra("name", nameTeacher)
            intent.putExtra("key", keyTeacher)
            this.startActivity(intent)
        }
        BtnNewMen!!.setOnClickListener {
            var intent = Intent(this, NewMessageTeacher::class.java)
            intent.putExtra("name", nameTeacher)
            intent.putExtra("key", keyTeacher)
            this.startActivity(intent)
        }
        listForLatesMassages(keyTeacher,nameTeacher)

    }


    private fun listForLatesMassages(keyTeacher: String, nameTeacher: String) {

        val ref = FirebaseDatabase.getInstance().getReference("/latest-messages/$keyTeacher")
        ref.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }
            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                var message = p0.child("text").getValue().toString()
                var keyStudent = p0.child("from" +
                        "Id").getValue().toString()
                readStudent(nameTeacher, keyStudent,message)
            }
            override fun onChildRemoved(p0: DataSnapshot) {
            }
        })
    }


    val adapter = GroupAdapter<GroupieViewHolder>()

    private fun readStudent(nameTeacher: String, keyStudent: String,message: String) {
        var CoursesList: ArrayList<String> = ArrayList()
        var mDatabase = FirebaseDatabase.getInstance()
        var mDatabaseReference = mDatabase.reference.child("Courses")

        mDatabaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                CoursesList.clear()
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Courses(
                            e.child("Name").getValue().toString()
                        )
                        var teacher =
                            Courses(
                                e.child("Teacher").getValue().toString()
                            )
                        if (teacher.name.equals(nameTeacher + "")) {
                            CoursesList.add(cours.name)
                        }
                    }
                }
                for (value in 0..CoursesList.size - 1) {
                    mDatabaseReference =
                        mDatabase.reference!!.child("Courses").child(CoursesList[value] + "")
                            .child("Students")
                    mDatabaseReference.addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                        }

                        override fun onDataChange(p1: DataSnapshot) {
                            var nameStudent =""
                            for(e in p1.children){
                                println(e.key+"<-------------->"+keyStudent)
                                if(e.key.equals(keyStudent)){
                                    nameStudent = e.child("Name").getValue().toString()
                                    println(nameStudent+"<-------------------------")
                                    adapter.add(
                                        LatesMessageRow(
                                            nameStudent,
                                            message
                                        )
                                    )
                                }
                            }
                            adapter.setOnItemClickListener { item, view ->
                                val intent = Intent(view.context,
                                    ChatLogActivity::class.java)
                                intent.putExtra("UserKeyA",keyTeacher)
                                intent.putExtra("userNameA",nameTeacher)
                                intent.putExtra("userNameB",nameStudent)
                                intent.putExtra("UserKeyB",keyStudent)
                                intent.putExtra("Roll","Teacher")
                                startActivity(intent)
                                finish()
                            }
                        }
                    })
                }
            }
        })


    }


}
class LatesMessageRow(text: String,studentName:String) : Item<GroupieViewHolder>() {
    var text = ""
    var name = ""

    init {
        this.text = text
        this.name = studentName
    }

    override fun getLayout(): Int {
        return R.layout.row_lates_message
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.txtNameLates.text = text
        viewHolder.itemView.txtLatesMessage.text = name
    }

}


