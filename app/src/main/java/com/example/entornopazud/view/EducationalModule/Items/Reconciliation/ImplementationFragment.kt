package com.example.entornopazud.view.EducationalModule.Items.Reconciliation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.entornopazud.viewmodel.Adapters.Adapter_Intro_Slider
import com.example.entornopazud.model.models.IntroSlide
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Peace.Activity.ActivityPeace
import com.example.entornopazud.view.EducationalModule.Items.Peace.PeaceItem
import kotlinx.android.synthetic.main.peace_container.*

class ImplementationFragment : AppCompatActivity() {

    private var btnActivity: Button?=null
    private var txtBack: TextView? = null
    private var introSliderAdapter =
        Adapter_Intro_Slider(
            listOf(
                IntroSlide(
                    "Implementación y Verificación ",
                    "Implementación, verificación y refrendación ",
                    R.drawable.implementation0
                ),
                IntroSlide(
                    "Propósitos: ",
                    "• Hacer seguimiento del cumplimiento del acuerdo de paz y garantizar su completa implementación \n " +
                            "• Contar con acompañamiento internacional en el proceso de implementación del acuerdo de paz \n" +
                            "• Garantizar que la sociedad participe y realice veeduría del proceso de implementación del acuerdo de paz \n",
                    R.drawable.implementation1
                ),
                IntroSlide(
                    "Problemas a resolver: ",
                    "• Posibles incumplimientos de la implementación del acuerdo de paz\n " +
                            "• Ausencia del control ciudadano en el proceso de implementación del acuerdo de paz \n" +
                            "• Desviación de recursos o corrupción en la ejecución de fondos para la construcción de paz \n",
                    R.drawable.implementation2
                ),
                IntroSlide(
                    "Componentes: ",
                    "• Mecanismos de implementación y verificación \n\n" +
                            "       o Comisión de seguimiento, impulso y verificación a la implementación del acuerdo de paz \n" +
                            "       o Plan marco de implantación del acuerdo de paz PMI\n" +
                            "       o Sistema integrado de información \n" +
                            "       o Medidas para la transparencia \n " +
                            "       o Prioridades para la implementación\n ",
                    R.drawable.implementation3
                ),
                IntroSlide(
                    "Programas de desarrollo con enfoque territorial",
                    "• Componente internacional de verificación \n" +
                            "• Misión política de verificación de naciones unidas \n" +
                            "• Componente de acompañamiento internacional \n",
                    R.drawable.implementation4
                ),
                IntroSlide(
                    "",
                    "• Difusión y comunicación\n\n" +
                            "       o Emisoras para la convivencia y la reconciliación\n" +
                            "       o Espacio en televisión institucional  \n",
                    R.drawable.implementation5
                ),
                IntroSlide(
                    "",
                    "• Formas de refrendación \n\n" +
                            "       o Mecanismos de participación ciudadana \n" +
                            "       o Corporaciones públicas de elección popular \n",
                    R.drawable.implementation6
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.peace_container)
        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        contri.setBackgroundColor(resources.getColor(R.color.Implementation))
        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        btnActivity = ButtonActivity
        txtBack = txtBackRuralReform

        txtBack!!.setOnClickListener {
            var intent = Intent(this, ReconciliationMain::class.java)
            this.startActivity(intent)
        }
        btnActivity!!.setOnClickListener {
            var intent = Intent(this, ActivityPeace::class.java)
            this.startActivity(intent)
        }


    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorConstrainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val chidCount = indicatorConstrainer.childCount
        for (i in 0 until chidCount) {
            val imageView = indicatorConstrainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
