package com.example.entornopazud.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.entornopazud.R

class ContainerEducationalModule : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_educational_module)

        var fragment = intent.getStringExtra("fragment")

        when (fragment) {
            "Agreement" ->{

            }
            "TimeLine" -> {

            }
            "EndConflic" -> {

            }
            "Drugs" -> {

            }
            "Implementation" -> {

            }
            "Participation" -> {

            }
            "Vitims" -> {

            }
            "RuralRefomr" -> {

            }
        }

    }
}
