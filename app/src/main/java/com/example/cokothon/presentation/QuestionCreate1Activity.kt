package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate1Binding

class QuestionCreate1Activity :
    BindingActivity<ActivityQuestionCreate1Binding>(R.layout.activity_question_create_1) {
    override fun initView() {
        // 로직 작성
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            val firstQuestionTitle = binding.etQuestionTitle.text?.toString()
            val firstQuestionAnswer1 = binding.etAnswer1.text?.toString()
            val firstQuestionAnswer2 = binding.etAnswer2.text?.toString()
            val firstQuestionAnswer3 = binding.etAnswer3.text?.toString()
            val firstQuestionAnswer4 = binding.etAnswer4.text?.toString()

            if (firstQuestionTitle != "" && firstQuestionAnswer1 != "" && firstQuestionAnswer2 != "" && firstQuestionAnswer3 != "" && firstQuestionAnswer4 != "" ) {
                startActivity(Intent(this, QuestionCreate2Activity::class.java))
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
        }
    }
}
