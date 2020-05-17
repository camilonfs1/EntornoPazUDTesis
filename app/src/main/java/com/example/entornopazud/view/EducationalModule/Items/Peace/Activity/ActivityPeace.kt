package com.example.entornopazud.view.EducationalModule.Items.Peace.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Memory.Activity.Activity_entry_Memory
import kotlinx.android.synthetic.main.activity_peace.*

class ActivityPeace : AppCompatActivity() {
    private var card1: CardView? = null
    private var card2: CardView? = null
    private var card3: CardView? = null
    private var card4: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peace)

        card1 = Card1Peace
        card2 = Card2Peace
        card3 = Card3Peace
        card4 = Card4Peace

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")


        card1!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Peace::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Paz 2")
            this.startActivity(intent)

        }
        card2!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Peace::class.java)
            intent.putExtra("activity", "Realice una entrevista a un historiador, un docente, un familiar sobre el fenómeno de la violencia. Haga un cuadro comparativo donde pueda ubicar las diferentes miradas de la violencia en Colombia. En el cuadro podría ubicar los siguientes ítems: Contexto histórico; Diferencias; Similitudes. \n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Paz 2")
            this.startActivity(intent)
        }
        card3!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Peace::class.java)
            intent.putExtra("activity", "Realice una entrevista a un historiador, un docente, un familiar sobre el fenómeno de la violencia. Haga un cuadro comparativo donde pueda ubicar las diferentes miradas de la violencia en Colombia. En el cuadro podría ubicar los siguientes ítems: Contexto histórico; Diferencias; Similitudes. \n ")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Paz 3")
            this.startActivity(intent)

        }
        card4!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Peace::class.java)
            intent.putExtra("activity", "Objetivo: Acercamiento a las problemáticas y conceptos por medio del dialogo como pilar fundamental en el reconocimiento y resolución de los mismos. \n" +
                    "Desarrollo: Identificación de los conflictos en el territorio, busca la realidad de los sucesos e identifica en que contexto en el que se desarrolla. Realiza una actividad de dialogo o conversatorio con compañeros y compañeras del grupo. \n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Paz 4")
            this.startActivity(intent)
        }

    }
}
