package com.example.cokothon.presentation

import android.content.ClipboardManager
import android.content.Context
import com.example.cokothon.R
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivityShowQuizNumberBinding

class ShowQuizNumberActivity : BindingActivity<ActivityShowQuizNumberBinding>(R.layout.activity_show_quiz_number) {
    override fun initView() {
        val quizNumber = "123456"
        val quizNumberTextView: TextView = binding.quizNumberTextView
        quizNumberTextView.text = getString(R.string.quiz_number, quizNumber)

        val copyButton: Button = binding.copyButton
        copyButton.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = android.content.ClipData.newPlainText("text", quizNumberTextView.text)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, getString(R.string.copy_button), Toast.LENGTH_SHORT).show()
        }
    }
}