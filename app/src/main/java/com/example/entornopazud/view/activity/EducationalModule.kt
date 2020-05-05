package com.example.entornopazud.view.activity

import android.animation.ArgbEvaluator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.entornopazud.viewmodel.Adapters.Adapter_Module
import com.example.entornopazud.data.model.Model
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_educational_module.*


class EducationalModule : AppCompatActivity() {

    var models: ArrayList<Model>? = ArrayList()
    var colors: Array<Int>? = null
    var argbEvaluator: ArgbEvaluator = ArgbEvaluator()
    private var btnBack : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_educational_module)
        var nameStudent = intent.getStringExtra("name")
        var keyStrudent = intent.getStringExtra("key")

        btnBack= btnBackk
        btnBack!!.setOnClickListener {
            var intent = Intent(this, MainStudent::class.java)
            intent.putExtra("name", nameStudent)
            intent.putExtra("key", keyStrudent)
            this.startActivity(intent)
        }
        models = ArrayList()
        models!!.add(
            Model(
                R.drawable.pazimage,
                "Acuerdo de Paz",
                "Conseptos basicos e historia del acuerdo de paz en Colombia"
            )
        )
        models!!.add(
            Model(
                R.drawable.children_school,
                "Resolución De Conflictos",
                "Los conflictos se producen en todas las culturas"
            )
        )
        models!!.add(
            Model(
                R.drawable.bullyng,
                "Acoso Escolar",
                "“El niño debe ser protegido contra las practicas que puedan fomentar la discriminación"
            )
        )
        models!!.add(
            Model(
                R.drawable.mythe,
                "5 Mitos Sobre El Acoso Escolar",
                " “El acoso escolar es una forma de molestar entre amigos” "
            )
        )

        val adapter = Adapter_Module(
            models!!,
            this,
            nameStudent,
            keyStrudent
        )

         var viewPager1 = viewPager2
        viewPager1?.setAdapter(adapter)
        viewPager1!!.setPadding(130, 0, 130, 0)

        val colors_temp = arrayOf(
            resources.getColor(R.color.color1),
            resources.getColor(R.color.color2),
            resources.getColor(R.color.color3),
            resources.getColor(R.color.color4),
            resources.getColor(R.color.color5)
        )
        colors = colors_temp
        viewPager1.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position < (adapter.count - 1) && position < (colors!!.size - 1)) {
                    viewPager1.setBackgroundColor(
                        argbEvaluator.evaluate(
                            positionOffset,
                            colors!![position], colors!![position + 1]
                        ) as Int
                    )
                }else {
                    viewPager1.setBackgroundColor(colors!!.get(colors!!.size - 1));
                }
            }

            override fun onPageSelected(position: Int) {

            }
        })
    }
}
