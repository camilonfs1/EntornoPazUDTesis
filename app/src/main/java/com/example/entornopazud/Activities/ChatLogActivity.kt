package com.example.entornopazud.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.entornopazud.Clases.ChatMessage
import com.example.entornopazud.R
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_chat_log.*
import kotlinx.android.synthetic.main.chat_row_from.view.*
import kotlinx.android.synthetic.main.chat_row_to.view.*

class ChatLogActivity : AppCompatActivity() {
    private var TextNameChat: TextView? = null
    private var btnBack: Button? = null
    private var btnSentMessage: Button? = null

    companion object {
        val TAG = "ChatLog"
    }

    val adapter = GroupAdapter<GroupieViewHolder>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)
        TextNameChat = TxtNameChat
        btnBack = BtnBackChat
        btnSentMessage = btnSentChatlog

        recycler_ChatLog.adapter = adapter

        val userNameB = intent.getStringExtra("userNameB")
        val userNameA = intent.getStringExtra("userNameA")
        val UserKeyB = intent.getStringExtra("UserKeyB")
        val UserKeyA = intent.getStringExtra("UserKeyA")
        val roll = intent.getStringExtra("Roll")

        TextNameChat!!.setText(userNameB)

        //setupDummyData()

        listenForMessages(UserKeyA, UserKeyB)

        btnSentMessage!!.setOnClickListener {
            Log.d(TAG, "Attempt to sent massage...")
            performSendMassage(UserKeyA, UserKeyB)
        }
        btnBack!!.setOnClickListener {
            if(roll.equals("Student")){
                var intent = Intent(this, MainStudentChat::class.java)
                intent.putExtra("name", userNameA)
                intent.putExtra("key", UserKeyA)
                this.startActivity(intent)
            }else if(roll.equals("Teacher")){
                var intent = Intent(this, MainTeacherChat::class.java)
                intent.putExtra("name", userNameA)
                intent.putExtra("key", UserKeyA)
                this.startActivity(intent)
            }

        }
    }

    private fun listenForMessages(UserKeyA: String, UserKeyB: String) {
        val fromId = UserKeyA
        val toId = UserKeyB

        val ref = FirebaseDatabase.getInstance().getReference("/messages-users/$fromId/$toId")
        ref.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val chatMessage = p0.getValue(ChatMessage::class.java)
                if (chatMessage != null) {
                    Log.d(TAG, chatMessage?.text)

                    if (chatMessage.fromId == UserKeyA && chatMessage.toId == UserKeyB) {
                        adapter.add(ChatItemTo(chatMessage!!.text))
                    } else if (chatMessage.fromId == UserKeyB) {
                        adapter.add(ChatItemFrom(chatMessage.text))
                    }
                }
            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }
        })
    }

    private fun performSendMassage(UserKeyA: String, UserKeyB: String) {
        //Send a message to firebase
        var text = txt_chat_log.text.toString()
        val fromId = UserKeyA
        val toId = UserKeyB

        //val reference = FirebaseDatabase.getInstance().getReference("/messages").push()
        val reference =
            FirebaseDatabase.getInstance().getReference("/messages-users/$fromId/$toId").push()
        val referenceto =
            FirebaseDatabase.getInstance().getReference("/messages-users/$toId/$fromId").push()
        val chatMessage =
            ChatMessage(reference.key!!, text, fromId, toId, System.currentTimeMillis() / 1000)
        reference.setValue(chatMessage)
            .addOnSuccessListener {
                Log.d(TAG, "Saved our chat message: ${reference.key}")
                txt_chat_log.setText("")
                recycler_ChatLog.scrollToPosition(adapter.itemCount - 1)

            }
        referenceto.setValue(chatMessage)
        val latesMessageeRef = FirebaseDatabase.getInstance().getReference("/latest-messages/$fromId/$toId")
        latesMessageeRef.setValue(chatMessage)
    }


}

class ChatItemFrom(val text: String) : Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.chat_row_from
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textViewFrom.text = text
    }
}

class ChatItemTo(val text: String) : Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.chat_row_to
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textViewTo.text = text
    }
}
