package com.example.learnandroidx.task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.learnandroidx.MainActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_single_instance.*

/**
 * @author    yiliyang
 * @date      20-12-17 下午4:30
 * @version   1.0
 * @since     1.0
 */
class TaskAffinity1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_instance)
        println("TaskAffinity1Activity onCreate  $taskId")
        startSingleInstance.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


    override fun onNewIntent(intent: Intent?) {
        println("TaskAffinity1Activity  onNewIntent")
        super.onNewIntent(intent)
    }

    override fun onPause() {
        super.onPause()
        println("TaskAffinity1Activity onPausee")
    }

    override fun onStop() {
        super.onStop()
        println("TaskAffinity1Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("TaskAffinity1Activity onDestroy")
    }
}