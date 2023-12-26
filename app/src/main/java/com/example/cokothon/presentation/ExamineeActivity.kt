package com.example.cokothon.presentation

import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityExamineeBinding

class ExamineeActivity : BindingActivity<ActivityExamineeBinding>(R.layout.activity_examinee) {
    override fun initView() {
        binding.btnExamineeNext.setOnClickListener {
            val examineeID = binding.etExamineeInput.text.toString()
            if (examineeID == "") {
                toast("수험자 이름을 입력해 주세요.")
            } else {
                // 퀴즈 풀기 액티비티로 이동
            }
        }
    }
}