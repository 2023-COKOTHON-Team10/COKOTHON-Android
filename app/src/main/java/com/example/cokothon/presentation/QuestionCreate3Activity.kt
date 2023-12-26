package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate3Binding

class QuestionCreate3Activity :
    BindingActivity<ActivityQuestionCreate3Binding>(R.layout.activity_question_create_3) {
    override fun initView() {
        // 로직 작성
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            val thirdQuestionTitle = binding.etQuestionTitle.text?.toString()
            val thirdQuestionAnswer1 = binding.etAnswer1.text?.toString()
            val thirdQuestionAnswer2 = binding.etAnswer2.text?.toString()
            val thirdQuestionAnswer3 = binding.etAnswer3.text?.toString()
            val thirdQuestionAnswer4 = binding.etAnswer4.text?.toString()

            if (thirdQuestionTitle != null && thirdQuestionAnswer1 != null && thirdQuestionAnswer2 != null && thirdQuestionAnswer3 != null && thirdQuestionAnswer4 != null) {
                startActivity(Intent(this, QuestionCreate4Activity::class.java))
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
        }
    }
}
