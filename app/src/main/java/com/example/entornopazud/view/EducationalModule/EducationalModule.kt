package com.example.entornopazud.view.EducationalModule

import android.animation.ArgbEvaluator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.entornopazud.viewmodel.Adapters.Adapter_Module
import com.example.entornopazud.model.models.Model
import com.example.entornopazud.R
import com.example.entornopazud.view.General_activity.MainStudent
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
        var roll = intent.getStringExtra("roll")



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
                R.drawable.memory,
                "MEMORIA",
                "La violencia en el mundo, y en particular en Colombia, se caracteriza por que se presenta en situaciones cotidiana"
            )
        )
        models!!.add(
            Model(
                R.drawable.children_school,
                "PAZ",
                "El conflicto en Colombia ha dejado más de 8 millones de víctimas y más de 6 millones de personas desplazadas"
            )
        )
        models!!.add(
            Model(
                R.drawable.bullyng,
                "RECONCILIACIÓN",
                "Democratización del acceso a la tierra en beneficio de las comunidades rurales más afectadas por la pobreza, el abandono "
            )
        )
        val adapter = Adapter_Module(
            models!!,
            this,
            nameStudent,
            keyStrudent,roll
        )
         var viewPager1 = viewPager2
        viewPager1?.setAdapter(adapter)
        viewPager1!!.setPadding(130, 0, 130, 0)

        val colors_temp = arrayOf(
            resources.getColor(R.color.color1),
            resources.getColor(R.color.color2),
            resources.getColor(R.color.color3)
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
