package com.example.entornopazud.view.EducationalModulePack

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.entornopazud.view.EducationalModulePack.Items.ConflictResolutionItem.rutConflicts
import com.example.entornopazud.view.EducationalModulePack.Items.ConflictResolutionItem.solutionConflicts
import com.example.entornopazud.view.EducationalModulePack.Items.ConflictResolutionItem.threeP
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.main_conflicts.*

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
            showPopUp2(R.drawable.johnpaul,resources.getString(R.string.Item1), "threeP")
        }
        rutCard?.setOnClickListener {
            showPopUp2(R.drawable.rutconflict,resources.getString(R.string.Item2), "rut")
        }
        solutionCard?.setOnClickListener {
            showPopUp2(R.drawable.solutionconflicts,resources.getString(R.string.Item3), "solution")
        }
        resourceCard?.setOnClickListener {
            showPopUp(R.drawable.resolution1,resources.getString(R.string.Item4))
        }
        ideologyCard?.setOnClickListener {
            showPopUp(R.drawable.resolution2, resources.getString(R.string.Item5))
        }
        territoryCard?.setOnClickListener {
            showPopUp(R.drawable.resolution3,resources.getString(R.string.Item6))
        }
        personalityCard?.setOnClickListener {
            showPopUp(R.drawable.resolution4,resources.getString(R.string.Item7))
        }
        economicCard?.setOnClickListener {
            showPopUp(R.drawable.resolution5,resources.getString(R.string.Item8))
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
        btn.setOnClickListener {
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
