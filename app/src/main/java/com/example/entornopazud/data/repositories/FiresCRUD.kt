package com.example.entornopazud.data.repositories

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.entornopazud.data.model.User
import com.example.entornopazud.view.activity.List_Student_main
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FiresCRUD {
    private var mDatabase: DatabaseReference? = null
    //----------------------------------------------------------------------CRUD Students-------------------------------------------------------------
    //updateStudent

    fun updateStudent(user: User,context: Context,techaer:String) {
        mDatabase = FirebaseDatabase.getInstance().reference.child("Courses").child(user.course)
        val currentUser = mDatabase?.child("Students")!!.child(user.key)
        val map = mutableMapOf<String, Any?>()
        map.put("Name",user.name)
        map.put("Id",user.id)
        map.put("Email",user.email)
        map.put("Roll","Aprendiente")
        currentUser.updateChildren(map)
        Toast.makeText(context, "Actualizado", Toast.LENGTH_SHORT).show()

        val intent = Intent(context,List_Student_main::class.java)
        intent.putExtra("name",techaer)
        context.startActivity(intent)
    }



}