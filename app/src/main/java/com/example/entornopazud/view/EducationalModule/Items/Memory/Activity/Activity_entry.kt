package com.example.entornopazud.view.EducationalModule.Items.Memory.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.entornopazud.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_entry.*

class Activity_entry : AppCompatActivity() {
    private var txtDescription: TextView? = null
    private var btnEnter: Button?=null
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var textRefection : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
        txtDescription = TextDescription
        btnEnter = BtnUpdateEntry
        textRefection = txtReflection

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")
        var text = intent.getStringExtra("activity")
        var activityName = intent.getStringExtra("activityName")

        txtDescription!!.setText(text)

        //if(roll.equals("student")){
            btnEnter!!.setOnClickListener {
                registeractivity(key,name,activityName)
            }
       // }else{
            Toast.makeText(this,"Solo Estudiantes",Toast.LENGTH_SHORT).show()
        //}


    }

    fun registeractivity(key : String, name:String,activityName: String){
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Qualifications")

        if (!textRefection!!.text.isEmpty()) {
            val currentCoursDb = mDatabaseReference!!.child(key)
            currentCoursDb.child("Name").setValue(name)
            currentCoursDb.child("Descipcion").setValue(textRefection!!.text)
            currentCoursDb.child("Actividad").setValue(activityName)
        }else {
            Toast.makeText(this, "Llena la casilla nombre", Toast.LENGTH_SHORT).show()
        }


    }


}
