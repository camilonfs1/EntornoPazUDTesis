package com.example.entornopazud.Fragments.BullyingItem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.EvaluationActivities.Bullying_how_evaluation1
import com.example.entornopazud.EvaluationActivities.Bullying_how_evaluation2
import com.example.entornopazud.EvaluationActivities.bullying_main_evaluation
import com.example.entornopazud.R
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
            this.startActivity(Intent(this, Bullying_how_evaluation1::class.java))
        }
        cardActivity2?.setOnClickListener {
            this.startActivity(Intent(this, Bullying_how_evaluation2::class.java))
        }
    }
}
