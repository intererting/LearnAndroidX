package com.example.learnandroidx

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsAnimation
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_workmanager.*

/**
 * @author    yiliyang
 * @date      20-12-29 下午1:40
 * @version   1.0
 * @since     1.0
 */
@RequiresApi(Build.VERSION_CODES.R)
class WindowInsetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workmanager)
        window.setDecorFitsSystemWindows(false)
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        root.setOnApplyWindowInsetsListener { v, insets ->
//            println(insets.getInsets(WindowInsets.Type.ime()).bottom)
            WindowInsets.CONSUMED
        }
        root.setWindowInsetsAnimationCallback(object : WindowInsetsAnimation.Callback(DISPATCH_MODE_STOP) {
            override fun onProgress(
                insets: WindowInsets,
                runningAnimations: MutableList<WindowInsetsAnimation>
            ): WindowInsets {
                println(insets.getInsets(WindowInsets.Type.ime()).bottom)
                return insets
            }

        })

    }
}