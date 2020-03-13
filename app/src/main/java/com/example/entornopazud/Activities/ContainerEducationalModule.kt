package com.example.entornopazud.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.entornopazud.Fragments.PeaceItem.*
import com.example.entornopazud.R

class ContainerEducationalModule : AppCompatActivity() {

    var Fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_educational_module)

        var fragment = intent.getStringExtra("fragment")

        when (fragment) {
            "Agreement" ->{
                Fragment = PeaceAgreementFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, Fragment!!).commit()
            }
            "TimeLine" -> {
                var intent = Intent(this, TimeLineFra::class.java)
                this.startActivity(intent)
            }
            "EndConflic" -> {
                Fragment = EndConflictFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, Fragment!!).commit()

            }
            "Drugs" -> {
                Fragment = IlicitDrugsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, Fragment!!).commit()

            }
            "Implementation" -> {
                Fragment = ImplementationFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, Fragment!!).commit()

            }
            "Participation" -> {
                Fragment = PoliticalParticipationFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, Fragment!!).commit()

            }
            "Vitims" -> {
                Fragment = VictimsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, Fragment!!).commit()

            }
            "RuralReform" -> {
                Fragment = RuralReformFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, Fragment!!).commit()

            }
        }

    }
}
