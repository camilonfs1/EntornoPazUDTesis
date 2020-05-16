package com.example.entornopazud.view.EducationalModule.Items.Reconciliation

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Reconciliation.Activity.ActivityReconciliation
import kotlinx.android.synthetic.main.activity_reconciliation_main.*
import kotlinx.android.synthetic.main.activity_reconciliation_main.cardEndConflict
import kotlinx.android.synthetic.main.activity_reconciliation_main.cardIlligalDrugs
import kotlinx.android.synthetic.main.activity_reconciliation_main.cardPoliticalParticipation
import kotlinx.android.synthetic.main.activity_reconciliation_main.cardRuralReoform

class ReconciliationMain : AppCompatActivity() {

    private var JustifyCard : CardView?=null
    private var OjevtiveCard : CardView?=null
    private var RuralCard : CardView?=null
    private var PoliticalCard : CardView?=null
    private var EndconclictCard : CardView?=null
    private var DrugsCard : CardView?=null
    private var VictimsCard : CardView?=null
    private var ImplementationCard : CardView?=null
    private var ActivityAllCard : CardView?=null

    private var myDialog0: Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reconciliation_main)

        JustifyCard = CardJustificationR
        OjevtiveCard = CardObjectiveR
        RuralCard = cardRuralReoform
        PoliticalCard = cardPoliticalParticipation
        EndconclictCard = cardEndConflict
        DrugsCard = cardIlligalDrugs
        VictimsCard = cardVictimsR
        ImplementationCard = cardImplementationR
        ActivityAllCard = activityAllR



        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")

        myDialog0 = Dialog(this)

        JustifyCard!!.setOnClickListener {
            showPopUp("Lo que genero un día la guerra, la violencia, la desigualdad social y entendimos en el proceso de memoria, ahora debe ser reparado para reconciliarnos como sociedad")
        }
        OjevtiveCard!!.setOnClickListener {
            showPopUp("• Exponer los puntos del acuerdo de paz de 2016, en los que se tocan temáticas que buscan la reconciliación con los sectores de la sociedad que más han sufrido. \n• Acercar a los estudiantes a la importancia de la reconciliación como un medio para reconstruir el tejido social.")
        }
        RuralCard!!.setOnClickListener {
            var intent = Intent(this, RuralReformFragmet::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        PoliticalCard!!.setOnClickListener {
            var intent = Intent(this, PoliticalParticipationFragment::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        EndconclictCard!!.setOnClickListener {
            var intent = Intent(this, ConflicEndFragment::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        DrugsCard!!.setOnClickListener {
            var intent = Intent(this, DrugsFragment::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        VictimsCard!!.setOnClickListener {
            var intent = Intent(this, VictimsFragment::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        ImplementationCard!!.setOnClickListener {
            var intent = Intent(this, ImplementationFragment::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        ActivityAllCard!!.setOnClickListener {
            var intent = Intent(this, ActivityReconciliation::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
    }
    private fun showPopUp( text1: String ){
        myDialog0!!.setContentView(R.layout.popupthreep)
        var close: TextView = myDialog0!!.findViewById(R.id.txtClose)
        var text: TextView = myDialog0!!.findViewById(R.id.text)

        text.setText(text1)

        close.setOnClickListener {
            myDialog0!!.dismiss()
        }
        myDialog0!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog0!!.show()
    }
}
