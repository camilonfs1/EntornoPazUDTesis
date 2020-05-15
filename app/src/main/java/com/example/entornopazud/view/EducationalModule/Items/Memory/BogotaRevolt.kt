package com.example.entornopazud.view.EducationalModule.Items.Memory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.example.entornopazud.R

class BogotaRevolt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")
    }


}