package com.example.entornopazud.view.EducationalModule.Items.Peace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Peace.Activity.ActivityPeace
import kotlinx.android.synthetic.main.activity_rut_conflicts.*

class rutConflicts : AppCompatActivity() {

    private var cardEvaluation: CardView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rut_conflicts)

        cardEvaluation = cardEvaluationRut

        cardEvaluation?.setOnClickListener {
            this.startActivity(Intent(this, ActivityPeace::class.java))
        }
    }
}
