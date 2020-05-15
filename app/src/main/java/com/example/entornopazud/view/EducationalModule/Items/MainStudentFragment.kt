package com.example.entornopazud.view.EducationalModule.Items


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.entornopazud.viewmodel.Interfaces.iComunicationFragmentsStudent
import com.example.entornopazud.R

class MainStudentFragment : Fragment() {
    /* This class is the logic for fragment teacher */

    //CardView initialization
    private var ProfileCard: CardView? = null
    private var ActivityCard: CardView? = null
    private var StadisticCard: CardView? = null
    private var AvatarCard: CardView? = null
    private var PrizesCard: CardView? = null
    private var ChatsCard: CardView? = null
    private var vista: View? = null
    private var btnOut: Button? = null
    private var activitys: Activity? = null
    private var nameStuden: TextView? = null

    private var ifragment: iComunicationFragmentsStudent? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saverdInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_main_student, container, false)

        nameStuden = vista!!.findViewById(R.id.nameStud)
        btnOut = vista!!.findViewById(R.id.BtnSigout)
        ProfileCard = vista!!.findViewById(R.id.ProfileCard)
        ActivityCard = vista!!.findViewById(R.id.CorusesCard)
        StadisticCard = vista!!.findViewById(R.id.StadisticCard)
        AvatarCard = vista!!.findViewById(R.id.AvatarCard)
        PrizesCard = vista!!.findViewById(R.id.PrizeCard)
        ChatsCard = vista!!.findViewById(R.id.ChatsCard)

        listenerEvents()
        nameStuden!!.setText(ifragment!!.nameUser())
        return vista
    }

    fun listenerEvents() {
        ProfileCard!!.setOnClickListener {
            ifragment!!.Profile()
        }
        ActivityCard!!.setOnClickListener {
            ifragment!!.Activities1()
        }
        StadisticCard!!.setOnClickListener {
            ifragment!!.Stadistics()
        }
        AvatarCard!!.setOnClickListener {
            ifragment!!.Avatar()
        }
        PrizesCard!!.setOnClickListener {
            ifragment!!.Prize()
        }
        ChatsCard!!.setOnClickListener {
            ifragment!!.Chats()
        }
        btnOut!!.setOnClickListener {
            ifragment!!.SigOut()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            activitys = context
            ifragment = activitys as iComunicationFragmentsStudent
        }


    }
}
