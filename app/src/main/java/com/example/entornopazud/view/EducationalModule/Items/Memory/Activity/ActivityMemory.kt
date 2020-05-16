package com.example.entornopazud.view.EducationalModule.Items.Memory.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_memory.*

class ActivityMemory : AppCompatActivity() {

    private var card1: CardView? = null
    private var card2: CardView? = null
    private var card3: CardView? = null
    private var card4: CardView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)
        card1 = acticity1
        card2 = acticity2
        card3 = acticity3
        card4 = acticity4

        var roll = intent.getStringExtra("roll")
        var name = intent.getStringExtra("name")
        var key = intent.getStringExtra("key")



        card1!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Memory::class.java)
            intent.putExtra("activity", "Diseña una historieta donde pueda plasmar los diferentes tipos de violencia en tu país. Puedes hacer una historia en forma de comic donde puedas ir mostrando los diferentes tipos de violencia directa, estructural y cultural.\\n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Memory_1")
            this.startActivity(intent)
        }
        card2!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Memory::class.java)
            intent.putExtra("activity", "Identifique personas cercanas que estén dispuestas a contar sus diferentes historias y experiencias de la violencia." +
                    "\n• Organiza una entrevista con día y hora del encuentro " +
                    "\n• Prepara un cuestionario de preguntas para tu entrevista y envíalas al entrevistador con antelación. " +
                    "\n• Ten lista los equipos de grabación para tu entrevista. " +
                    "\n• Elabora una ficha de identificación del entrevistado con: nombre, lugar de la entrevista, día y hora y tema.\n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Memory_2")
            this.startActivity(intent)
        }
        card3!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Memory::class.java)
            intent.putExtra("activity", "Identifica situaciones cotidianas de la violencia en la casa, la escuela, el barrio, los medios de comunicación y el Estado." +
                    "\n• Organiza una entrevista con día y hora del encuentro " +
                    "\n• Prepara un cuestionario de preguntas para tu entrevista y envíalas al entrevistador con antelación. " +
                    "\n• Ten lista los equipos de grabación para tu entrevista. " +
                    "\n• Elabora una ficha de identificación del entrevistado con: nombre, lugar de la entrevista, día y hora y tema. \n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Memory_3")
            this.startActivity(intent)

        }
        card4!!.setOnClickListener {
            var intent = Intent(this, Activity_entry_Memory::class.java)
            intent.putExtra("activity", "Escoge una cancion popular o famosa y responde:" +
                    "\n• ¿cuál es la imagen de mujer prevalece en esta canción? " +
                    "\n• ¿Por qué esta canción se puede identificar cómo violencia de género? " +
                    "\n• ¿En qué parte de las estrofas se puede identificar violencia de género? • ¿Cuál es su opinión sobre esta canción? " +
                    "\n• ¿Qué otras canciones conoces de violencia de género?  " +
                    "\n• Bájalas del celular y comparte con tus compañeros algunas de las canciones y organiza un foro de discusión.\n")
            intent.putExtra("roll", roll)
            intent.putExtra("name", name)
            intent.putExtra("key", key)
            intent.putExtra("activityName", "Memory_4")
            this.startActivity(intent)
        }

    }
}
