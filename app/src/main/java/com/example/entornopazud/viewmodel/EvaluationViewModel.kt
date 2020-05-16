package com.example.entornopazud.viewmodel

import android.content.Context
import com.example.entornopazud.model.repositories.FiresEvaluation

class EvaluationViewModel {
    private val repository = FiresEvaluation()
    fun register(key : String,activityName: String,nameStudent:String,reflection:String,context: Context)=repository.registeractivity(key,activityName,nameStudent,reflection,context)
}