package com.example.entornopazud.view.EducationalModule.Items.Peace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.view.EducationalModule.EvaluationActivities.bullying_main_evaluation
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.main_bullyng.*

class BullyngItem : AppCompatActivity() {

    private var activityMainCard : CardView?= null
    private var talkListenCard : CardView?= null
    private var howtoCard : CardView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_bullyng)

        activityMainCard = cardActivityBullyng
        talkListenCard = CardtalknListen
        howtoCard = cardHowto

        activityMainCard?.setOnClickListener {
            this.startActivity(Intent(this, bullying_main_evaluation::class.java))
        }
        talkListenCard?.setOnClickListener {
            this.startActivity(Intent(this, TalkandListen::class.java))
        }
        howtoCard?.setOnClickListener {
            this.startActivity(Intent(this, HowToSolution::class.java))
        }
    }
}


