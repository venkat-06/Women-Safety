package com.shubham.womensafety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast

class feedback : AppCompatActivity() {
    lateinit var iv : ImageView
    lateinit var btn:Button
    lateinit var n1:EditText
    lateinit var feed:EditText
    lateinit var rat:RatingBar

    lateinit var a: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        iv = findViewById(R.id.animi)
        a = AnimationUtils.loadAnimation(applicationContext,R.anim.bounce)

        fun startAnimation() {
            iv.startAnimation(a)
        }
        val handler = Handler()
        val runnable: Runnable = object : Runnable {
            override fun run() {
                startAnimation()
                handler.postDelayed(this, 2000)
            }
        }

        startAnimation()

        handler.postDelayed(runnable, 5000)

        btn =findViewById(R.id.feedbutton)
        feed = findViewById(R.id.feedback)
        rat =findViewById(R.id.ratingBar)
        n1 = findViewById(R.id.name)
        btn.setOnClickListener {
            Toast.makeText(this, "Thanks for your Valuable feedback !!\n We Will get Back to you SOON",Toast.LENGTH_LONG).show()
            n1.text.clear()
            feed.text.clear()
            rat.setRating(0f)
        }
    }
}