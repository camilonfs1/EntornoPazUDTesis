package com.example.entornopazud.view.General_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.R
import com.example.entornopazud.model.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_own_profile.*

class ownProfile : AppCompatActivity() {
    private var name: TextView? = null
    private var id: TextView? = null
    private var email: TextView? = null
    private var btUpdate: Button? = null
    private var pass: EditText? = null
    private var passConfirm: EditText? = null
    private var key: String? = null


    private lateinit var auth: FirebaseAuth
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_own_profile)
        name = txtNameProfile
        id = txtIdProfile
        email = txtEmailProfile
        btUpdate = BtnUpdate
        auth = FirebaseAuth.getInstance()
        pass = txtPassProfile
        passConfirm = txtPassConfirmProfile

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference

        val currentUser = auth.currentUser
        read(currentUser)
        btUpdate!!.setOnClickListener {
            if(pass!!.text.isEmpty() && passConfirm!!.text.isEmpty()){
                key(currentUser,false)
            }else{
                key(currentUser,true)
            }

        }
    }

    private fun key(currentuser: FirebaseUser?, passCheck: Boolean) {
        var emailSent = currentuser!!.email.toString()
        mDatabaseReference = mDatabase!!.reference.child("Users").child("Teachers")
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                for (e in p0.children) {
                    var emailSave = e.child("Email").value.toString()
                    var n = name!!.text.toString()
                    var i = id!!.text.toString()
                    var em = email!!.text.toString()
                    key = e.key
                    if (emailSave == emailSent) {
                        var user = User(key.toString(),n,em,i,"","")
                        update(currentuser,user,passCheck)
                    }
                }
            }
        })
    }

    private fun update(currentuser: FirebaseUser?, user: User,passCheck: Boolean) {
        if(passCheck){
            if(pass!!.text.toString().equals(passConfirm!!.text.toString())){
                val currentUser =  mDatabase!!.reference.child("Users").child("Teachers")!!.child(user.key)
                val map = mutableMapOf<String, Any?>()
                map.put("Name", user.name)
                map.put("Id", user.id)
                map.put("Email", user.email)
                map.put("Roll", "Teacher")
                currentUser.updateChildren(map)
                currentuser?.updateEmail(user.email)
                    ?.addOnCompleteListener { task ->
                        Toast.makeText(this, "actualizado 1", Toast.LENGTH_LONG).show()
                        currentuser?.updatePassword(pass!!.text.toString())
                            ?.addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(this, "actualizado", Toast.LENGTH_LONG).show()
                                    pass!!.setText("")
                                    passConfirm!!.setText("")
                                }else{
                                    Toast.makeText(this, "no actualizado", Toast.LENGTH_LONG).show()
                                }
                            }
                    }
            }else{
                Toast.makeText(this,"Verifica la clave ingresada!!!",Toast.LENGTH_LONG).show()
            }
        }else{
            val currentUser =  mDatabase!!.reference.child("Users").child("Teachers")!!.child(user.key)
            val map = mutableMapOf<String, Any?>()
            map.put("Name", user.name)
            map.put("Id", user.id)
            map.put("Email", user.email)
            map.put("Roll", "Teacher")
            currentUser.updateChildren(map)
            currentuser?.updateEmail(user.email)
                ?.addOnCompleteListener { task ->
                    Toast.makeText(this,"actualizado",Toast.LENGTH_LONG).show()
                }
        }
    }


    private fun read(user: FirebaseUser?) {
        var emailSent = user!!.email.toString()
        mDatabaseReference = mDatabase!!.reference.child("Users").child("Teachers")
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                for (e in p0.children) {
                    var emailSave = e.child("Email").value.toString()
                    var nombreSave = e.child("Name").value.toString()
                    var idSave = e.child("Id").value.toString()
                    key = e.key
                    if (emailSave == emailSent) {
                        name!!.setText(nombreSave)
                        id!!.setText(idSave)
                        email!!.setText(emailSave)
                    }

                }
            }
        })
    }
}


