package com.example.entornopazud.viewmodel.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.model.models.IntroSlide
import com.example.entornopazud.R

class Adapter_Intro_Slider(private val introSlides: List<IntroSlide>) :
    RecyclerView.Adapter<Adapter_Intro_Slider.IntroSlideViewHolder>() {

    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.TextTitleSlide)
        private val textDrescription = view.findViewById<TextView>(R.id.TextDescriptionSlide)
        private val imageIcon = view.findViewById<ImageView>(R.id.imageIcon)

        fun bind(introSlide: IntroSlide) {
            textTitle.text = introSlide.title
            textDrescription.text = introSlide.description
            imageIcon.setImageResource(introSlide.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }
}