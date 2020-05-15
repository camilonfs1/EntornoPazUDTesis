package com.example.entornopazud.view.EducationalModule.Items.Peace

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.entornopazud.view.EducationalModule.EvaluationActivities.Myth_main_Evaluation
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.main_myth.*

class MythsItem : AppCompatActivity() {

    private var card1: CardView? = null
    private var card2: CardView? = null
    private var card3: CardView? = null
    private var card4: CardView? = null
    private var card5: CardView? = null

    private var cardActivity: CardView? = null

    private var myDialog: Dialog?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_myth)
        myDialog = Dialog(this)

        card1 = Card1
        card2 = Card2
        card3 = Card3
        card4 = Card4
        card5 = Card5

        cardActivity = CardActivityMith

        card1?.setOnClickListener {
            showPopUp("Los niños y las niñas juegan y es normal que se molesten los unos a los otros, sin embargo, el acoso escolar es algo más, se trata de hacer daño continuo (físico o psicológico) ")
        }
        card2?.setOnClickListener {
            showPopUp("Algunos niños o niñas pueden volverse blanco de este tipo de acoso por ser condenados diferentes en cualquier aspecto o por no tener las habilidades sociales necesarias.")
        }
        card3?.setOnClickListener {
            showPopUp("Tanto niños como niñas pueden fungir como agresores en una situación de acoso escolar. En cuanto a los docentes y adultos de la institución escolar también pueden ser agresores y es ahí un problema mayor.")
        }
        card4?.setOnClickListener {
            showPopUp("Si las personas creen que es normal ser insultadas, empujadas, golpeadas, amenazadas o ignoradas disminuye la posibilidad de que intervengan cuando un tercero es víctima de ello.")
        }
        card5?.setOnClickListener {
            showPopUp("El acoso escolar tiene consecuencias a corto y largo plazo, la autoestima, el rendimiento escolar y trastornos emocionales.")
        }

        cardActivity?.setOnClickListener {
            this.startActivity(Intent(this, Myth_main_Evaluation::class.java))
        }
    }

    private fun showPopUp( text1: String ){
        myDialog!!.setContentView(R.layout.popupthreep)
        var close: TextView = myDialog!!.findViewById(R.id.txtClose)
        var text: TextView = myDialog!!.findViewById(R.id.text)

        text.setText(text1)

        close.setOnClickListener {
            myDialog!!.dismiss()
        }
        myDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog!!.show()
    }
}
