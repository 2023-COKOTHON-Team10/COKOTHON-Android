package com.example.cokothon.presentation

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.util.Log
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionCreate5Binding

class QuestionCreate5Activity :
    BindingActivity<ActivityQuestionCreate5Binding>(R.layout.activity_question_create_5) {
    lateinit var spf: SharedPreferences
    private var question5Data = QuestionData(
        contents = "",
        user_id = 0,    // 현재 가짜 데이터, 서버에서 받아와야 함
        type = "5",
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
        spf = applicationContext.getSharedPreferences("question5", MODE_PRIVATE)
        submitBtnClickListener()
        numberClickListener()
    }

    private fun numberClickListener() {
        binding.ivFifthQuestionAnswer1.setOnClickListener {
            question5Data.choice1_bool = !question5Data.choice1_bool
            if (question5Data.choice1_bool) {
                binding.ivFifthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFifthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question5Data.choice2_bool = false
                question5Data.choice3_bool = false
                question5Data.choice4_bool = false
            } else {
                binding.ivFifthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
        binding.ivFifthQuestionAnswer2.setOnClickListener {
            question5Data.choice2_bool = !question5Data.choice2_bool
            if (question5Data.choice2_bool) {
                binding.ivFifthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFifthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question5Data.choice1_bool = false
                question5Data.choice3_bool = false
                question5Data.choice4_bool = false
            } else {
                binding.ivFifthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
        binding.ivFifthQuestionAnswer3.setOnClickListener {
            question5Data.choice3_bool = !question5Data.choice3_bool
            if (question5Data.choice3_bool) {
                binding.ivFifthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFifthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question5Data.choice1_bool = false
                question5Data.choice2_bool = false
                question5Data.choice4_bool = false
            } else {
                binding.ivFifthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
        binding.ivFifthQuestionAnswer4.setOnClickListener {
            question5Data.choice4_bool = !question5Data.choice4_bool
            if (question5Data.choice4_bool) {
                binding.ivFifthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.yellow))
                binding.ivFifthQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                binding.ivFifthQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
                question5Data.choice1_bool = false
                question5Data.choice2_bool = false
                question5Data.choice3_bool = false
            } else {
                binding.ivFifthQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.white))
            }
        }
    }

    private fun submitBtnClickListener() {
        binding.btnSubmit.setOnClickListener {
            var isValuesHasData = getQuestionData()
            var choiceBoolean = (question5Data.choice1_bool || question5Data.choice2_bool || question5Data.choice3_bool || question5Data.choice4_bool)

            if (isValuesHasData && choiceBoolean) {
                spf.edit().putString("contents", question5Data.contents).apply()
                spf.edit().putString("choice1", question5Data.choice1).apply()
                spf.edit().putString("choice2", question5Data.choice2).apply()
                spf.edit().putString("choice3", question5Data.choice3).apply()
                spf.edit().putString("choice4", question5Data.choice4).apply()

                startActivity(Intent(this, ShowQuizNumberActivity::class.java))
                finish()
            } else {
                toast("입력되지 않은 값이 있습니다.")
            }
            Log.d("question5Data", question5Data.toString())
        }
    }

    private fun getQuestionData(): Boolean {
        question5Data.contents = binding.etQuestionTitle.text.toString()
        question5Data.choice1 = binding.etAnswer1.text.toString()
        question5Data.choice2 = binding.etAnswer2.text.toString()
        question5Data.choice3 = binding.etAnswer3.text.toString()
        question5Data.choice4 = binding.etAnswer4.text.toString()

        return (question5Data.contents != "" && question5Data.choice1 != "" && question5Data.choice2 != "" && question5Data.choice3 != "" && question5Data.choice4 != "")
    }
}