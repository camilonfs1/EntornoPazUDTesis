package com.example.entornopazud.view.QualiModule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.R
import com.example.entornopazud.model.models.User
import com.example.entornopazud.view.General_activity.MainTeacher
import com.example.entornopazud.viewmodel.Adapters.Adapter_Students
import com.example.entornopazud.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_crud__student_main.*

class StatisticStudentsList : AppCompatActivity() {

    private val viewModel by lazy{ ViewModelProviders.of(this).get(ListViewModel::class.java) }

    var recyclerStudents: RecyclerView? = null
    var btnHome: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic_students_list)
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
        viewModel.courses(mUser, this, recyStu,"Statistic")
    }
}
