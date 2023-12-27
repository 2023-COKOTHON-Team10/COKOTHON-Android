package com.example.cokothon.presentation

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.core.util.context.toast
import com.example.cokothon.data.ServicePool.quizService
import com.example.cokothon.data.dto.request.RequestUniqueNumDto
import com.example.cokothon.databinding.ActivityShowQuizNumberBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowQuizNumberActivity :
    BindingActivity<ActivityShowQuizNumberBinding>(R.layout.activity_show_quiz_number) {
    override fun initView() {
        val spf: SharedPreferences = applicationContext.getSharedPreferences("examiner", MODE_PRIVATE)
        val userId: Long = spf.getLong("userId", 0)
        Log.d("test1", userId.toString())
        toast(userId.toString())

        quizService.getUniqueNum(RequestUniqueNumDto(userId)).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    toast("성공")
                    val quizNumber = response.body()
                    val quizNumberTextView: TextView = binding.quizNumberTextView
                    quizNumberTextView.text = quizNumber

                    val copyButton: Button = binding.copyButton
                    copyButton.setOnClickListener {
                        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clipData = android.content.ClipData.newPlainText("text", quizNumberTextView.text)
                        clipboardManager.setPrimaryClip(clipData)
                        toast("고유번호 복사")
                    }

                    binding.ivAppImage.setOnClickListener {
                        startActivity(Intent(this@ShowQuizNumberActivity, MainActivity::class.java))
                        finish()
                    }
                } else {
                    toast("서버 오류: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                toast("네트워크 오류: ${t.message}")
            }
        })
    }
}