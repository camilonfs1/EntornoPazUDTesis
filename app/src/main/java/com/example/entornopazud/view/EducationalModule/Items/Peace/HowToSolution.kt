package com.example.entornopazud.view.EducationalModule.Items.Peace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Peace.Activity.ActivityPeace
import kotlinx.android.synthetic.main.activity_how_to_solution.*

class HowToSolution : AppCompatActivity() {

    private var cardActivity1: CardView?=null
    private var cardActivity2: CardView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_solution)

        cardActivity1 = cardhowto1
        cardActivity2 = cardhowto2

        cardActivity1?.setOnClickListener {
            this.startActivity(Intent(this, ActivityPeace::class.java))
        }
        cardActivity2?.setOnClickListener {
            this.startActivity(Intent(this, ActivityPeace::class.java))
        }
    }
}
