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

class VictimsFragment : AppCompatActivity() {


    private var btnActivity: Button?=null
    private var txtBack: TextView? = null
    private var introSliderAdapter =
        Adapter_Intro_Slider(
            listOf(
                IntroSlide(
                    "Victimas",
                    "“Sistema integral de verdad, justicia, reparación y no repetición, incluyendo la jurisdicción especial para la paz y compromisos sobre derechos humanos” \n",
                    R.drawable.victims0
                ),
                IntroSlide(
                    "",
                    "Los derechos de las víctimas son el centro del proceso de paz, el 14 de junio de 2014 se presentaron los principios sobre derechos de las víctimas: \n\n" +
                            "• El reconocimiento de las víctimas: Se reconoce todas las víctimas del conflicto armado en su condición de ciudadanos y ciudadanas de derechos. \n" +
                            "• Reconocimiento de responsabilidad respecto a las víctimas del conflicto: El acuerdo busca que todos los actores del conflicto asuman su responsabilidad y cuentan la verdad sobre lo ocurrido. \n",
                    R.drawable.victims1
                ),
                IntroSlide(
                    "",
                    "• Satisfacción de los derechos de las víctimas: Los derechos de las víctimas del conflicto no son negociables, el acuerdo final busca que en todos los casos se garantice su total satisfacción y goce de derechos. \n" +
                            "• Participación de las víctimas: Se promoverá la participación de las víctimas por diferentes medios y en diferentes momentos de implementación del acuerdo final.  \n" +
                            "• Esclarecimiento de la verdad: La construcción de la verdad sobre las causas orígenes y efectos del conflicto, conoceré que paso es un paso necesario para no repetir lo vivido \n",
                    R.drawable.victims2
                ),
                IntroSlide(
                    "",
                    "• Reparación a las víctimas: Todas las victimas tienen derecho a ser reparadas, esto es resarcir los daños causados, restablecer sus derechos y transformar sus condiciones de vida  \n" +
                            "• Garantías de protección y seguridad para las víctimas: En todos los casos, la garantía de protección para las victimas será el primer paso para la satisfacción de sus demás derechos\n" +
                            "• La garantía de no repetición: El fin del conflicto y la implementación del acuerdo final constituyen la principal garantía de no repetición y la forma de asegurar que no surjan nuevas generaciones de victimas \n ",
                    R.drawable.victims3
                ),
                IntroSlide(
                    "",
                    "• Principio de reconciliación: El acuerdo aporta a la reconciliación de la sociedad colombiana, para transitar hacia un escenario de convivencia y civilidad entre las y los colombianos \n" +
                            "• Enfoque de derechos: Busca contribuir a la protección y la garantía del goce efectivo de los derechos de todas y todos \n" +
                            " \n ",
                    R.drawable.victims4
                ),
                IntroSlide(
                    "Propósitos",
                    "• Satisfacción de los derechos de todas las víctimas del conflicto \n" +
                            "• Rendición de cuentas de todos los actores que participaron del conflicto y el establecimiento de sus responsabilidades • Garantizar la no repetición \n" +
                            "• Promover en la sociedad colombiana el rechazo de la guerra y sus efectos \n" +
                            "• Garantizar un tratamiento diferenciado de los territorios y poblaciones más afectadas  \n",
                    R.drawable.victims5
                ),
                IntroSlide(
                    "Problemas a resolver",
                    "• Afectaciones sufridas por la población civil en el marco del conflicto armado \n" +
                            "• Impunidad frente a violaciones a DDHH\n " +
                            "• Desconocimiento de la verdad sobre lo ocurrido en el marco del conflicto \n" +
                            "• Afectaciones a los territorios \n",
                    R.drawable.victims6
                ),
                IntroSlide(
                    "Componentes del acuerdo de víctimas",
                    "Comisión para el esclarecimiento de la verdad, la convivencia y la no repetición \n\n" +
                            "• 11 comisionados \n" +
                            "• 5 años de duración \n",
                    R.drawable.victims7
                ),
                IntroSlide(
                    "",

                    "• Unidad especial para la búsqueda de personas dadas por desaparecidas en el contexto y en razón del conflicto armado \n " +
                            "Unidad de alto nivel y de carácter humanitario que se encargara de esclarecer lo que pasado con las personas dadas por desaparecidas  \n" +
                            "• Jurisdicción especial para la paz  \n" +
                            "Ejercerá funciones judiciales frente a graves infracciones al DIH o violaciones de DDHH cometidos en el contexto y en razón del conflicto armado  \n" +
                            "• Medidas de reparación integral para la construcción de paz  \n" +
                            "• Garantías de no repetición. \n ",
                    R.drawable.victims8
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.peace_container)
        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        contri.setBackgroundColor(resources.getColor(R.color.Victims))
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
