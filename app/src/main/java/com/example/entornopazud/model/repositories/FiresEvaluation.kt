package com.example.entornopazud.model.repositories

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FiresEvaluation {
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    fun registeractivity(key : String,activityName: String,nameStudent:String,reflection:String,context: Context){
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Qualifications").child(key)
        mDatabaseReference!!.child("Name").setValue(nameStudent)

        if (!reflection.isEmpty()) {
            val currentCoursDb = mDatabaseReference!!.child("actividades").child(activityName)
            currentCoursDb.child("Refleccion").setValue(reflection)
        }else {
            Toast.makeText(context, "Llena la casilla nombre", Toast.LENGTH_SHORT).show()
        }
    }
}