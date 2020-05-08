package com.example.entornopazud.viewmodel.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.view.General_activity.CRUDStudenIndivitual
import com.example.entornopazud.model.models.User
import kotlinx.android.synthetic.main.recycler_row.view.*

class Adapter_Students (items: ArrayList<User>, resourcek : Int, mUser : String) : RecyclerView.Adapter<Adapter_Students.ViewHolder>(){
    /* This class is the adapter to fill the recycler view */
    var items: ArrayList<User>? = null
    var resource : Int
    var mUser : String
    init{
        this.items = items
        this.resource = resourcek
        this.mUser = mUser
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//information about each item of the holder
        val item = items?.get(position)
        holder.name?.text = item?.name
        holder.email?.text = item?.email
        holder.id?.text = item?.id
        holder.cours?.text = item?.course

        holder.vista.setOnClickListener(object : View.OnClickListener  {
            override fun onClick(v: View?) {
                var intent = Intent(v!!.context,
                    CRUDStudenIndivitual::class.java)
                intent.putExtra("key",item?.key)
                intent.putExtra("name",item?.name)
                intent.putExtra("id",item?.id)
                intent.putExtra("email",item?.email)
                intent.putExtra("roll",item?.roll)
                intent.putExtra("course",item?.course)
                intent.putExtra("Teacher",mUser)
                v.context.startActivity(intent)
            }
        })
    }
    override fun getItemCount(): Int {//size of studentlist
        return this.items!!.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(resource, parent,false)//create instance context
        var Holder =
            ViewHolder(
                vista
            )
        return Holder
    }
    class ViewHolder(v : View): RecyclerView.ViewHolder(v){
        var vista = v
        var name :TextView? = null
        var email: TextView?=null
        var id :TextView? = null
        var cours: TextView?=null
        init {

            name = vista.txtName
            email = vista.txtEmail
            id = vista.txtId
            cours = vista.txtCourse
        }
    }
}