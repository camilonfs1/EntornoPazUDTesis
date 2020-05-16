package com.example.entornopazud.view.EducationalModule.Items.Peace

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Peace.Activity.ActivityPeace
import kotlinx.android.synthetic.main.activity_three_p.*

class threeP : AppCompatActivity() {

    private var cardPersons: CardView? = null
    private var cardProcess: CardView? = null
    private var cardProblem: CardView? = null
    private var cardActivity: CardView? = null

    private var myDialog0: Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_p)

        cardPersons = cardPerson
        cardProcess = cardProces
        cardProblem = cardProblems
        cardActivity = cardActivityThreeP


        myDialog0 = Dialog(this)

        cardPersons?.setOnClickListener {
            showPopUp("Es importante tener en cuenta, sus emociones y sentimientos, la necesidad humana de dar explicaciones, de justificarse, desahogarse de ser respetados y de mantener la dignidad las percepciones del problema y la forma en que lo sucedido afecta a las personas.")
        }
        cardProcess?.setOnClickListener {
            showPopUp(" El proceso que el conflicto haya seguido hasta el momento, la necesidad de un proceso que parezca justo a todas las partes involucradas, la comunidad y el lenguaje con que se expresan y lo que hace falta por establecer un diálogo constructivo")
        }
        cardProblem?.setOnClickListener {
            showPopUp("Los intereses y necesidades de cada uno las diferencias y valores esenciales que los separan y las diferencias de cada uno en cuanto al proceso a seguir. ")
        }
        cardActivity?.setOnClickListener {
            this.startActivity(Intent(this, ActivityPeace::class.java))
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
