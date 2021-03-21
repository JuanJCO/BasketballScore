package com.example.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basketballscore.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    companion object{
        const val LOCAL_SCORE_KEY = "local_score"
        const val VISITOR_SCORE_KEY = "visitor_Score"
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityScoreBinding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val localScore = bundle.get(LOCAL_SCORE_KEY)
        val visitorScore = bundle.get(VISITOR_SCORE_KEY)

        binding.scoreTV.text = "$localScore - $visitorScore"

    }
}