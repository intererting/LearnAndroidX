package com.example.learnandroidx.task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_single_instance.*

/**
 * @author    yiliyang
 * @date      20-12-17 下午4:25
 * @version   1.0
 * @since     1.0
 */
class SingleInstanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_instance)
        startSingleInstance.setOnClickListener {
            startActivity(Intent(this, SingleInstanceActivity::class.java))
        }
        println("SingleInstanceActivity onCreate   $taskId")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        println("SingleInstanceActivity onNewIntent   $taskId")
    }
}