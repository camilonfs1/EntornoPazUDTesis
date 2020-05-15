package com.example.entornopazud.view.EducationalModule.Items.Memory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entornopazud.R

class Banana1928 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banana1928)

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")

    }
}
