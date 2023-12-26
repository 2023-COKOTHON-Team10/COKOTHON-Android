package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate2Binding

class QuestionCreate2Activity :
    BindingActivity<ActivityQuestionCreate2Binding>(R.layout.activity_question_create_2) {
    override fun initView() {
        // 로직 작성
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            val secondQuestionTitle = binding.etQuestionTitle.text?.toString()
            val secondQuestionAnswer1 = binding.etAnswer1.text?.toString()
            val secondQuestionAnswer2 = binding.etAnswer2.text?.toString()
            val secondQuestionAnswer3 = binding.etAnswer3.text?.toString()
            val secondQuestionAnswer4 = binding.etAnswer4.text?.toString()

            if (secondQuestionTitle != "" && secondQuestionAnswer1 != "" && secondQuestionAnswer2 != "" && secondQuestionAnswer3 != "" && secondQuestionAnswer4 != "") {
                startActivity(Intent(this, QuestionCreate3Activity::class.java))
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
        }
    }
}
