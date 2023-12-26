package com.example.cokothon.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivityQuestionResult2Binding

class QuestionResult2Activity : BindingActivity<ActivityQuestionResult2Binding>(R.layout.activity_question_result_2) {
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
        tvQuestionTitle.text = "2. 아빠와 엄마가 처음으로 데이트했던 장소는 어디일까요?"

        // Display answers
        displayAnswers(answers)

        // Set click listener for the next button
        btnNext.setOnClickListener {
            startActivity(Intent(this, QuestionResult3Activity::class.java))
            finish()
        }
    }

    private fun answersFromBackend(): List<Pair<String, String>> {
        // Assume A, B, C, D, E each answered 1, 2, 3, 4, 5 respectively
        return listOf(
            Pair("엄마", "4 남산공원"),
            Pair("아빠", "4 남산공원"),
            Pair("누나", "4 남산공원"),
            Pair("철수", "4 남산공원"),
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
