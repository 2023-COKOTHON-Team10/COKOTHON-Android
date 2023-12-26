package com.example.cokothon.presentation

import android.content.Intent
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityExamineeBinding

class ExamineeActivity : BindingActivity<ActivityExamineeBinding>(R.layout.activity_examinee) {
    override fun initView() {
        val intentFromQuizNumber = intent
        val quizNumber = intentFromQuizNumber.getStringExtra("quizNumber")

        binding.btnExamineeNext.setOnClickListener {
            val examineeID = binding.etExamineeInput.text.toString()
            if (examineeID == "") {
                toast("수험자 이름을 입력해 주세요.")
            } else {
                val userData = UserData(
                    name = examineeID
                )
                // 서버로 name 전송

                val intentToQuestionAnswerActivity = Intent(this, QuestionAnswerActivity::class.java)
                //intentToQuestionAnswerActivity.putExtra("quizNumber", quizNumber)
                startActivity(intentToQuestionAnswerActivity)
                finish()
            }
        }
    }
}