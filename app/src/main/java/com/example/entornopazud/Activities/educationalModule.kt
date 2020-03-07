package com.example.entornopazud.Activities

import android.animation.ArgbEvaluator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.entornopazud.Adapters.Adapter_Module
import com.example.entornopazud.Clases.Model
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_educational_module.*


class educationalModule : AppCompatActivity() {

    var models: ArrayList<Model>? = ArrayList()
    var colors: Array<Int>? = null
    var argbEvaluator: ArgbEvaluator = ArgbEvaluator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_educational_module)


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
                "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"
            )
        )
        models!!.add(
            Model(
                R.drawable.three_p,
                "“LAS TRES P” ",
                "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."
            )
        )
        models!!.add(
            Model(
                R.drawable.bullyng,
                "Acoso Escolar ",
                "Business cards are cards bearing business information about a company or individual."
            )
        )
        models!!.add(
            Model(
                R.drawable.mythe,
                "5 Mitos Sobre El Acoso Escolar",
                "Business cards are cards bearing business information about a company or individual."
            )
        )


        val adapter = Adapter_Module(models!!, this)

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

        viewPager1!!.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position < (adapter.count - 1) && position < (colors!!.size - 1)) {
                    viewPager1!!.setBackgroundColor(
                        argbEvaluator.evaluate(
                            positionOffset,
                            colors!![position], colors!![position + 1]
                        ) as Int
                    )


                }else {
                    viewPager1!!.setBackgroundColor(colors!!.get(colors!!.size - 1));
                }
            }

            override fun onPageSelected(position: Int) {

            }

        })


    }
}
