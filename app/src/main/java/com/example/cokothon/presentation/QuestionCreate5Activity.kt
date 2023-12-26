package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate5Binding

class QuestionCreate5Activity :
    BindingActivity<ActivityQuestionCreate5Binding>(R.layout.activity_question_create_5) {
    override fun initView() {
        // 로직 작성
        submitBtnClickListener()
    }

    private fun submitBtnClickListener() {
        binding.btnSubmit.setOnClickListener {
            val fifthQuestionTitle = binding.etQuestionTitle.text?.toString()
            val fifthQuestionAnswer1 = binding.etAnswer1.text?.toString()
            val fifthQuestionAnswer2 = binding.etAnswer2.text?.toString()
            val fifthQuestionAnswer3 = binding.etAnswer3.text?.toString()
            val fifthQuestionAnswer4 = binding.etAnswer4.text?.toString()

            if (fifthQuestionTitle != "" && fifthQuestionAnswer1 != "" && fifthQuestionAnswer2 != "" && fifthQuestionAnswer3 != "" && fifthQuestionAnswer4 != "") {
                startActivity(Intent(this, ShowQuizNumberActivity::class.java))
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
        }
    }
}
