package com.example.entornopazud.view.EducationalModule.Items.Peace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.view.EducationalModule.EvaluationActivities.FinalPeaceEvaluation
import com.example.entornopazud.view.EducationalModule.EvaluationActivities.TimeLinePeaceEvaluation
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Reconciliation.*
import kotlinx.android.synthetic.main.main_peace.*

class PeaceItem : AppCompatActivity() {
    private var EncConflic: CardView? = null
    private var Implementation: CardView? = null
    private var PoliticalPar: CardView? = null
    private var RuralReform: CardView? = null
    private var Victims: CardView? = null
    private var TimeLine: CardView? = null
    private var IllegalDrgus: CardView? = null
    private var ActivityLine: CardView?= null
    private var ActivityAll: CardView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_peace)
        EncConflic = cardEndConflict
        Implementation = cardImplementation
        PoliticalPar = cardPoliticalParticipation
        RuralReform = cardRuralReoform
        Victims = cardVictims
        TimeLine = cardTimeLine
        IllegalDrgus= cardIlligalDrugs
        ActivityLine = cardActivityTimeLine
        ActivityAll = activityAll


        TimeLine!!.setOnClickListener {
            var intent = Intent(this, TimeLineFra::class.java)
            this.startActivity(intent)
        }
        RuralReform!!.setOnClickListener {
            var intent = Intent(this, RuralReformFragmet::class.java)
            this.startActivity(intent)
        }
        PoliticalPar!!.setOnClickListener {
            var intent = Intent(this, PoliticalParticipationFragment::class.java)
            this.startActivity(intent)
        }
        EncConflic!!.setOnClickListener {
            var intent = Intent(this, ConflicEndFragment::class.java)
            this.startActivity(intent)
        }
        IllegalDrgus!!.setOnClickListener {
            var intent = Intent(this, DrugsFragment::class.java)
            this.startActivity(intent)

        }
        Victims!!.setOnClickListener {
            var intent = Intent(this, VictimsFragment::class.java)
            this.startActivity(intent)
        }
        Implementation!!.setOnClickListener {
            var intent = Intent(this, ImplementationFragment::class.java)
            this.startActivity(intent)
        }
        ActivityLine!!.setOnClickListener{
            var intent = Intent(this, TimeLinePeaceEvaluation::class.java)
            this.startActivity(intent)
        }
        ActivityAll!!.setOnClickListener {
            var intent = Intent(this, FinalPeaceEvaluation::class.java)
            this.startActivity(intent)
        }
    }

}