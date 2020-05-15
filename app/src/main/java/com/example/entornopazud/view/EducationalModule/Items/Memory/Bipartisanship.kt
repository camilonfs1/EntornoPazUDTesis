package com.example.entornopazud.view.EducationalModule.Items.Memory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entornopazud.R

class Bipartisanship : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bipartisanship)

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")
    }
}
