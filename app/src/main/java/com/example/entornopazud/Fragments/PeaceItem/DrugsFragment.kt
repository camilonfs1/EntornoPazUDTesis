package com.example.entornopazud.Fragments.PeaceItem

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
import com.example.entornopazud.Activities.EducationalModulePack.PeaceItem
import com.example.entornopazud.Adapters.Adapter_Intro_Slider
import com.example.entornopazud.Clases.IntroSlide
import com.example.entornopazud.EvaluationActivities.DrugsPeaceEvaluation
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.peace_container.*

class DrugsFragment : AppCompatActivity() {


    private var btnActivity: Button?=null
    private var txtBack: TextView? = null
    private var introSliderAdapter = Adapter_Intro_Slider(
        listOf(
            IntroSlide(
                "Drogas Ilícitas",
                "Solución al problema de las drogas ilícitas ",
                R.drawable.drugs0
            ),
            IntroSlide(
                "Sustitución de cultivos",
                "• Planes integrales de sustitución\n" +
                        "• Programa nacional de sustitución de cultivos de uso ilícito en parques nacionales naturales\n",
                R.drawable.drugs1
            ),
            IntroSlide(
                "Política de salud pública frente al consumo",
                "• Enfoque de derechos y de salud pública para la intervención integral frente al consumo de drogas\n" +
                        "• Planes de acción participativos frente al consumo con enfoque territorial y poblacional \n",
                R.drawable.drugs2
            ),
            IntroSlide(
                "Solución al problema del narcotráfico",
                "• Control sobre la producción importación y comercialización de insumos\n" +
                        "• Estrategia integral de lucha contra la corrupción\n" +
                        "• Judicialización efectiva\n",
                R.drawable.drugs3
            ),
            IntroSlide(
                "Propósitos",
                "• Brindar alternativas con campesinos frente a los cultivos de uso ilícito a través de planes integrales de sustitución y desarrollo alternativos \n" +
                        "• Garantizar un abordaje integral del problema del consumo en torno a una política de promoción en salud, prevención, reducción del daño, atención e inclusión social \n" +
                        "• Intensificar la lucha contra las organizaciones criminales dedicadas al narcotráfico y el lavado de activos. \n" ,
                    R.drawable.drugs4
            ),
            IntroSlide(
                "Problemas a resolver",
                "• Funcionamiento de redes del narcotráfico \n" +
                        "• Presencia de cultivos de uso ilícito \n" +
                        "• Impactos negativos de los cultivos de uso ilícito \n" +
                        "• Consumo de drogas ilícitas \n",
                R.drawable.drugs5
            )

        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.peace_container)
        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        contri.setBackgroundColor(resources.getColor(R.color.Drugs))
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
            var intent = Intent(this, DrugsPeaceEvaluation::class.java)
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
