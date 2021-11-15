package com.example.learnandroidx.job

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Looper
import java.util.logging.Handler

/**
 * @author    yiliyang
 * @date      21-1-22 下午4:56
 * @version   1.0
 * @since     1.0
 */
class MyJobService : JobService() {

    companion object {
        @JvmStatic
        var code = 0
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        code++
        //默认在主线程执行
        //return true 必须手动调用jobFinished
        Thread {
            Thread.sleep(4000)
            println("onStartJob  ${Thread.currentThread()}  $code")
            jobFinished(params, false)
        }.start()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        //异常终止的时候会调用
        println("onStopJob  ${Thread.currentThread()}")
        //是否需要继续执行
        return false
    }
}