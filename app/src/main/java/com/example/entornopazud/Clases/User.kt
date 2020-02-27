package com.example.entornopazud.Clases

class User(key:String, name: String,   email: String, id: String, roll: String){
    /* This class is de dataClase Users in data base firebase has the same structure*/
    var key: String = ""
    var name: String = ""
    var email: String= ""
    var id: String = ""
    var roll: String =""

    init {
        this.key = key
        this.name = name
        this.email= email
        this.id = id
        this.roll = roll
    }

}