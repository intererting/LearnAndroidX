package com.example.learnandroidx.job

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobWorkItem
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_jobscheduler.*

/**
 * @author    yiliyang
 * @date      21-1-22 下午5:04
 * @version   1.0
 * @since     1.0
 */
@RequiresApi(Build.VERSION_CODES.O)
class MyJobSchedulerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobscheduler)

        val mComponentName = ComponentName(packageName, MyJobService::class.java.name)
        val jobInfo = JobInfo.Builder(100, mComponentName)
//                .setRequiresCharging(true)
            .build()
        startJob.setOnClickListener {
            val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

//            .addTriggerContentUri() 监听Uri的改变，然后执行Job
//            .setBackoffCriteria()  //重试策略
//                .setMinimumLatency()//延迟多久执行
//                .setPersisted() //重启是否有效
//                .setTriggerContentMaxDelay() //当Uri变化监听到时，最大延迟时间
//            jobScheduler.schedule(jobInfo)
            jobScheduler.enqueue(jobInfo, JobWorkItem(Intent()))
        }
    }
}