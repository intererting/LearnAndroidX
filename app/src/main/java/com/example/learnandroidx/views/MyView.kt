package com.example.learnandroidx.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * @author    yiliyang
 * @date      2021/7/12 上午9:56
 * @version   1.0
 * @since     1.0
 */
class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                println("MyView  ACTION_DOWN")
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                println("MyView  ACTION_MOVE")
                return true
            }
            else -> return super.onTouchEvent(event)
        }
    }
}