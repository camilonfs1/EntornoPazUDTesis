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
import com.example.entornopazud.view.EducationalModule.Items.Memory.Banana1928
import kotlinx.android.synthetic.main.activity_peace_main.*

class PeaceMain : AppCompatActivity() {
    private var justifyCard : CardView?=null
    private var objetiveCard: CardView?=null
    private var AgreementCard : CardView?=null
    private var timeLineCard: CardView?=null
    private var threePCard: CardView?=null
    private var PrevencionCard : CardView?=null
    private var activityCard: CardView?=null

    private var myDialog0: Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peace_main)
        justifyCard = CardJustificationP
        objetiveCard = CardObjectiveP
        AgreementCard = CardPeaceAgreement
        timeLineCard = cardTimeLine
        PrevencionCard = CardPrevention
        activityCard = CardActivityAllP

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")

        myDialog0 = Dialog(this)

        justifyCard!!.setOnClickListener {
            showPopUp("Una vez surtido el proceso de paz entre el gobierno Nacional y la guerrilla más antigua del continente latinoamericano, las Farc-Ep, es necesario que las partes se siente y en común acuerdo busquen las salidas más pertinentes para la resolución de conflictos y se pueda llegar a conseguir la paz.")
        }
        objetiveCard!!.setOnClickListener {
            showPopUp("• Acercar a los estudiantes a la importancia de la resolución de conflictos para una sana convivencia.\n • Capacitar a los estudiantes para la resolución de conflictos.\n • Brindar herramientas de análisis para comprender el fenómeno de la violencia en Colombia.\n • Reconocer la importancia del acuerdo de paz entre la guerrilla y el Estado.")
        }
        AgreementCard!!.setOnClickListener {
            var intent = Intent(this, PeaceItem::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        timeLineCard!!.setOnClickListener {
            var intent = Intent(this, TimeLineFra::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        PrevencionCard!!.setOnClickListener {
            var intent = Intent(this, ConflictResolutionItem::class.java)
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            this.startActivity(intent)
        }
        activityCard!!.setOnClickListener {

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
