package com.example.entornopazud.view.EducationalModule.Items.Reconciliation.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Peace.Activity.Activity_entry_Peace
import kotlinx.android.synthetic.main.activity_reconciliation.*

class ActivityReconciliation : AppCompatActivity() {
    private var card1: CardView? = null
    private var card2: CardView? = null
    private var card3: CardView? = null
    private var card4: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reconciliation)
        card1 = card1Reconciliation
        card2 = card2Reconciliation
        card3 = card3Reconciliation
        card4 = card4Reconciliation

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")


        card1!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Reconcilitation::class.java)
            intent.putExtra("activity", "Nombre: ¡A recuperar el campo colombiano!  \n" +
                    "Objetivo: El conflicto armado también atraviesa nuestro campo colombiano, por ello es tan importante la educación ambiental, que invite al aprendiente y a su entorno a recuperar, cuidar y preservar el campo. \n" +
                    "Desarrollo: El grupo deberá buscar la zona verde más cercana e iniciar la recuperación de esta haciendo limpieza, luego de esto la reflexión deberá ser colectiva, con los elementos de reconocer las zonas verdes como portadoras de vida, de habitad y alimento para la sociedad.\n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Reconciliacion 1")
            this.startActivity(intent)

        }
        card2!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Reconcilitation::class.java)
            intent.putExtra("activity", "\n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Reconciliacion 2")
            this.startActivity(intent)
        }
        card3!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Reconcilitation::class.java)
            intent.putExtra("activity", " \n ")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Reconciliacion 3")
            this.startActivity(intent)

        }
        card4!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Reconcilitation::class.java)
            intent.putExtra("activity", "\n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Reconciliacion 4")
            this.startActivity(intent)
        }
    }
}
