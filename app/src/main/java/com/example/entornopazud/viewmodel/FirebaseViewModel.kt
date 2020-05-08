package com.example.entornopazud.viewmodel

import android.content.Context
import com.example.entornopazud.model.models.User
import com.example.entornopazud.model.repositories.FiresSource

class FirebaseViewModel(){
    private val repository = FiresSource()
    fun login(context: Context,Email :String, Pass: String)=repository.login(context,Email, Pass)
    fun register(context: Context,Email :String, Pass: String, User: User)=repository.RegisterUser(context,Email, Pass,User)
}

