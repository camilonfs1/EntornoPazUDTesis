package com.example.entornopazud.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.entornopazud.Clases.Courses
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.row_course.view.*

class Adapter_Courses(private val mContext: Context, private var coursesList: List<Courses>) :
    ArrayAdapter<Courses>(mContext, 0, coursesList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(context).inflate(R.layout.row_course, parent, false)
        val course = coursesList[position]
        layout.txtNameCourseRow.setText(course.name)
        return layout
    }

}



