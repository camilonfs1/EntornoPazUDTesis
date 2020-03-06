package com.example.entornopazud.Activities;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.entornopazud.R
import com.google.firebase.database.FirebaseDatabase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_main_teacher_chat.*
import kotlinx.android.synthetic.main.row_lates_message.view.*

class MainTeacherChat : AppCompatActivity() {

    private var BtnHome: Button? = null
    private var BtnNewMen: Button? = null

    private var nameTeacher: String? = null
    private var keyTeacher: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher_chat)
        nameTeacher = intent.getStringExtra("name")
        keyTeacher = intent.getStringExtra("key")
        initialise(nameTeacher!!, keyTeacher!!)

    }

    private fun initialise(nameTeacher: String, keyTeacher : String) {
        BtnHome = BtnHomeTeacher
        BtnNewMen = BtnNewMenMain

        BtnHome!!.setOnClickListener {
            var intent = Intent(this, MainTeacher::class.java)
            intent.putExtra("name", nameTeacher)
            intent.putExtra("key", keyTeacher)
            this.startActivity(intent)
        }
        BtnNewMen!!.setOnClickListener {
            var intent = Intent(this, NewMessageTeacher::class.java)
            intent.putExtra("name", nameTeacher)
            intent.putExtra("key", keyTeacher)
            this.startActivity(intent)
        }
        //setupDummyRows()
        listForLatesMassages(keyTeacher+"")

    }

    class LatesMessageRow(text:String): Item<GroupieViewHolder>(){
        var text = ""
        init {
            this.text = text
        }
        override fun getLayout(): Int {
            return R.layout.row_lates_message
        }

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.txtNameLates.text = text
        }

    }
    private fun listForLatesMassages(keyTeacher:String){

        val ref = FirebaseDatabase.getInstance().getReference("/lates_messages")

    }

    private fun setupDummyRows(g){
        val adapter = GroupAdapter<GroupieViewHolder>()

        adapter.add(LatesMessageRow("hola0"))
        adapter.add(LatesMessageRow("hola1"))
        adapter.add(LatesMessageRow("hola2"))

        recyLatesMessages.adapter = adapter
    }


}

