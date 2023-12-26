package com.example.cokothon.presentation

import android.content.Intent
import android.content.res.ColorStateList
import android.util.Log
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate1Binding

class QuestionCreate1Activity :
    BindingActivity<ActivityQuestionCreate1Binding>(R.layout.activity_question_create_1) {
    private var question1Data = QuestionData(
        contents = "",
        user_id = 0,    // 현재 가짜 데이터, 서버에서 받아와야 함
        type = "1",
        choice1 = "",
        choice1_bool = false,
        choice2 = "",
        choice2_bool = false,
        choice3 = "",
        choice3_bool = false,
        choice4 = "",
        choice4_bool = false
    )

    override fun initView() {
        // 로직 작성
        nextBtnClickListener()
        numberClickListener()
    }

    private fun numberClickListener() {
        binding.ivFirstQuestionAnswer1.setOnClickListener {
            question1Data.choice1_bool = !question1Data.choice1_bool
            if (question1Data.choice1_bool) {
                binding.ivFirstQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFirstQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivFirstQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFirstQuestionAnswer2.setOnClickListener {
            question1Data.choice2_bool = !question1Data.choice2_bool
            if (question1Data.choice2_bool) {
                binding.ivFirstQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFirstQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivFirstQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFirstQuestionAnswer3.setOnClickListener {
            question1Data.choice3_bool = !question1Data.choice3_bool
            if (question1Data.choice3_bool) {
                binding.ivFirstQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFirstQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivFirstQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFirstQuestionAnswer4.setOnClickListener {
            question1Data.choice4_bool = !question1Data.choice4_bool
            if (question1Data.choice4_bool) {
                binding.ivFirstQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFirstQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivFirstQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            var isValuesHasData = getQuestionData()
            var choiceBoolean = (question1Data.choice1_bool || question1Data.choice2_bool || question1Data.choice3_bool || question1Data.choice4_bool)

            if (isValuesHasData && choiceBoolean) {
                startActivity(Intent(this, QuestionCreate2Activity::class.java))
                finish()
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
            Log.d("question1Data", question1Data.toString())
        }
    }

    private fun getQuestionData(): Boolean {
        question1Data.contents = binding.etQuestionTitle.text.toString()
        question1Data.choice1 = binding.etAnswer1.text.toString()
        question1Data.choice2 = binding.etAnswer2.text.toString()
        question1Data.choice3 = binding.etAnswer3.text.toString()
        question1Data.choice4 = binding.etAnswer4.text.toString()

        return (question1Data.contents != "" && question1Data.choice1 != "" && question1Data.choice2 != "" && question1Data.choice3 != "" && question1Data.choice4 != "")
    }
}
