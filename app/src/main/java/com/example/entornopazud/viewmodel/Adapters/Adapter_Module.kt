package com.example.entornopazud.viewmodel.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.entornopazud.data.model.Model
import com.example.entornopazud.R
import com.example.entornopazud.view.EducationalModulePack.BullyngItem
import com.example.entornopazud.view.EducationalModulePack.ConflictResolutionItem
import com.example.entornopazud.view.EducationalModulePack.MythsItem
import com.example.entornopazud.view.EducationalModulePack.PeaceItem


class Adapter_Module(models: ArrayList<Model>, context: Context, nameStudent: String, KeyStudent : String ) : PagerAdapter ()    {

    private var models: ArrayList<Model>? = null
    private var context: Context? = null
    private var nameStudent: String? = null
    private var keyStudent: String? = null

    init {
        this.nameStudent = nameStudent
        this.keyStudent = KeyStudent
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
            when (models!!.get(position).title) {
                "Acuerdo de Paz" ->{
                    var intent = Intent(context, PeaceItem::class.java)
                   // intent.putExtra("name", nameStudent)
                   // intent.putExtra("key", keyStudent)
                    view.context!!.startActivity(intent)
                }

                "Resolución De Conflictos" ->{
                    var intent = Intent(context, ConflictResolutionItem::class.java)
                    intent.putExtra("name", nameStudent)
                    intent.putExtra("key", keyStudent)
                    view.context!!.startActivity(intent)
                }
                "Acoso Escolar" ->{
                    var intent = Intent(context, BullyngItem::class.java)
                    intent.putExtra("name", nameStudent)
                    intent.putExtra("key", keyStudent)
                    view.context!!.startActivity(intent)
                }
                "5 Mitos Sobre El Acoso Escolar" ->{
                    var intent = Intent(context, MythsItem::class.java)
                    intent.putExtra("name", nameStudent)
                    intent.putExtra("key", keyStudent)
                    view.context!!.startActivity(intent)
                }
                else -> println("nothing")
            }
        }
        container.addView(view)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, o1bject: Any) {
        container.removeView(o1bject as View)
    }

}