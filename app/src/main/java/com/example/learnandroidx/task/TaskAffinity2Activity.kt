package com.example.learnandroidx.task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnandroidx.MainActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_single_instance.*

/**
 * @author    yiliyang
 * @date      20-12-17 下午4:30
 * @version   1.0
 * @since     1.0
 */
class TaskAffinity2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("TaskAffinity2Activity onCreate  $taskId")
    }
}