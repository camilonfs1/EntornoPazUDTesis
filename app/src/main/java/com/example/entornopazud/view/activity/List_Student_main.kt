package com.example.entornopazud.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.viewmodel.Adapters.Adapter_Students
import com.example.entornopazud.data.model.Courses
import com.example.entornopazud.data.model.User
import com.example.entornopazud.R
import com.example.entornopazud.viewmodel.ListViewModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_crud__student_main.*

class List_Student_main : AppCompatActivity() {
    /*This class has the student list */
    private val viewModel by lazy{ ViewModelProviders.of(this).get(ListViewModel::class.java) }

    var students: ArrayList<User> = ArrayList<User>()
    var recyclerStudents: RecyclerView? = null
    var adapter: Adapter_Students? = null
    var btnHome: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud__student_main)
        initialise()
    }
    private fun initialise() {
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
            readCoursesDb(name, recyclerStudents!!)
        }
    }
    private fun readCoursesDb(mUser: String,recyStu: RecyclerView) {
        viewModel.courses(mUser, this, recyStu)
    }


}



