package com.example.learnandroidx

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import dalvik.system.DexClassLoader
import kotlin.math.log

/**
 * @author    yiliyang
 * @date      20-11-12 下午3:03
 * @version   1.0
 * @since     1.0
 */
class OnePixelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "OnePixelActivity onCreate")
        window.setGravity(Gravity.TOP or Gravity.START)
        val windowParam = window.attributes
        with(windowParam) {
            width = 1
            height = 1
            x = 0
            y = 0
        }
        window.attributes = windowParam
    }


    override fun onDestroy() {
        Log.d("test", "OnePixelActivity onDestroy")
        super.onDestroy()
    }

}