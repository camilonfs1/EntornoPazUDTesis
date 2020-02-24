package com.example.entornopazud.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_crudstuden_indivitual.*
import kotlinx.android.synthetic.main.recycler_row.*
import kotlinx.android.synthetic.main.recycler_row.txtEmail
import kotlinx.android.synthetic.main.recycler_row.txtName
import kotlinx.android.synthetic.main.recycler_row.txtRoll

class CRUDStudenIndivitual : AppCompatActivity() {

    private var TextName: TextView? =null
    private var TextID: TextView? =null
    private var TextEmail: TextView? =null
    private var TextRoll: TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crudstuden_indivitual)
        TextName = txtName
        TextID = txtIdd
        TextEmail = txtEmail
        TextRoll = txtRoll

        getIncomingIntent()
    }
    fun getIncomingIntent(){
        if(intent.hasExtra("name") && intent.hasExtra("id") &&  intent.hasExtra("email")&&  intent.hasExtra("roll")){
            var name = intent.getStringExtra("name")
            var id = intent.getStringExtra("id")
            var roll = intent.getStringExtra("roll")
            var email = intent.getStringExtra("email")
            TextName!!.setText(name)
            TextID!!.setText(id)
            TextEmail!!.setText(roll)
            TextRoll!!.setText(email)
        }
    }
}
