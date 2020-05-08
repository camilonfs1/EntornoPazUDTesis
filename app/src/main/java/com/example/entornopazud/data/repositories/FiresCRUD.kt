package com.example.entornopazud.data.repositories

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import com.example.entornopazud.data.model.User
import com.example.entornopazud.view.activity.CRUD_Courses
import com.example.entornopazud.view.activity.List_Student_main
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.sql.DriverManager.println

class FiresCRUD {
    private var FireData: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var mDatabase: DatabaseReference? = null
    //----------------------------------------------------------------------CRUD Students-------------------------------------------------------------
    //updateStudent

    fun updateStudent(user: User, context: Context, techaer: String) {
        mDatabase = FirebaseDatabase.getInstance().reference.child("Courses").child(user.course)
        val currentUser = mDatabase?.child("Students")!!.child(user.key)
        val map = mutableMapOf<String, Any?>()
        map.put("Name", user.name)
        map.put("Id", user.id)
        map.put("Email", user.email)
        map.put("Roll", "Aprendiente")
        currentUser.updateChildren(map)
        Toast.makeText(context, "Actualizado", Toast.LENGTH_SHORT).show()

        val intent = Intent(context, List_Student_main::class.java)
        intent.putExtra("name", techaer)
        context.startActivity(intent)
    }

    //deleteStudent
    fun deleteStudent(user: User, context: Context, techaer: String) {
        mDatabase = FirebaseDatabase.getInstance().reference.child("Courses").child(user.course)
        var currentUser = mDatabase?.child("Students")?.child(user.key)
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Quieres borrar a " + user.name + "?").setCancelable(false)
            .setPositiveButton("Borrar", DialogInterface.OnClickListener { dialog, id ->
                currentUser?.removeValue()
                Toast.makeText(context, "Borrado", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, List_Student_main::class.java)
                intent.putExtra("name", techaer)
                context.startActivity(intent)
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Advertencia")
        alert.show()
    }

    //----------------------------------------------------------------------CRUD Courses-------------------------------------------------------------
    //Create Course
    fun createCourse(course: String, techaer: String, context: Context) {
        FireData = FirebaseDatabase.getInstance()
        mAuth = FirebaseAuth.getInstance()
        mDatabase = FireData!!.reference.child("Courses")//Create child Courses in firebase database
        if (!course.isEmpty()) {
            //update user profile information
            val currentCoursDb = mDatabase!!.child(course)
            currentCoursDb.child("Name").setValue(course)
            currentCoursDb.child("Teacher").setValue(techaer)
            println("creado el curso")
            Toast.makeText(context, "Curso creado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Llena la casilla nombre", Toast.LENGTH_SHORT).show()
        }
    }
    //Delete Course
    fun deleteCourse(course: String, context: Context){
        mDatabase = FireData!!.reference.child("Courses")
        var currentCours = mDatabase?.child(course)
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("Quieres borrar a "+course+"?") .setCancelable(false).setPositiveButton("Borrar", DialogInterface.OnClickListener { dialog, id ->
                currentCours?.removeValue()
                Toast.makeText(context, "Borrado", Toast.LENGTH_SHORT).show()
            }).setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Advertencia")
        alert.show()
    }
}