package com.example.entornopazud.view.Fragments.PeaceItem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.R

class TimeLineFra : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    var listOfusers: ArrayList<Dates> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_line_fra)

        listOfusers.add(Dates("1981 ",resources.getString(R.string.line1)))
        listOfusers.add(Dates("1982 ",resources.getString(R.string.line2)))
        listOfusers.add(Dates("1984 ",resources.getString(R.string.line3)))
        listOfusers.add(Dates("1988 ",resources.getString(R.string.line4)))
        listOfusers.add(Dates("1988 ",resources.getString(R.string.line5)))
        listOfusers.add(Dates("1990 ",resources.getString(R.string.line6)))
        listOfusers.add(Dates("1991 ",resources.getString(R.string.line7)))
        listOfusers.add(Dates("1993 ",resources.getString(R.string.line8)))
        listOfusers.add(Dates("1998 ",resources.getString(R.string.line9)))
        listOfusers.add(Dates("1999 ",resources.getString(R.string.line10)))
        listOfusers.add(Dates("2002 ",resources.getString(R.string.line11)))
        listOfusers.add(Dates("2012 ",resources.getString(R.string.line12)))

        mRecyclerView = findViewById(R.id.recycler_TimeLine)

        var mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView!!.layoutManager = mLayoutManager
        mAdapter = Myadapter(listOfusers)
        mRecyclerView!!.adapter = mAdapter
    }
}
class Myadapter(private val mDataList: ArrayList<Dates>) : RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.timeline_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.date.text = mDataList[position].date
        holder.text1.text = mDataList[position].text1
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var date: TextView
        internal var text1: TextView
        init {
            date = itemView.findViewById<View>(R.id.txtDateTimeLine) as TextView
            text1 = itemView.findViewById<View>(R.id.textTimeLine) as TextView
        }
    }
}
class Dates ( date: String,text1: String){
    var date: String? = null
    var text1: String? = null
    init {
        this.date = date
        this.text1 = text1
    }
}
