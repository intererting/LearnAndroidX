package com.example.learnandroidx.views

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * @author    yiliyang
 * @date      21-4-12 下午3:09
 * @version   1.0
 * @since     1.0
 */
class MeasuredView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        println(minimumWidth)
        val specSize = resolveSizeAndState(400, widthMeasureSpec, 1)
        println(MeasureSpec.getSize(specSize))
    }
}