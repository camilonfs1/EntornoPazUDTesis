package com.example.entornopazud.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.entornopazud.Activities.MainActivity
import com.example.entornopazud.Activities.MainStudentChat
import com.example.entornopazud.Clases.Model
import com.example.entornopazud.R


class Adapter_Module(models: ArrayList<Model>, context: Context) : PagerAdapter ()    {

    private var models: ArrayList<Model>? = null
    private var context: Context? = null

    init {
        this.models = models
        this.context = context
    }

    override fun getCount(): Int {
        return models!!.size
    }

    override fun isViewFromObject(view: View, o1bject: Any): Boolean {
        return view.equals(o1bject)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.item, container, false)

        var image : ImageView= view.findViewById(R.id.image)
        var title : TextView = view.findViewById(R.id.title)
        var desc : TextView = view.findViewById(R.id.desc)

        image.setImageResource(models!!.get(position).image!!)
        title.setText(models!!.get(position).title)
        desc.setText(models!!.get(position).desc)

        view.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            context!!.startActivity(intent)

        }

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, o1bject: Any) {
        container.removeView(o1bject as View)
    }

}