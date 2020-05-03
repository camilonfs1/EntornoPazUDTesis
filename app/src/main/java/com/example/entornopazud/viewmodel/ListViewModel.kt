package com.example.entornopazud.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.entornopazud.data.model.Courses
import com.example.entornopazud.data.repositories.FiresList

class ListViewModel: ViewModel() {
    private val listRepo = FiresList()
    fun fechCoursData():LiveData<ArrayList<Courses>>{
        val mutableData = MutableLiveData<ArrayList<Courses>>()
        listRepo.getCoursesData().observeForever { coursList ->
                mutableData.value = coursList
        }
        return mutableData
    }

    fun courses(mUser: String, context: Context,recyStu: RecyclerView)= listRepo.readCoursesDb(mUser,context,recyStu)
}