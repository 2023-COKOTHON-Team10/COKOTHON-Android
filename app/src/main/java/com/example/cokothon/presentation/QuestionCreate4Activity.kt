package com.example.cokothon.presentation

import android.content.Intent
import android.content.res.ColorStateList
import android.util.Log
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate4Binding

class QuestionCreate4Activity :
    BindingActivity<ActivityQuestionCreate4Binding>(R.layout.activity_question_create_4) {
    private var question4Data = QuestionData(
        contents = "",
        user_id = 0,    // 현재 가짜 데이터, 서버에서 받아와야 함
        type = "4",
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
        binding.ivFourthQuestionAnswer1.setOnClickListener {
            question4Data.choice1_bool = !question4Data.choice1_bool
            if (question4Data.choice1_bool) {
                binding.ivFourthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFourthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                question4Data.choice2_bool = false
                question4Data.choice3_bool = false
                question4Data.choice4_bool = false
            } else {
                binding.ivFourthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFourthQuestionAnswer2.setOnClickListener {
            question4Data.choice2_bool = !question4Data.choice2_bool
            if (question4Data.choice2_bool) {
                binding.ivFourthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFourthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                question4Data.choice1_bool = false
                question4Data.choice3_bool = false
                question4Data.choice4_bool = false
            } else {
                binding.ivFourthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFourthQuestionAnswer3.setOnClickListener {
            question4Data.choice3_bool = !question4Data.choice3_bool
            if (question4Data.choice3_bool) {
                binding.ivFourthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFourthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                question4Data.choice1_bool = false
                question4Data.choice2_bool = false
                question4Data.choice4_bool = false
            } else {
                binding.ivFourthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFourthQuestionAnswer4.setOnClickListener {
            question4Data.choice4_bool = !question4Data.choice4_bool
            if (question4Data.choice4_bool) {
                binding.ivFourthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFourthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFourthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                question4Data.choice1_bool = false
                question4Data.choice2_bool = false
                question4Data.choice3_bool = false
            } else {
                binding.ivFourthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            var isValuesHasData = getQuestionData()
            var choiceBoolean = (question4Data.choice1_bool || question4Data.choice2_bool || question4Data.choice3_bool || question4Data.choice4_bool)

            if (isValuesHasData && choiceBoolean) {
                startActivity(Intent(this, QuestionCreate5Activity::class.java))
                finish()
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
            Log.d("question4Data", question4Data.toString())
        }
    }

    private fun getQuestionData(): Boolean {
        question4Data.contents = binding.etQuestionTitle.text.toString()
        question4Data.choice1 = binding.etAnswer1.text.toString()
        question4Data.choice2 = binding.etAnswer2.text.toString()
        question4Data.choice3 = binding.etAnswer3.text.toString()
        question4Data.choice4 = binding.etAnswer4.text.toString()

        return (question4Data.contents != "" && question4Data.choice1 != "" && question4Data.choice2 != "" && question4Data.choice3 != "" && question4Data.choice4 != "")
    }
}
