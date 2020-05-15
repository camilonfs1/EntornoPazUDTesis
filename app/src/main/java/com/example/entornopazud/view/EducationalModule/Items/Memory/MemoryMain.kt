package com.example.entornopazud.view.EducationalModule.Items.Memory

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_memory_main.*

class MemoryMain : AppCompatActivity() {
    private var JustificationCard : CardView?=null
    private var ObjetiveCard : CardView?=null
    private var BananaCard : CardView?=null
    private var April1948Card : CardView?=null
    private var Marquetalia1955Card : CardView?=null
    private var BipartCard : CardView?=null
    private var ActivityCard : CardView?=null

    private var myDialog0: Dialog?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_main)
        JustificationCard = CardJustificationM
        ObjetiveCard = CardObjectiveM
        BananaCard = Card1928
        April1948Card = Card1948
        Marquetalia1955Card = Card1955
        BipartCard = CardBipartisanship
        ActivityCard = CardActivityAllM

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")

        myDialog0 = Dialog(this)

        JustificationCard!!.setOnClickListener {
            showPopUp("La violencia en Colombia es algo que ha estado presente en cada uno de los habitantes del territorio. En algún momento algún familiar, amigo, vecino o cualquier conocido se ha visto afectado por las diferentes formas de violencia que ha acompañado la historia de Colombia.")
        }
        ObjetiveCard!!.setOnClickListener {
            showPopUp("• Acercar a los estudiantes a la importancia de la memoria para poder entender y resolver el fenómeno de la violencia en Colombia.  \n  • Contextualizar el fenómeno de la violencia en la vida de los estudiantes. ")
        }
        BananaCard!!.setOnClickListener {
            var intent = Intent(this, Banana1928::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        April1948Card!!.setOnClickListener {
            var intent = Intent(this, BogotaRevolt::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        Marquetalia1955Card!!.setOnClickListener {
            var intent = Intent(this, BirthFarc::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        BipartCard!!.setOnClickListener {
            var intent = Intent(this, Bipartisanship::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        ActivityCard!!.setOnClickListener {
            //ventana falta
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
