package com.example.entornopazud.Adapters

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.Activities.CRUDStudenIndivitual
import com.example.entornopazud.Clases.User
import kotlinx.android.synthetic.main.recycler_row.view.*
import kotlin.coroutines.coroutineContext


class Adapter_Students (items: ArrayList<User>,resourcek : Int) : RecyclerView.Adapter<Adapter_Students.ViewHolder>(){
    /* This class is the adapter to fill the recycler view */
    var items: ArrayList<User>? = null

    var mContext: Context? =  null


    var resource : Int
    init{
        this.items = items
        this.resource = resourcek
        //this.mContext = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//information about each item of the holder
        val item = items?.get(position)
        holder.name?.text = item?.name
        holder.email?.text = item?.email
        holder.id?.text = item?.id
        holder.roll?.text = item?.roll

        holder.vista.setOnClickListener(object : View.OnClickListener  {
            override fun onClick(v: View?) {
                var intent = Intent(v!!.context,CRUDStudenIndivitual::class.java)
                intent.putExtra("key",item?.key)
                intent.putExtra("name",item?.name)
                intent.putExtra("id",item?.id)
                intent.putExtra("email",item?.email)
                intent.putExtra("roll",item?.roll)
                v.context.startActivity(intent)
            }

        })

    }

    override fun getItemCount(): Int {//size of studentlist
        return this.items!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_Students.ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(resource, parent,false)//create instance context
        var Holder = ViewHolder(vista)

        return Holder!!
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