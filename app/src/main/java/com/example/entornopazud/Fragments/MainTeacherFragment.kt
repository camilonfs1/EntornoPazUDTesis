package com.example.entornopazud.Fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.entornopazud.Interfaces.iComunicationFragments

import com.example.entornopazud.R
import kotlinx.android.synthetic.main.fragment_main_teacher.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainTeacherFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    var cardJugar: CardView? = null
    var Icomunica: iComunicationFragments? = null
    var vista: View? = null
    var actividad: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        vista = inflater.inflate(R.layout.fragment_main_teacher, container, false)

        cardJugar = cardjugar
        cardJugar!!.setOnClickListener{
            Toast.makeText(context,"Iniciar juego",Toast.LENGTH_SHORT).show()
        }
        return vista
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainTeacherFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
