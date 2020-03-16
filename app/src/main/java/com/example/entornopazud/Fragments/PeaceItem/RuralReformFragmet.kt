package com.example.entornopazud.Fragments.PeaceItem

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
import com.example.entornopazud.Activities.EducationalModulePack.PeaceItem
import com.example.entornopazud.Adapters.Adapter_Intro_Slider
import com.example.entornopazud.Clases.IntroSlide
import com.example.entornopazud.R
import com.example.entornopazud.evaluationActivities.RuralReform
import kotlinx.android.synthetic.main.fragmet_rural_reform.*
import kotlinx.android.synthetic.main.slide_item.*

class RuralReformFragmet : AppCompatActivity() {

    private var btnActivity: Button?=null
    private var txtBack: TextView? = null
    private var introSliderAdapter = Adapter_Intro_Slider(
        listOf(
            IntroSlide(
                "Propósitos",
                "", R.drawable.ruralreform0
            ),
            IntroSlide(
                "",
                "Lograr la democratización del acceso a la tierra en beneficio de las comunidades " +
                        "rurales más afectadas por la pobreza, el abandono estatal y le conflicto.\n",
                R.drawable.rural_reform_1
            ),
            IntroSlide(
                "",
                "Proteger las reservas ambientales del país\n",
                R.drawable.rural_reform_2
            ),
            IntroSlide(
                "Acceso de la tierra",
                "- Fondo de tierra: 3 millones de hectáreas gratuitas para campesinos sin tierra\n" +
                        "- Subsidios y créditos a campesinos para el acceso a tierras.\n" +
                        "- Fortalecimiento de las zonas de reserva campesina\n" +
                        "- Formación y actualización del catastro e impuesto predial rural\n" +
                        "- Participación ciudadana en el ordenamiento territorial local.\n",
                R.drawable.rural_reform_4
            ),
            IntroSlide(
                "Programas de desarrollo con enfoque territorial",
                "Lograr la trasformación estructural " +
                        "del campo y el ámbito rural con un relacionamiento equitativo entre el campo y la " +
                        "cuidad de manera que asegure\n",
                R.drawable.rural_reform_5
            ),
            IntroSlide(
                "",
                "- Bienestar y buen vivir de la población rural.\n" +
                        "- La protección de la riqueza pluri étnica multiculturales\n" +
                        "- Desarrollo de la economía campesina y familiar\n" +
                        "- Desarrollo y la integración de las regiones abandonadas y golpeadas por el conflicto. \n" +
                        "- Hacer del campo colombiano un escenario de reconciliación.\n",
                R.drawable.rural_reform_3
            ),
            IntroSlide(
                "Planes nacionales para la reforma rural integral",
                "Sus objetivos son superar la pobreza y la desigualdad para alcanzar el bienestar de la población rural \n",
                R.drawable.rural_reform_8
            ),
            IntroSlide(
                "Infraestructura",
                "- Vías terciarias \n" +
                        "- Riego y drenaje\n" +
                        "- Electrificación rural\n" +
                        "- Conectividad rural\n",
                R.drawable.rural_reform_6
            ),
            IntroSlide(
                "Desarrollo social",
                "- Salud\n" +
                        "- La protección de la riqueza pluri étnica multiculturales\n" +
                        "- Educación rura\n" +
                        "- Construcción y mejoramiento de vivienda rural\n",
                R.drawable.rural_reform_7
            ),
            IntroSlide(
                "Estímulos a la economía campesina",
                "- Fomento a la economía campesina\n" +
                        "- Asistencia técnica y tecnológica para el campo\n" +
                        "- Subsidios\n" +
                        "- Protección social y derechos laborales \n" +
                        "- Garantía progresiva del derecho a la alimentación\n",
                R.drawable.rural_reform_9
            )

        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmet_rural_reform)
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

        txtBack!!.setOnClickListener {
            var intent = Intent(this, PeaceItem::class.java)
            this.startActivity(intent)
        }
        btnActivity!!.setOnClickListener {
            var intent = Intent(this, RuralReform::class.java)
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
