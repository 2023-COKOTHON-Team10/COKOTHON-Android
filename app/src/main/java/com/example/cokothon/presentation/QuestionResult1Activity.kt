package com.example.cokothon.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivityQuestionResult1Binding

class QuestionResult1Activity : BindingActivity<ActivityQuestionResult1Binding>(R.layout.activity_question_result_1) {
    private lateinit var tvQuestionTitle: TextView
    private lateinit var tvAnswers: TextView
    private lateinit var btnNext: Button

    override fun initView() {
        // Initialize views using view binding
        tvQuestionTitle = binding.tvQuestionTitle
        tvAnswers = binding.tvAnswers
        btnNext = binding.btnNext

        // Assume you have a method to get answer data from the backend
        val answers: List<Pair<String, String>> = answersFromBackend()

        // Set temporary question title
        tvQuestionTitle.text = "1. 엄마와 아빠가 소나기를 피해서 앉아있었던 장소는 어디일까요?"

        // Display answers
        displayAnswers(answers)

        // Set click listener for the next button
        btnNext.setOnClickListener {
            // Navigate to QuestionResult2Activity
            startActivity(Intent(this, QuestionResult2Activity::class.java))
            finish()
        }
    }

    private fun answersFromBackend(): List<Pair<String, String>> {
        // Assume A, B, C, D, E each answered 1, 2, 3, 4, 5 respectively
        return listOf(
            Pair("엄마", "1 서점 앞 천막"),
            Pair("아빠", "1 서점 앞 천막"),
            Pair("누나", "2 공원 정자"),
            Pair("철수", "4 놀이터 미끄럼틀"),
        )
    }

    private fun displayAnswers(answers: List<Pair<String, String>>) {
        val answersText = StringBuilder()

        // Iterate through answers and append to the StringBuilder
        for ((username, answerContent) in answers) {
            answersText.append("$username : $answerContent\n\n")
        }

        // Set the text to the TextView
        tvAnswers.text = answersText.toString()
    }
}
