package com.example.cokothon.presentation

import android.content.Intent
import android.content.res.ColorStateList
import android.util.Log
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate3Binding

class QuestionCreate3Activity :
    BindingActivity<ActivityQuestionCreate3Binding>(R.layout.activity_question_create_3) {
    private var question3Data = QuestionData(
        contents = "",
        user_id = 0,    // 현재 가짜 데이터, 서버에서 받아와야 함
        type = "3",
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
        binding.ivThirdQuestionAnswer1.setOnClickListener {
            question3Data.choice1_bool = !question3Data.choice1_bool
            if (question3Data.choice1_bool) {
                binding.ivThirdQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivThirdQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question3Data.choice2_bool = false
                question3Data.choice3_bool = false
                question3Data.choice4_bool = false
            } else {
                binding.ivThirdQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
        binding.ivThirdQuestionAnswer2.setOnClickListener {
            question3Data.choice2_bool = !question3Data.choice2_bool
            if (question3Data.choice2_bool) {
                binding.ivThirdQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivThirdQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question3Data.choice1_bool = false
                question3Data.choice3_bool = false
                question3Data.choice4_bool = false
            } else {
                binding.ivThirdQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
        binding.ivThirdQuestionAnswer3.setOnClickListener {
            question3Data.choice3_bool = !question3Data.choice3_bool
            if (question3Data.choice3_bool) {
                binding.ivThirdQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivThirdQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question3Data.choice1_bool = false
                question3Data.choice2_bool = false
                question3Data.choice4_bool = false
            } else {
                binding.ivThirdQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
        binding.ivThirdQuestionAnswer4.setOnClickListener {
            question3Data.choice4_bool = !question3Data.choice4_bool
            if (question3Data.choice4_bool) {
                binding.ivThirdQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivThirdQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivThirdQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question3Data.choice1_bool = false
                question3Data.choice2_bool = false
                question3Data.choice3_bool = false
            } else {
                binding.ivThirdQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            var isValuesHasData = getQuestionData()
            var choiceBoolean =
                (question3Data.choice1_bool || question3Data.choice2_bool || question3Data.choice3_bool || question3Data.choice4_bool)

            if (isValuesHasData && choiceBoolean) {
                startActivity(Intent(this, QuestionCreate4Activity::class.java))
                finish()
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
            Log.d("question3Data", question3Data.toString())
        }
    }

    private fun getQuestionData(): Boolean {
        question3Data.contents = binding.etQuestionTitle.text.toString()
        question3Data.choice1 = binding.etAnswer1.text.toString()
        question3Data.choice2 = binding.etAnswer2.text.toString()
        question3Data.choice3 = binding.etAnswer3.text.toString()
        question3Data.choice4 = binding.etAnswer4.text.toString()

        return (question3Data.contents != "" && question3Data.choice1 != "" && question3Data.choice2 != "" && question3Data.choice3 != "" && question3Data.choice4 != "")
    }
}
