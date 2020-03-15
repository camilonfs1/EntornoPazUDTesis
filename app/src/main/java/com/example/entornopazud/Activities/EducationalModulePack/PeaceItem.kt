package com.example.entornopazud.Activities.EducationalModulePack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.example.entornopazud.Activities.ContainerEducationalModule
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_container_educational_module.*
import kotlinx.android.synthetic.main.main_peace.*

class PeaceItem : AppCompatActivity() {
    private var EncConflic: CardView? = null
    private var Implementation: CardView? = null
    private var PoliticalPar: CardView? = null
    private var RuralReform: CardView? = null
    private var Victims: CardView? = null
    private var TimeLine: CardView? = null
    private var IllegalDrgus: CardView? = null

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



        TimeLine!!.setOnClickListener {
            var intent = Intent(this, ContainerEducationalModule::class.java)
            intent.putExtra("fragment", "TimeLine")
            this.startActivity(intent)
        }
        RuralReform!!.setOnClickListener {
            var intent = Intent(this, ContainerEducationalModule::class.java)
            intent.putExtra("fragment", "RuralReform")
            this.startActivity(intent)
        }
        PoliticalPar!!.setOnClickListener {
            var intent = Intent(this, ContainerEducationalModule::class.java)
            intent.putExtra("fragment", "Participation")
            this.startActivity(intent)
        }
        EncConflic!!.setOnClickListener {
            var intent = Intent(this, ContainerEducationalModule::class.java)
            intent.putExtra("fragment", "EndConflic")
            this.startActivity(intent)
        }
        IllegalDrgus!!.setOnClickListener {
            var intent = Intent(this, ContainerEducationalModule::class.java)
            intent.putExtra("fragment", "Drugs")
            this.startActivity(intent)
        }
        Victims!!.setOnClickListener {
            var intent = Intent(this, ContainerEducationalModule::class.java)
            intent.putExtra("fragment", "Vitims")
            this.startActivity(intent)
        }
        Implementation!!.setOnClickListener {
            var intent = Intent(this, ContainerEducationalModule::class.java)
            intent.putExtra("fragment", "Implementation")
            this.startActivity(intent)
        }






    }

}