package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate4Binding

class QuestionCreate4Activity :
    BindingActivity<ActivityQuestionCreate4Binding>(R.layout.activity_question_create_4) {
    override fun initView() {
        // 로직 작성
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            val fourthQuestionTitle = binding.etQuestionTitle.text?.toString()
            val fourthQuestionAnswer1 = binding.etAnswer1.text?.toString()
            val fourthQuestionAnswer2 = binding.etAnswer2.text?.toString()
            val fourthQuestionAnswer3 = binding.etAnswer3.text?.toString()
            val fourthQuestionAnswer4 = binding.etAnswer4.text?.toString()

            if (fourthQuestionTitle != "" && fourthQuestionAnswer1 != "" && fourthQuestionAnswer2 != "" && fourthQuestionAnswer3 != "" && fourthQuestionAnswer4 != "") {
                startActivity(Intent(this, QuestionCreate5Activity::class.java))
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
        }
    }

}
