package com.example.entornopazud.viewmodel.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.model.models.Reflections
import kotlinx.android.synthetic.main.recycler_reflection.view.*

class Adapter_reflections(items: ArrayList<Reflections>, resourcek: Int) :
    RecyclerView.Adapter<Adapter_reflections.ViewHolder>() {
    var items: ArrayList<Reflections>? = null
    var resource: Int

    init {
        this.items = items
        this.resource = resourcek
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {
        val item = items?.get(position)
        holder.activity?.text = item?.activity
        holder.reflection?.text = item?.reflection
    }

    override fun getItemCount(): Int {
        return this.items!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(resource, parent, false)//create instance context
        var Holder = ViewHolder(vista)
        return Holder
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vista = v
        var activity: TextView? = null
        var reflection: TextView? = null

        init {
            activity = vista.txtActivity
            reflection = vista.txtReflection
        }
    }
}