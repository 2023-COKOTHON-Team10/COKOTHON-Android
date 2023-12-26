package com.example.cokothon.presentation
import android.content.Intent
import android.widget.Button
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivityQuizResultBinding

class QuizResultActivity : BindingActivity<ActivityQuizResultBinding>(R.layout.activity_quiz_result) {
    override fun initView() {
        // 로직 작성
        nextBtnClickListener()
    }

    private fun nextBtnClickListener() {
        binding.btnResult.setOnClickListener {
            startActivity(Intent(this, QuestionResult1Activity::class.java))
        }
    }
}