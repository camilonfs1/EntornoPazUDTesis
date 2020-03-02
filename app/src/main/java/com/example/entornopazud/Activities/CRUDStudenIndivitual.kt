package com.example.entornopazud.Activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.media.MediaMetadataCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.entornopazud.Clases.User
import com.example.entornopazud.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_crudstuden_indivitual.*


class CRUDStudenIndivitual : AppCompatActivity() {

    private var TextName: TextView? = null
    private var TextID: TextView? = null
    private var TextEmail: TextView? = null
    private var BtnUpdate: Button? = null
    private var BtnDelete: Button? = null
    private var TextKey: TextView? = null

    private var name: String? = null
    private var id: String? = null
    private var email: String? = null
    private var roll: String? = null
    private var course: String? = null
    private var key: String? = null
    private var Teacher: String? = null

    private var mDatabase: DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crudstuden_indivitual)
        TextName = txtNameCrud
        TextID = txtIdCRUD
        TextEmail = txtEmailCRUD
        BtnDelete = findViewById(R.id.BtnDeleteCrud)
        BtnUpdate = findViewById(R.id.BtnUpdateCrud)
        TextKey = txtKey
        getIncomingIntent()
        mDatabase = FirebaseDatabase.getInstance().reference.child("Courses").child(course+"")
        BtnUpdate?.setOnClickListener {
            updateStudent()

        }
        BtnDelete?.setOnClickListener {
            deleteStudent()
        }


    }

    private fun updateStudent() {
        val currentUser = mDatabase?.child("Students")!!.child(key.toString())
        val map = mutableMapOf<String, Any?>()
        map.put("Name",TextName?.text.toString())
        map.put("Id",TextID?.text.toString())
        map.put("Email",TextEmail?.text.toString())
        map.put("Roll","Aprendiente")
        currentUser.updateChildren(map)
        Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show()
        var intent = Intent(this,CRUD_Student_main::class.java)
        intent.putExtra("name",Teacher)
        startActivity(intent)
    }

    private fun deleteStudent() {
        var currentUser = mDatabase?.child("Students")?.child(key.toString())
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Quieres borrar a "+name+"?")
            .setCancelable(false)
            .setPositiveButton("Borrar", DialogInterface.OnClickListener { dialog, id ->
                currentUser?.removeValue()
                Toast.makeText(this, "Borrado", Toast.LENGTH_SHORT).show()
                finish()
                var intent = Intent(this,CRUD_Student_main::class.java)
                intent.putExtra("name",Teacher)
                startActivity(intent)
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Advertencia")
        alert.show()
    }

    fun getIncomingIntent() {
        if (intent.hasExtra("name") && intent.hasExtra("id") && intent.hasExtra("email") && intent.hasExtra("roll" )) {
            key = intent.getStringExtra("key")
            name = intent.getStringExtra("name")
            id = intent.getStringExtra("id")
            email = intent.getStringExtra("email")
            roll = intent.getStringExtra("roll")
            course = intent.getStringExtra("course")
            Teacher = intent.getStringExtra("Teacher")
            TextName!!.setText(name)
            TextID!!.setText(id)
            TextEmail!!.setText(email)
        }
    }


}
