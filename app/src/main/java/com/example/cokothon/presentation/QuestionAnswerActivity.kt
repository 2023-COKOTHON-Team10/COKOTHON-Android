package com.example.cokothon.presentation

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.util.Log
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.databinding.ActivityQuestionAnswerBinding

class QuestionAnswerActivity :
    BindingActivity<ActivityQuestionAnswerBinding>(R.layout.activity_question_answer) {
    private var currentQuestionStateList: MutableList<Boolean> =
        mutableListOf(false, false, false, false)
    private var answerList: MutableList<Long> = mutableListOf()
    private var currentQuestionData = QuestionData(
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
    private var quizNumber = "-1"

    override fun initView() {
        val intentFromExaminee = intent
        quizNumber = intentFromExaminee.getStringExtra("quizNumber").toString()

        // 로직 작성
        Log.d("_quizNumber3", quizNumber)
        initQuizData("1")
        nextBtnClickListener()
        numberClickListener()
    }

    private fun initQuizData(questionType: String) {
// 서버에서 questionType과 type이 맞는 questionData를 받아옴
// 아래는 임의 코드

//        for (type in types) {
//            if (type == questionType) {
//                currentQuestionData = getDocument
//                break
//            }
//        }

        var questionNumber = "question$questionType"
        val spf: SharedPreferences =
            applicationContext.getSharedPreferences(questionNumber, MODE_PRIVATE)

        currentQuestionData = QuestionData(
            contents = spf.getString("contents", "").toString(),
            user_id = 0,    // 현재 가짜 데이터, 서버에서 받아와야 함
            type = questionType,
            choice1 = spf.getString("choice1", "").toString(),
            choice1_bool = false,
            choice2 = spf.getString("choice2", "").toString(),
            choice2_bool = false,
            choice3 = spf.getString("choice3", "").toString(),
            choice3_bool = false,
            choice4 = spf.getString("choice4", "").toString(),
            choice4_bool = false
        )

        Log.d("currentQuestionData", currentQuestionData.toString())

        binding.tvQuestionTitle.text = currentQuestionData.contents
        binding.tvAnswer1.text = currentQuestionData.choice1
        binding.tvAnswer2.text = currentQuestionData.choice2
        binding.tvAnswer3.text = currentQuestionData.choice3
        binding.tvAnswer4.text = currentQuestionData.choice4
    }

    private fun numberClickListener() {
        binding.ivFirstQuestionAnswer1.setOnClickListener {
            currentQuestionStateList[0] = !currentQuestionStateList[0]
            if (currentQuestionStateList[0]) {
                binding.ivFirstQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.red))
                binding.ivFirstQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                currentQuestionStateList[1] = false
                currentQuestionStateList[2] = false
                currentQuestionStateList[3] = false
            } else {
                binding.ivFirstQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFirstQuestionAnswer2.setOnClickListener {
            currentQuestionStateList[1] = !currentQuestionStateList[1]
            if (currentQuestionStateList[1]) {
                binding.ivFirstQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.red))
                binding.ivFirstQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                currentQuestionStateList[0] = false
                currentQuestionStateList[2] = false
                currentQuestionStateList[3] = false
            } else {
                binding.ivFirstQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFirstQuestionAnswer3.setOnClickListener {
            currentQuestionStateList[2] = !currentQuestionStateList[2]
            if (currentQuestionStateList[2]) {
                binding.ivFirstQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.red))
                binding.ivFirstQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                currentQuestionStateList[0] = false
                currentQuestionStateList[1] = false
                currentQuestionStateList[3] = false
            } else {
                binding.ivFirstQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
        binding.ivFirstQuestionAnswer4.setOnClickListener {
            currentQuestionStateList[3] = !currentQuestionStateList[3]
            if (currentQuestionStateList[3]) {
                binding.ivFirstQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.red))
                binding.ivFirstQuestionAnswer1.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer2.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                binding.ivFirstQuestionAnswer3.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
                currentQuestionStateList[0] = false
                currentQuestionStateList[1] = false
                currentQuestionStateList[2] = false
            } else {
                binding.ivFirstQuestionAnswer4.imageTintList =
                    ColorStateList.valueOf(getColor(R.color.gray))
            }
        }
    }

    private fun nextBtnClickListener() {
        binding.btnNext.setOnClickListener {
            var choiceBoolean =
                (currentQuestionStateList[0] || currentQuestionStateList[1] || currentQuestionStateList[2] || currentQuestionStateList[3])
            if (!choiceBoolean) {
                toast("답을 선택해 주세요.")
            } else {
                if (currentQuestionData.type == "1") {
                    Log.d("currentQuestionData.type", "1")
                    initQuizData("2")
                } else if (currentQuestionData.type == "2") {
                    Log.d("currentQuestionData.type", "2")
                    initQuizData("3")
                } else if (currentQuestionData.type == "3") {
                    Log.d("currentQuestionData.type", "3")
                    initQuizData("4")
                } else if (currentQuestionData.type == "4") {
                    Log.d("currentQuestionData.type", "4")
                    initQuizData("5")
                    binding.btnNext.text = "제출"
                } else if (currentQuestionData.type == "5") {
                    Log.d("currentQuestionData.type", "5")
                }

                updateAnswerList()

                if (answerList.size == 5) {
                    sendAnswerData()
                }

                initAnswer()
            }
        }
    }

    private fun updateAnswerList() {
        for (i in 0..3) {
            if (currentQuestionStateList[i]) {
                answerList.add(i.toLong() + 1)
            }
        }
    }

    private fun initAnswer() {
        binding.ivFirstQuestionAnswer1.imageTintList =
            ColorStateList.valueOf(getColor(R.color.gray))
        binding.ivFirstQuestionAnswer2.imageTintList =
            ColorStateList.valueOf(getColor(R.color.gray))
        binding.ivFirstQuestionAnswer3.imageTintList =
            ColorStateList.valueOf(getColor(R.color.gray))
        binding.ivFirstQuestionAnswer4.imageTintList =
            ColorStateList.valueOf(getColor(R.color.gray))
        currentQuestionStateList = mutableListOf(false, false, false, false)
    }

    private fun sendAnswerData() {
        val answerData = AnswerData(
            user_id = currentQuestionData.user_id,
            ans1 = answerList[0],
            ans2 = answerList[1],
            ans3 = answerList[2],
            ans4 = answerList[3],
            ans5 = answerList[4],
            unique_number = quizNumber
        )
        // 서버로 answerData 전송
        Log.d("answerData", answerData.toString())

        val spf: SharedPreferences =
            applicationContext.getSharedPreferences("answer", MODE_PRIVATE)
        val success = spf.edit().putString("answer", answerData.toString()).commit()
        if (success) {
            val intentToMain = Intent(this, MainActivity::class.java)
            startActivity(intentToMain)
            finish()
        }

    }
}