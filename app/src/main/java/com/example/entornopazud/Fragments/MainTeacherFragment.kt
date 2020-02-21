package com.example.entornopazud.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.entornopazud.R


class MainTeacherFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saverdInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_teacher,container,false)

    }


}
