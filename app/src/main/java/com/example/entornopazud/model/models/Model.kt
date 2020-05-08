package com.example.entornopazud.model.models

class Model(image: Int, title: String, desc: String) {
    var image: Int? = null
    var title: String? = null
    var desc: String? = null

    init {
        this.image = image
        this.title = title
        this.desc = desc
    }
}