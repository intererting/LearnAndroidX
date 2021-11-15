package com.example.learnandroidx.views

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * @author    yiliyang
 * @date      21-4-21 下午2:41
 * @version   1.0
 * @since     1.0
 */
class RequestLayoutView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        println("onMeasure")
    }
}