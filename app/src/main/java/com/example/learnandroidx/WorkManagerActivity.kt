package com.example.learnandroidx

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kotlinx.android.synthetic.main.activity_workmanager.*
import java.util.concurrent.TimeUnit

/**
 * @author    yiliyang
 * @date      20-12-24 下午3:54
 * @version   1.0
 * @since     1.0
 */
class WorkManagerActivity : AppCompatActivity(R.layout.activity_workmanager) {

    override fun onResume() {
        super.onResume()
        start.setOnClickListener {

            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
//                .setRequiresCharging(true)
                .build()

            OneTimeWorkRequestBuilder<MyWork>().apply {
//                setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            }.build()

            val myWorkRequest: PeriodicWorkRequest =
                PeriodicWorkRequestBuilder<MyWork>(1, TimeUnit.HOURS)
                    .setConstraints(constraints)
                    .setBackoffCriteria(
                        BackoffPolicy.LINEAR,
                        OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                        TimeUnit.MILLISECONDS
                    )
                    .setInputData(workDataOf("name" to "yuliyang"))
                    .addTag("haha")
                    .build()

            WorkManager
                .getInstance(this)
                .enqueue(myWorkRequest)
        }
    }


}

class MyWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        println("doWork")
        println(Thread.currentThread())
        println(inputData.getString("name"))
        return Result.success()
    }

    override fun onStopped() {
        println("onStopped")
        super.onStopped()
    }
}