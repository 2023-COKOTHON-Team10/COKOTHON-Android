package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuizNumberBinding

class QuizNumberActivity :
    BindingActivity<ActivityQuizNumberBinding>(R.layout.activity_quiz_number) {
    override fun initView() {
        // 로직 작성
        binding.btnQuizNumberNext.setOnClickListener {
            val quizNumber = binding.etQuizNumberInput.text.toString()
            if (quizNumber == "") {
                toast("출제자 고유 번호를 입력해 주세요.")
            } else {
                val intentToExamineeActivity = Intent(this, ExamineeActivity::class.java)
                intentToExamineeActivity.putExtra("quizNumber", quizNumber)
                startActivity(intentToExamineeActivity)
                finish()
            }
        }
    }
}
