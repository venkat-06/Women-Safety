package com.shubham.womensafety

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.ProgressBar

class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    lateinit var img:ImageView
    lateinit var img1:ImageView
    lateinit var a:Animation
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        img = findViewById(R.id.logo)
        img1 = findViewById(R.id.womentxt)
        progressBar = findViewById(R.id.progressBar)
        startProgressAnimation()
        a = AnimationUtils.loadAnimation(applicationContext,R.anim.fade)
        img.startAnimation(a)
        img1.startAnimation(a)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000) // 4000 milliseconds = 4 seconds
    }
    private fun startProgressAnimation() {
        ObjectAnimator.ofInt(progressBar, "progress", 100).apply {
            duration = 4000 // 4000 milliseconds = 4 seconds
            interpolator = LinearInterpolator()
            start()
        }
    }
}