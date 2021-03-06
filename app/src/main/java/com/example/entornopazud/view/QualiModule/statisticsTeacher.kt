package com.example.entornopazud.view.QualiModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.R
import com.example.entornopazud.model.models.Reflections
import com.example.entornopazud.viewmodel.Adapters.Adapter_Students
import com.example.entornopazud.viewmodel.Adapters.Adapter_reflections
import com.example.entornopazud.viewmodel.ListViewModel
import com.google.firebase.database.*

class statisticsTeacher : AppCompatActivity() {

    private val viewModel by lazy{ ViewModelProviders.of(this).get(ListViewModel::class.java) }
    private var mDatabase: FirebaseDatabase? = null
    private var adapter: Adapter_reflections? = null

    var recyclerActivity: RecyclerView? = null
    private var Reflections: ArrayList<Reflections> = ArrayList()

    private var mDatabaseReference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics_teacher)

        recyclerActivity = findViewById(R.id.recyclar_Activitys1)
        recyclerActivity!!.layoutManager = LinearLayoutManager(this)

        var key = intent.getStringExtra("key")
        reflection(key )



    }
    fun reflection(key : String){
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Qualifications").child(key).child("actividades")//Create child Courses in firebase database
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            //call "Courses" child in database firebase
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    for (e in p0.children) {
                        var activity = e.key
                        var reflection = e.child("Refleccion").getValue().toString()
                        var refle = Reflections(activity.toString(),reflection)
                        Reflections.add(refle)
                    }
                    adapter = Adapter_reflections(Reflections,R.layout.recycler_reflection)
                    recyclerActivity!!.adapter = adapter
                }
            }
        })
    }
}
