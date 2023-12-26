package com.example.cokothon.presentation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityExaminerBinding

class ExaminerActivity : BindingActivity<ActivityExaminerBinding>(R.layout.activity_examiner) {
    lateinit var spf: SharedPreferences
    override fun initView() {
        spf = applicationContext.getSharedPreferences("examiner", Context.MODE_PRIVATE)
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnExaminerNext.setOnClickListener {
            val examinerID = binding.etExaminerInput.text.toString()
            if (examinerID == "") {
                toast("출제자 이름을 입력해 주세요.")
            } else {
                val userData = UserData(
                    name = examinerID
                )
                // 서버로 name 전송

                val success = spf.edit().putString("nickname", examinerID).commit()
                if (success) {
                    startActivity(Intent(this, QuestionCreate1Activity::class.java))
                    finish()
                }
            }
        }
    }
}