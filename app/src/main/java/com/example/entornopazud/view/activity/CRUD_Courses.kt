package com.example.entornopazud.view.activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.entornopazud.viewmodel.Adapters.Adapter_Courses
import com.example.entornopazud.data.model.Courses
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_crud__courses.*

class CRUD_Courses : AppCompatActivity() {
    private var btnCreate: Button? = null
    private var btnDelete: Button? = null
    private var nameCourse: EditText? = null

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
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
        mProgressBar = ProgressDialog(this)
        mDatabase = FirebaseDatabase.getInstance()
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
        var name = nameCourse!!.text.toString()
        val mUser = nameUser()
        if (!name.isEmpty()) {
            val userId = mAuth!!.currentUser!!.uid
            //update user profile information
            val currentCoursDb = mDatabaseReference!!.child(name)
            currentCoursDb.child("Name").setValue(name)
            currentCoursDb.child("Teacher").setValue(mUser)
            nameCourse!!.setText("")
            var intent = Intent(this, CRUD_Courses::class.java)
            this.startActivity(intent)
            println("creado el curso")
            Toast.makeText(this, "Curso creado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Llena la casilla nombre", Toast.LENGTH_SHORT).show()
        }
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
    private fun deleteCourse(){
        var currentCours = mDatabaseReference?.child(nameCourse!!.text.toString())
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Quieres borrar a "+nameCourse!!.text.toString()+"?")
            .setCancelable(false)
            .setPositiveButton("Borrar", DialogInterface.OnClickListener { dialog, id ->
                currentCours?.removeValue()
                Toast.makeText(this, "Borrado", Toast.LENGTH_SHORT).show()
                nameCourse!!.setText("")
                readCoursesDb()
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Advertencia")
        alert.show()
    }

    private fun updateList(listaCourses: ArrayList<Courses>) {
        val adapter =
            Adapter_Courses(
                this,
                listaCourses
            )
        coursesList.adapter = adapter
        coursesList.setOnItemClickListener { parent, view, position, id ->
            val course = listaCourses[position]
            nameCourse!!.setText(course.name)
        }
    }
}
