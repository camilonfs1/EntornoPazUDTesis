package com.example.entornopazud.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.data.model.Courses
import com.example.entornopazud.data.model.User
import com.example.entornopazud.R
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_new_message_teacher.*
import kotlinx.android.synthetic.main.recycler_row.view.*

class NewMessageTeacher : AppCompatActivity() {
    private var BtnBack: Button? = null
    private var RecyNewMen: RecyclerView? = null

    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    private var nameTeacher: String? = null
    private var keyTeacher: String? = null

    private var CoursesList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message_teacher)

        nameTeacher = intent.getStringExtra("name")
        keyTeacher = intent.getStringExtra("key")
        initialise(nameTeacher.toString(),keyTeacher.toString())
    }

    private fun initialise(nameTeacher: String,keyTeacher: String) {
        BtnBack = BtnBackx
        RecyNewMen = recyclar_NewMen

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference
        readCoursesDb(keyTeacher,nameTeacher)

        BtnBack!!.setOnClickListener {
            var intent = Intent(this, MainTeacherChat::class.java)
            intent.putExtra("name", nameTeacher)
            intent.putExtra("key", keyTeacher)
            this.startActivity(intent)
        }
    }

    private fun readCoursesDb(keyTeacher: String,nameTeacher: String) {
        val adapter = GroupAdapter<GroupieViewHolder>()
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
                        var teacher =
                            Courses(
                                e.child("Teacher").getValue().toString()
                            )

                        if (teacher.name.equals(nameTeacher + "")) {
                            CoursesList.add(cours.name)
                        }
                    }
                    for (value in 0..CoursesList.size - 1) {
                        mDatabaseReference =
                            mDatabase!!.reference.child("Courses").child(CoursesList[value] + "")
                                .child("Students")
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
                                    adapter.add(
                                        UserItem(
                                            User(
                                                e.key.toString(),
                                                name,
                                                email,
                                                id,
                                                roll,
                                                CoursesList[value]
                                            )
                                        )
                                    )
                                }
                            }
                        })
                    }
                }
                adapter.setOnItemClickListener { item, view ->
                    val UserItem = item as UserItem
                    val intent = Intent(view.context,
                        ChatLogActivity::class.java)
                    intent.putExtra("UserKeyA",keyTeacher)
                    intent.putExtra("userNameA",nameTeacher)
                    intent.putExtra("userNameB",UserItem.user.name)
                    intent.putExtra("UserKeyB",UserItem.user.key)
                    intent.putExtra("Roll","Teacher")
                    startActivity(intent )
                    finish()
                }
            }
        })
        RecyNewMen!!.adapter = adapter
    }
}



class UserItem (val user: User): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.txtName.text = user.name
        viewHolder.itemView.txtId.text = ""
        viewHolder.itemView.txtEmail.text = ""
        viewHolder.itemView.txtCourse.text = user.course
    }

    override fun getLayout(): Int {
        return R.layout.recycler_row
    }

}
