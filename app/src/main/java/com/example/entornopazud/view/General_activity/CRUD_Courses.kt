package com.example.entornopazud.view.General_activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.entornopazud.viewmodel.Adapters.Adapter_Courses
import com.example.entornopazud.model.models.Courses
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_crud__courses.*

class CRUD_Courses : AppCompatActivity() {


    private val CRUDViewModel = com.example.entornopazud.viewmodel.CRUDViewModel()

    private var btnCreate: Button? = null
    private var btnDelete: Button? = null
    private var nameCourse: EditText? = null
    private var list: ListView?=null

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null//----------------------
    private var mAuth: FirebaseAuth? = null


    private var mProgressBar: ProgressDialog? = null
    private var CoursesList: ArrayList<Courses> = ArrayList<Courses>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud__courses)
        initialise()
    }

    private fun initialise() {
        btnCreate = BtnCreateCourse
        btnDelete = BtnDeleteCourse
        nameCourse = txtCourseName
        list = coursesList
        mProgressBar = ProgressDialog(this)
        mDatabase = FirebaseDatabase.getInstance()//---------------------------
        mAuth = FirebaseAuth.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Courses")//Create child Courses in firebase database
        readCoursesDb()

        btnCreate?.setOnClickListener {
            createCourse()
        }
        btnDelete?.setOnClickListener {
            deleteCourse()
        }
    }
    fun nameUser(): String {
        var name = intent.getStringExtra("name")
        return name
    }

    private fun createCourse() {
        CRUDViewModel.createCourse(nameCourse!!.text.toString(),nameUser(),this)
        nameCourse!!.setText("")
    }

    private fun deleteCourse(){
        CRUDViewModel.deleteCourse(nameCourse!!.text.toString(),this)
        nameCourse!!.setText("")

        readCoursesDb()
    }
    private fun readCoursesDb() {
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
                        CoursesList.add(cours)
                    }
                    updateList(CoursesList)
                }
            }
        })
    }

    private fun updateList(listaCourses: ArrayList<Courses>) {
        for (i in listaCourses){
         System.out.println(i.name)
        }
        val adapter =  Adapter_Courses(this, listaCourses)

        list!!.adapter = adapter
        list!!.setOnItemClickListener { parent, view, position, id ->
            val course = listaCourses[position]
            nameCourse!!.setText(course.name)
        }
    }
}
