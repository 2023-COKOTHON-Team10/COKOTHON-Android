package com.example.cokothon.presentation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.data.ServicePool.quizService
import com.example.cokothon.data.dto.request.RequestUserDto
import com.example.cokothon.databinding.ActivityExaminerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExaminerActivity : BindingActivity<ActivityExaminerBinding>(R.layout.activity_examiner) {
    lateinit var spf: SharedPreferences
    override fun initView() {
        spf = applicationContext.getSharedPreferences("examiner", Context.MODE_PRIVATE)
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnExaminerNext.setOnClickListener {
            val examinerID = binding.etExaminerInput.text.toString()
            if (examinerID.isEmpty()) {
                toast("출제자 이름을 입력해 주세요.")
            } else {
                val userData = UserData(
                    name = examinerID
                )

                // 서버로 name 전송
                quizService.postUser(RequestUserDto(examinerID)).enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.isSuccessful) {
                            toast("성공 $examinerID")
                            val success = spf.edit().putString("nickname", examinerID).commit()
                            if (success) {
                                startActivity(Intent(this@ExaminerActivity, QuestionCreate1Activity::class.java))
                                finish()
                            }
                        } else {
                            toast("서버 오류: ${response.errorBody()}")
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        toast("네트워크 오류: ${t.message}")
                    }
                })
            }
        }
    }
}