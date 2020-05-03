package com.example.entornopazud.view.Fragments.BullyingItem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.view.EvaluationActivities.Bullying_talk_evaluation1
import com.example.entornopazud.view.EvaluationActivities.Bullying_talk_evaluation2
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_talkand_listen.*

class TalkandListen : AppCompatActivity() {

    private var cardActivity1: CardView?=null
    private var cardActivity2: CardView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talkand_listen)

        cardActivity1 = cardBullying1
        cardActivity2 = cardBullying2

        cardActivity1?.setOnClickListener {
            this.startActivity(Intent(this, Bullying_talk_evaluation1::class.java))
        }
        cardActivity2?.setOnClickListener {
            this.startActivity(Intent(this, Bullying_talk_evaluation2::class.java))
        }
    }
}
