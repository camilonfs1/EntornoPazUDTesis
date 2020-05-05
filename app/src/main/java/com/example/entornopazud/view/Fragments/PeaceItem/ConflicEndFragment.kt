package com.example.entornopazud.view.Fragments.PeaceItem


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
import com.example.entornopazud.view.EducationalModulePack.PeaceItem
import com.example.entornopazud.viewmodel.Adapters.Adapter_Intro_Slider
import com.example.entornopazud.data.model.IntroSlide
import com.example.entornopazud.view.EvaluationActivities.EndConflictPeaceEvaluation
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.peace_container.*


class ConflicEndFragment : AppCompatActivity() {

    private var btnActivity: Button?=null
    private var txtBack: TextView? = null
    private var introSliderAdapter =
        Adapter_Intro_Slider(
            listOf(
                IntroSlide(
                    "Fin del Conflicto",
                    "Ruta para la construcción de una paz estable y duradera\n",
                    R.drawable.endconflict0
                ),
                IntroSlide(
                    "Propósitos: ",
                    "• Finalizar el conflicto armado de 52 años en Colombia entre Farc-ep y Gobierno Nacional \n" +
                            "• Lograr la dejación de armas por parte de Farc-ep \n" +
                            "• Garantizar la reincorporación social, económica y política de todos los integrantes de las Farc-ep \n" +
                            "• Garantizar las condiciones de seguridad para el ejercicio de la política de todas las fuerzas políticas incluido el nuevo partido que surja de las Farc-ep \n",
                    R.drawable.end1
                ),
                IntroSlide(
                    "Problemas a resolver: ",
                    "• Conflicto armado de larga duración y su impacto sobre la población civil \n" +
                            "• Uso de las armas en el ejercicio de la política\n " +
                            "• La estigmatización y persecución de las ideas políticas diferentes o de oposición \n",
                    R.drawable.end2
                ),
                IntroSlide(
                    "Composición: ",
                    "• Cese al fuego y de hostilidades bilateral y definitivo \n" +
                            "▪ Dejación de armas por parte de las Farc-ep \n" +
                            "▪ Zonas veredales transitorias de normalización \n" +
                            "▪ Garantías para el nuevo partido o movimiento político \n",
                    R.drawable.end3
                ),
                IntroSlide(
                    " ",
                    "• Garantías de seguridad\n" +
                            "▪ Comisión nacional de garantías de seguridad. \n" +
                            "▪ Sistema integral de seguridad para el ejercicio de la política. \n",
                    R.drawable.end4
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
        contri.setBackgroundColor(resources.getColor(R.color.EndConflic))
        btnActivity = ButtonActivity
        txtBack = txtBackRuralReform

        txtBack!!.setOnClickListener {
            var intent = Intent(this, PeaceItem::class.java)
            this.startActivity(intent)
        }
        btnActivity!!.setOnClickListener {
            var intent = Intent(this, EndConflictPeaceEvaluation::class.java)
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
