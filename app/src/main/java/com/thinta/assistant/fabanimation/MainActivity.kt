package com.thinta.assistant.fabanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    private lateinit var fabRClockWise: Animation
    private lateinit var fabRanticlockwise: Animation
    private var isOpen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fabOpen = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_close)
        fabRClockWise = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_clockwise)
        fabRanticlockwise = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_anitclockwise)
        fab_plus.setOnClickListener {
            if (isOpen) {
                fab_info.startAnimation(fabClose)
                fab_air.startAnimation(fabClose)
                fab_plus.startAnimation(fabRanticlockwise)
                fab_info.isClickable = false
                fab_air.isClickable = false
                isOpen = false
            } else {
                fab_info.startAnimation(fabOpen)
                fab_air.startAnimation(fabOpen)
                fab_plus.startAnimation(fabRClockWise)
                fab_info.isClickable = true
                fab_air.isClickable = true
                isOpen = true
            }
        }
        fab_air.setOnClickListener { Toast.makeText(this, "点击了air按钮", Toast.LENGTH_SHORT).show() }
        fab_info.setOnClickListener { Toast.makeText(this, "点击了info按钮", Toast.LENGTH_SHORT).show() }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (isOpen) {
            fab_info.startAnimation(fabClose)
            fab_air.startAnimation(fabClose)
            fab_plus.startAnimation(fabRanticlockwise)
            fab_info.isClickable = false
            fab_air.isClickable = false
            isOpen = false
            return true
        }
        return super.onTouchEvent(event)
    }
}
