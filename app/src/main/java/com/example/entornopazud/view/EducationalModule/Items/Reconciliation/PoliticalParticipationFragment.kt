package com.example.entornopazud.view.EducationalModule.Items.Reconciliation

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.entornopazud.viewmodel.Adapters.Adapter_Intro_Slider
import com.example.entornopazud.model.models.IntroSlide
import com.example.entornopazud.view.EducationalModule.EvaluationActivities.PoliticalPeaceEvaluation
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModule.Items.Peace.PeaceItem
import kotlinx.android.synthetic.main.peace_container.*


class PoliticalParticipationFragment : AppCompatActivity() {
    private var btnActivity: Button? = null
    private var txtBack: TextView? = null
    private var introSliderAdapter =
        Adapter_Intro_Slider(
            listOf(
                IntroSlide(
                    "Participacion Politica",
                    "Apertura democratica para construir paz",
                    R.drawable.political0
                ),
                IntroSlide(
                    "Apertura democrática para construir paz",
                    "• Aportar a la ampliación y profundización de la democracia colombiana \n" +
                            "• Garantizar la prescripción de la violencia como método de acción política \n" +
                            "• Promover la convivencia, la tolerancia y la no estigmatización como principios democráticos de la sociedad \n" +
                            "• Garantizar la participación ciudadana en instancias de planeación territorial y construcción de políticas publicas \n",
                    R.drawable.political1
                ),
                IntroSlide(
                    "Problemas que busca resolver:",
                    "• Persecución, estigmatización y exterminio de oposición política\n" +
                            "• Sistema político, excluyente y bipartidista\n" +
                            "• Baja participación política de las mujeres \n" +
                            "• Exclusión de representación de las minorías \n" +
                            "• Competencia electoral desequilibrada \n",
                    R.drawable.political2
                ),
                IntroSlide(
                    "Componentes: ",
                    "• Garantías para la oposición política:\n" +
                            "     -> Estatuto de garantías para el ejercicio de la oposición política  \n" +
                            "     -> Garantías de seguridad para el ejercicio de la oposición política \n",
                    R.drawable.political3
                ),
                IntroSlide(
                    "",
                    "• Participación ciudadana\n " +
                            "     -> Pluralismo político: Creación de nuevos partidos y movimientos políticos \n" +
                            "     -> Participación ciudadana en medios de comunicación comunitarios, institucionales y regionales \n",
                    R.drawable.political4
                ),
                IntroSlide(
                    "",
                    "• Participación electoral\n" +
                            "     -> Garantías para la movilización y la protesta \n" +
                            "     -> Reforma de régimen y organización electoral \n" +
                            "     -> Transparencia en los procesos electorales y en la asignación de pauta oficial \n" +
                            "     -> Promoción de la representación política de la mujer \n",
                    R.drawable.political5
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.peace_container)
        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        btnActivity = ButtonActivity
        txtBack = txtBackRuralReform

        contri.setBackgroundColor(resources.getColor(R.color.political))

        txtBack!!.setOnClickListener {
            var intent = Intent(this, ReconciliationMain::class.java)
            this.startActivity(intent)
        }
        btnActivity!!.setOnClickListener {
            var intent = Intent(this, PoliticalPeaceEvaluation::class.java)
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
