package com.example.entornopazud.view.EducationalModule.Items.Reconciliation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
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
import kotlinx.android.synthetic.main.peace_container.*

class RuralReformFragmet : AppCompatActivity() {

    private var btnActivity: Button?=null
    private var txtBack: TextView? = null
    private var introSliderAdapter =
        Adapter_Intro_Slider(
            listOf(
                IntroSlide(
                    "Reforma Rural",
                    "'Hacia un Nuevo Campo Colombiano'",
                    R.drawable.rural0
                ),
                IntroSlide(
                    "Propósitos",
                    "• Lograr la democratización del acceso a la tierra en beneficio de las comunidades rurales más afectadas por la pobreza, el abandono estatal y le conflicto.\n" +
                            "• Proteger las reservas ambientales del país\n",
                    R.drawable.rural_reform_1
                ),
                IntroSlide(
                    "Acceso de la tierra",
                    "• Fondo de tierra: 3 millones de hectáreas gratuitas para campesinos sin tierra\n" +
                            "• Subsidios y créditos a campesinos para el acceso a tierras.\n" +
                            "• Fortalecimiento de las zonas de reserva campesina\n" +
                            "• Formación y actualización del catastro e impuesto predial rural\n" +
                            "• Participación ciudadana en el ordenamiento territorial local.\n",
                    R.drawable.rural_reform_4
                ),
                IntroSlide(
                    "Programas de desarrollo con enfoque territorial",
                    "• Lograr la trasformación estructural del campo y el ámbito rural con un relacionamiento equitativo entre el campo y la cuidad de manera que asegure\n" +
                            "• Bienestar y buen vivir de la población rural.\n" +
                            "• La protección de la riqueza pluri étnica multiculturale\n",
                    R.drawable.rural_reform_5
                ),
                IntroSlide(
                    "",
                    "• Desarrollo de la economía campesina y familiar\n" +
                            "• Desarrollo y la integración de las regiones abandonadas y golpeadas por el conflicto. \n" +
                            "• El reconocimiento y la promoción de las organizaciones de las comunidades incluyendo a las organizaciones de mujeres rurales, para que sean ellas las principales precursoras de la transformación del campo.\n" +
                            "• Hacer del campo colombiano un escenario de reconciliación.\n",
                    R.drawable.rural_reform_3
                ),
                IntroSlide(
                    "Planes nacionales para la reforma rural integral\n",
                    "Sus objetivos son superar la pobreza y la desigualdad para alcanzar el bienestar de la población rural. La integración y el cierre de la brecha entre el campo y la cuidad.\n",
                    R.drawable.rural_reform_8
                ),
                IntroSlide(
                    "Infraestructura\n",
                    "• Vías terciarias \n" +
                            "• Riego y drenaje\n" +
                            "• Electrificación rural\n" +
                            "• Conectividad rural\n",
                    R.drawable.rural_reform_6
                ),
                IntroSlide(
                    "Desarrollo social\n",
                    "• Salud\n" +
                            "• La protección de la riqueza pluri étnica multiculturales\n" +
                            "• Educación rura\n" +
                            "• Construcción y mejoramiento de vivienda rural\n",
                    R.drawable.rural_reform_7
                ),
                IntroSlide(
                    "Estímulos a la economía campesina",
                    "• Fomento a la economía campesina\n" +
                            "• Asistencia técnica y tecnológica para el campo\n" +
                            "• Subsidios\n" +
                            "• Protección social y derechos laborales \n" +
                            "• Garantía progresiva del derecho a la alimentación\n",
                    R.drawable.rural_reform_9
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.peace_container)
        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        contri.setBackgroundColor(resources.getColor(R.color.Rural))
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
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
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
