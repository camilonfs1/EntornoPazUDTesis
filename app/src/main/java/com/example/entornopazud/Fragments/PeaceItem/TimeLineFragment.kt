package com.example.entornopazud.Fragments.PeaceItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.entornopazud.R

class TimeLineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_line, container, false)
    }


}
/*

private var mRecyclerView: RecyclerView? = null
private var mAdapter: RecyclerView.Adapter<*>? = null
var listOfusers: ArrayList<Dates> = ArrayList()



override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.timeline)

    listOfusers!!.add(Dates("1981 "," El gobierno del expresidente Julio Cesar Turbay creo una comisión de paz para iniciar conversaciones con la guerrilla. El expresidente Carlos Lleras Restrepo quien tenía la misión de liderar el proceso renuncio con el argumento de que no lo dejaron establecer contactos con la insurgencia"))
    listOfusers!!.add(Dates("hola ","Eyehunt kjhfsdlkjfhsaldjfhawlkjfhasdkjfhasldjfhasldjfhqwluehuh"))

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
}*/