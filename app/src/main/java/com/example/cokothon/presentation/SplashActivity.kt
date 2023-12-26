package com.example.cokothon.presentation

import android.content.Intent
import android.os.Handler
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivitySplashBinding

class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun initView() {
        // 로직 작성
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }, DURATION)
    }

    companion object {
        private const val DURATION : Long = 3000
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}