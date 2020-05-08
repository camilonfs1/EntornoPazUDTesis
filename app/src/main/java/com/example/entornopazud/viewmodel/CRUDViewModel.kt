package com.example.entornopazud.viewmodel

import android.content.Context
import com.example.entornopazud.data.model.User
import com.example.entornopazud.data.repositories.FiresCRUD

class CRUDViewModel {
    private val repository = FiresCRUD()
    fun CrudStuden(user: User, context: Context, techaer:String)=repository.updateStudent(user,context,techaer)
    fun deleteStuden(user: User, context: Context, techaer:String)=repository.deleteStudent(user,context,techaer)
    fun createCourse(course: String, techaer: String, context: Context)=repository.createCourse(course,techaer,context)
    fun deleteCourse(course: String, context: Context)=repository.deleteCourse(course,context)
}