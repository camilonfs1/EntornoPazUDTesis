package com.example.entornopazud.Fragments.PeaceItem

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

        listOfusers!!.add(Dates("1981 ","El gobierno del expresidente Julio Cesar Turbay creo una comisión de paz para iniciar conversaciones con la guerrilla. El expresidente Carlos Lleras Restrepo quien tenía la misión de liderar el proceso renuncio con el argumento de que no lo dejaron establecer contactos con la insurgencia"))
        listOfusers!!.add(Dates("1982 "," El entonces presidente conservador Belisario Betancur inicio una negociación de Paz con las Farc. "))
        listOfusers!!.add(Dates("1984 ","El gobierno de Betancur y las Farc-Ep firmaron el acuerdo de La Uribe, que incluye el cese al fuego bilateral, la suspensión del secuestro y la apertura de espacios políticos para la guerrilla. El proceso fracaso y se rompió en 1987. "))
        listOfusers!!.add(Dates("1988 ","El presidente liberal, Virgilio Barco comienza acercamientos de paz con las Farc, pero el exterminio a manos de paramilitares de ultraderecha de miles de militantes del partido Unión Patriótica impide avanzar "))
        listOfusers!!.add(Dates("1988 ","Barco inicia diálogos con el M-19 y expide la ley de amnistía"))
        listOfusers!!.add(Dates("1990 ","El gobierno de Barco firma un acuerdo de paz con el M-19 que entrega las armas, se reintegra a la vida civil y se convierte en fuerza política. "))
        listOfusers!!.add(Dates("1991 ","El entonces presidente, Cesar Gaviria inicia conversaciones con las Farc-Ep y el ELN en Venezuela y luego se traslada a Tlaxcala en México. En 1992 se rompe el proceso por el asesinato de un exministro secuestrado por la guerrilla. "))
        listOfusers!!.add(Dates("1993 ","Durante el gobierno de Gaviria se reintegran a la vida civil y entregan las armas los integrantes de la Corriente de Renovación Socialista, una disidencia del ELN. "))
        listOfusers!!.add(Dates("1998 ","El gobierno de Ernesto Samper concede el estatus político al ELN en un esfuerzo por lograr un acuerdo de paz. También hubo un encuentro con el ELN en España y Alemania que no prosperaron "))
        listOfusers!!.add(Dates("1999 ","Se inicia el proceso con las Farc-Ep. Los diálogos se realizan en medio de la confrontación y se rompieron en febrero de 2002 "))
        listOfusers!!.add(Dates("2002 ","Durante el gobierno de Álvaro Uribe, se iniciaron diálogos con el ELN en Cuba, pero estas aproximaciones fracasaron "))
        listOfusers!!.add(Dates("2012 ","El expresidente Juan Manuel Santos anuncia a comienzos de septiembre que su gobierno y las Farc-ep firmaron un acuerdo que establece un procedimiento, una hoja de ruta, para avanzar en la negociación de Paz"))

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
