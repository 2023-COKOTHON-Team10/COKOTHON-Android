package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun initView() {
        // 로직 작성
        createBtnClickListener()
        answerBtnClickListener()
        resultBtnClickListener()
    }

    private fun createBtnClickListener() {
        binding.btnCreateQuestion.setOnClickListener {
            startActivity(Intent(this, ExaminerActivity::class.java))
        }
    }

    private fun answerBtnClickListener() {
        binding.btnAnswerQuestion.setOnClickListener {
            startActivity(Intent(this, QuizNumberActivity::class.java))
        }
    }
    private fun resultBtnClickListener() {
        binding.btnCheckAnswer.setOnClickListener {
            startActivity(Intent(this, QuizResultActivity::class.java))
        }
    }
}
