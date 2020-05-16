package com.example.entornopazud.view.EducationalModule.Items.Memory.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.entornopazud.R
import com.example.entornopazud.viewmodel.EvaluationViewModel
import com.example.entornopazud.viewmodel.FirebaseViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_entry.*

class Activity_entry_Memory : AppCompatActivity() {
    private var txtDescription: TextView? = null
    private var btnEnter: Button? = null
    private var textRefection: EditText? = null

    private val AuthControl = EvaluationViewModel()

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

        btnEnter!!.setOnClickListener {
            if (roll == ("student")!!) {
                if (!textRefection!!.text.isEmpty()) {
                    AuthControl.register(key, activityName, name, textRefection!!.text.toString(), this)
                    textRefection!!.setText("")
                } else {
                    Toast.makeText(this, "Llena la casilla nombre", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Solo Estudiantes", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
