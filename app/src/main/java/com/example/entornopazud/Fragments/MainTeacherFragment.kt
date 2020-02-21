package com.example.entornopazud.Fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.entornopazud.Interfaces.iComunicationFragmentsTeacher
import com.example.entornopazud.R


class MainTeacherFragment : Fragment() {

    private var StudentCard: CardView? = null
    private var CoursesCard: CardView? = null
    private var StadisticsCard: CardView? = null
    private var DataBasesCard: CardView? = null
    private var ActivitysCard: CardView? = null
    private var ChatsCard: CardView? = null
    private var vista: View? = null
    private var activity: Activity?=null
    private  var ifragment: iComunicationFragmentsTeacher?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saverdInstanceState: Bundle?
    ): View? {

        vista = inflater.inflate(R.layout.fragment_main_teacher, container, false)
        StudentCard = vista!!.findViewById(R.id.StudentsCard)
        CoursesCard = vista!!.findViewById(R.id.CorusesCard)
        StadisticsCard = vista!!.findViewById(R.id.StadisticCard)
        DataBasesCard = vista!!.findViewById(R.id.DBCard)
        ActivitysCard = vista!!.findViewById(R.id.ActivitysCard)
        ChatsCard = vista!!.findViewById(R.id.ChatsCard)


        listenerEvents()

        return vista
    }

    fun listenerEvents(){
        StudentCard!!.setOnClickListener {
            ifragment!!.Students()
        }
        CoursesCard!!.setOnClickListener {
            ifragment!!.Courses()
        }
        StadisticsCard!!.setOnClickListener {
            ifragment!!.Stadistics()
        }
        DataBasesCard!!.setOnClickListener {
            ifragment!!.DataBases()
        }
        ActivitysCard!!.setOnClickListener {
            ifragment!!.Activitys()
        }
        ChatsCard!!.setOnClickListener {
            ifragment!!.Chats()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            activity = context
            ifragment = activity as iComunicationFragmentsTeacher
        }


    }



}
