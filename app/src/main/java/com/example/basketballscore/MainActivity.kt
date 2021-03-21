package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel

        viewModel.localScoreLiveData.observe(this, Observer {
            localScoreValue -> Int
            binding.localScoreTV.text = localScoreValue.toString()
        })

        viewModel.visitorScoreLiveData.observe(this, Observer {
            visitorScoreValue -> Int
            binding.visitorScoreTV.text = visitorScoreValue.toString()
        })

        setUpButtons()
    }

    private fun setUpButtons() {
        binding.resultsButton.setOnClickListener {
            openScoreActivty()
        }
    }

    private fun addPointsToScore(points: Int, isLocal: Boolean) {
        viewModel.addPointsToScore(points, isLocal)
    }

    private fun openScoreActivty() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.localScoreLiveData.value)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY,viewModel. visitorScoreLiveData.value)
        startActivity(intent)
    }

}










