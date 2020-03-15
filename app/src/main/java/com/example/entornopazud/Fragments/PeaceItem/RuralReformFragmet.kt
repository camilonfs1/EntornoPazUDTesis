package com.example.entornopazud.Fragments.PeaceItem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.entornopazud.Adapters.Adapter_Intro_Slider
import com.example.entornopazud.Clases.IntroSlide
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.fragmet_rural_reform.*
import kotlinx.android.synthetic.main.slide_item.*

class RuralReformFragmet : AppCompatActivity() {

    private var introSliderAdapter = Adapter_Intro_Slider(
        listOf(
            IntroSlide(
                "Sunlint",
                "SunLingh is the li 11111111111111111111",
                R.drawable.girasol_icon
            ),
            IntroSlide(
                "Sunlint",
                "SunLingh is the li 22222222222222222222",
                R.drawable.girasol_icon
            ),
            IntroSlide(
                "Sunlint",
                "SunLingh is the li 33333333333333333333",
                R.drawable.girasol_icon
            ),
            IntroSlide(
                "Sunlint",
                "SunLingh is the li 11111111111111111111",
                R.drawable.girasol_icon
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmet_rural_reform)
        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })


    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for(i in indicators.indices){
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
    private fun setCurrentIndicator(index:Int){
        val chidCount = indicatorConstrainer.childCount
        for(i in 0 until chidCount){
            val imageView = indicatorConstrainer[i] as ImageView
            if(i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }else{
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
