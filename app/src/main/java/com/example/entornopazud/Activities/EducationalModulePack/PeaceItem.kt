package com.example.entornopazud.Activities.EducationalModulePack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_container_educational_module.*
import kotlinx.android.synthetic.main.main_peace.*

class PeaceItem : AppCompatActivity() {
    private var primer: CardView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_peace)
        primer = cardAgreement

        primer!!.setOnClickListener {
            println("HOlaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        }

    }

}