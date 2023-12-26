package com.example.cokothon.presentation

import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityExaminerBinding

class ExaminerActivity : BindingActivity<ActivityExaminerBinding>(R.layout.activity_examiner) {
    override fun initView() {
        val examinerID = binding.etExaminerInput.text.toString()
        if (examinerID == "") {
            toast("출제자 이름을 입력해 주세요.")
        } else {
            // 퀴즈 생성 액티비티로 이동
        }
    }
}