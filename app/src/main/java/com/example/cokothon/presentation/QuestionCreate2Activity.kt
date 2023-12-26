package com.example.cokothon.presentation

import android.content.Intent
import android.content.res.ColorStateList
import android.util.Log
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate2Binding

class QuestionCreate2Activity :
    BindingActivity<ActivityQuestionCreate2Binding>(R.layout.activity_question_create_2) {
    private var question2Data = QuestionData(
        contents = "",
        user_id = 0,    // 현재 가짜 데이터, 서버에서 받아와야 함
        type = "2",
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
        binding.ivSecondQuestionAnswer1.setOnClickListener {
            question2Data.choice1_bool = !question2Data.choice1_bool
            if (question2Data.choice1_bool) {
                binding.ivSecondQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivSecondQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivSecondQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivSecondQuestionAnswer2.setOnClickListener {
            question2Data.choice2_bool = !question2Data.choice2_bool
            if (question2Data.choice2_bool) {
                binding.ivSecondQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivSecondQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivSecondQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivSecondQuestionAnswer3.setOnClickListener {
            question2Data.choice3_bool = !question2Data.choice3_bool
            if (question2Data.choice3_bool) {
                binding.ivSecondQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivSecondQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivSecondQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivSecondQuestionAnswer4.setOnClickListener {
            question2Data.choice4_bool = !question2Data.choice4_bool
            if (question2Data.choice4_bool) {
                binding.ivSecondQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivSecondQuestionAnswer1.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer2.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivSecondQuestionAnswer3.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            } else {
                binding.ivSecondQuestionAnswer4.imageTintList = ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            var isValuesHasData = getQuestionData()
            var choiceBoolean = (question2Data.choice1_bool || question2Data.choice2_bool || question2Data.choice3_bool || question2Data.choice4_bool)

            if (isValuesHasData && choiceBoolean) {
                startActivity(Intent(this, QuestionCreate3Activity::class.java))
                finish()
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
            Log.d("question2Data", question2Data.toString())
        }
    }

    private fun getQuestionData(): Boolean {
        question2Data.contents = binding.etQuestionTitle.text.toString()
        question2Data.choice1 = binding.etAnswer1.text.toString()
        question2Data.choice2 = binding.etAnswer2.text.toString()
        question2Data.choice3 = binding.etAnswer3.text.toString()
        question2Data.choice4 = binding.etAnswer4.text.toString()

        return (question2Data.contents != "" && question2Data.choice1 != "" && question2Data.choice2 != "" && question2Data.choice3 != "" && question2Data.choice4 != "")
    }
}
