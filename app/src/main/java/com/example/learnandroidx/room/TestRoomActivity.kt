package com.example.learnandroidx.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_workmanager.*

/**
 * @author    yiliyang
 * @date      20-12-25 上午10:30
 * @version   1.0
 * @since     1.0
 */
class TestRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workmanager)
        start.setOnClickListener {
//            GlobalScope.launch {
//                val student = Student(name = "yuliyang")
//                studentDao.insert(student)
//            }
            //room是线程安全的
            for (i in 0..19) {
                Thread({
                    for (i in 0..9999) {
                        val student = Student(name = "yuliyang")
                        studentDao.insert(student)
                    }
                }).start()
            }
        }
    }
}