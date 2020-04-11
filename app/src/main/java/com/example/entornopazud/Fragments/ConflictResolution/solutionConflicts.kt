package com.example.entornopazud.Fragments.ConflictResolution

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.entornopazud.EvaluationActivities.SolutionConflictEvaluation
import com.example.entornopazud.R
import kotlinx.android.synthetic.main.activity_solution_conflicts.*

class solutionConflicts : AppCompatActivity() {
    private var cardSolutEvaluaction: CardView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution_conflicts)

        cardSolutEvaluaction = cardEvaluationSol

        cardSolutEvaluaction!!.setOnClickListener {
            this.startActivity(Intent(this, SolutionConflictEvaluation::class.java))
        }

    }
}
