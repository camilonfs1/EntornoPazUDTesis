package com.example.entornopazud.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.Clases.User
import kotlinx.android.synthetic.main.recycler_row.view.*


class Adapter_Students (items: ArrayList<User>,resourcek : Int) : RecyclerView.Adapter<Adapter_Students.ViewHolder>() {
    /* This class is the adapter to fill the recycler view */
    var items: ArrayList<User>? = null
    var viewHolder: ViewHolder ? = null
    var resource : Int
    init{
        this.items = items
        this.resource = resourcek
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//information about each item of the holder
        val item = items?.get(position)
        holder.name?.text = item?.name
        holder.email?.text = item?.email
        holder.id?.text = item?.id
        holder.roll?.text = item?.roll
    }

    override fun getItemCount(): Int {//size of studentlist
        return this.items!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_Students.ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(resource, parent,false)//create instance context
        viewHolder = ViewHolder(vista)
        return viewHolder!!
    }

    class ViewHolder(v : View): RecyclerView.ViewHolder(v){
        var vista = v
        var name :TextView? = null
        var email: TextView?=null
        var id :TextView? = null
        var roll: TextView?=null

        init {
            name = vista.txtName
            email = vista.txtEmail
            id = vista.txtId
            roll = vista.txtRoll
        }

    }




}