package com.example.entornopazud.Activities.EducationalModulePack

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.entornopazud.Fragments.ConflictResolution.rutConflicts
import com.example.entornopazud.Fragments.ConflictResolution.solutionConflicts
import com.example.entornopazud.Fragments.ConflictResolution.threeP
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.main_conflicts.*
import kotlinx.android.synthetic.main.pop_up_conflicts_2.*

class ConflictResolutionItem : AppCompatActivity() {

    private var myDialog: Dialog?=null
    private var resourceCard: CardView?=null
    private var ideologyCard: CardView?=null
    private var territoryCard: CardView?=null
    private var personalityCard: CardView?=null
    private var economicCard: CardView?=null
    private var threeCard : CardView?=null
    private var rutCard : CardView?=null
    private var solutionCard : CardView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_conflicts)

        resourceCard = cardResourcesConflict
        ideologyCard = cardIdeologicConflict
        territoryCard =cardTerritoryConflict
        personalityCard = cardPersonalityConflict
        economicCard = cardEconomicalConflict
        threeCard = threePCard
        rutCard = RutCard
        solutionCard = SolutionCard


        myDialog = Dialog(this)


        threeCard?.setOnClickListener {
            showPopUp2(R.drawable.johnpaul,"John Paul Lederach  en su documento “Enredos, pleitos y problemas: una guía práctica para ayudar a resolver los conflictos “propone una herramienta de análisis de los conflictos que busca una solución orienta da a la construcción de paz. ", "threeP")
        }
        rutCard?.setOnClickListener {
            showPopUp2(R.drawable.rutconflict,"Algunas sugerencias para encaminar un conflicto a una solución pacifica ", "rut")
        }
        solutionCard?.setOnClickListener {
            showPopUp2(R.drawable.solutionconflicts,"No esperes a que las cosas esten mas dificiles, para llegar a una resolucion pacifica del conflicto", "solution")
        }

        resourceCard?.setOnClickListener {
            showPopUp(R.drawable.resolution1,"El petróleo jugó un papel vital en el golpe de Estado organizado en Irán en 1953 con el auspicio de Estados Unidos y Reino Unido.")
        }
        ideologyCard?.setOnClickListener {
            showPopUp(R.drawable.resolution2,"La Guerra Fría fue un enfrentamiento político e ideológico que se desarrolló entre los años 1945 y 1947, luego de la Segunda Guerra Mundial, en el cual los Estados Unidos y la Unión Soviética se enfrentaron por la hegemonía política y económica del mundo.")
        }
        territoryCard?.setOnClickListener {
            showPopUp(R.drawable.resolution3,"El conflicto israelí-palestino por territorio es un conflicto social y armado en curso entre israelíes y palestinos que se remonta a principios del siglo XX ")
        }
        personalityCard?.setOnClickListener {
            showPopUp(R.drawable.resolution4,"“Los mayores conflictos no son entre dos personas, sino entre una persona y sí misma.” Garth Brooks")
        }
        economicCard?.setOnClickListener {
            showPopUp(R.drawable.resolution5,"La violencia económica es toda acción efectuada por un individuo que afecta la supervivencia económica de otro. Se presenta a través de limitaciones, orientadas a controlar el ingreso obtenido")
        }
    }
    private fun showPopUp(imag1: Int, text1: String ){
        myDialog!!.setContentView(R.layout.pop_up_conflicts)
        var close: TextView = myDialog!!.findViewById(R.id.txtClose)
        var text: TextView = myDialog!!.findViewById(R.id.textpop)
        var imag: ImageView = myDialog!!.findViewById(R.id.imagepop)

        text.setText(text1)
        imag.setImageResource(imag1)

        close.setOnClickListener {
            myDialog!!.dismiss()
        }
        myDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog!!.show()
    }
    private fun showPopUp2(imag1: Int, text1: String, rut: String){
        myDialog!!.setContentView(R.layout.pop_up_conflicts_2)
        var close: TextView = myDialog!!.findViewById(R.id.txtClose)
        var text: TextView = myDialog!!.findViewById(R.id.textpop)
        var imag: ImageView = myDialog!!.findViewById(R.id.imagepop)
        var btn: Button = myDialog!!.findViewById(R.id.buttonNext)
        text.setText(text1)
        imag.setImageResource(imag1)
        btn!!.setOnClickListener {
            when (rut){
                "threeP"->
                    this.startActivity(Intent(this, threeP::class.java))
                "rut"->
                    this.startActivity(Intent(this, rutConflicts::class.java))
                "solution"->
                    this.startActivity(Intent(this, solutionConflicts::class.java))
            }
        }
        close.setOnClickListener {
            myDialog!!.dismiss()
        }
        myDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog!!.show()
    }
}
