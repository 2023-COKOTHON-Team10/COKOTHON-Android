package com.example.cokothon.presentation

import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivityQuestionAnswerBinding

class QuestionAnswerActivity : BindingActivity<ActivityQuestionAnswerBinding>(R.layout.activity_question_answer) {
    override fun initView() {
        // 로직 작성
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {

        }
    }
}