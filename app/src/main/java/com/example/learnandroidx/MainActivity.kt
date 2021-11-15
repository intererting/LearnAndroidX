package com.example.learnandroidx

import android.app.ActivityManager
import android.app.NotificationManager
import android.app.Service
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobService
import android.app.job.JobWorkItem
import android.content.*
import android.graphics.BitmapFactory
import android.os.*
import android.provider.Settings
import android.provider.Settings.Panel.ACTION_INTERNET_CONNECTIVITY
import android.transition.TransitionInflater
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.ViewAnimationUtils
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.learnandroidx.task.TaskAffinity1Activity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.io.DataInputStream
import java.io.DataOutputStream
import java.lang.Runnable
import java.lang.RuntimeException
import java.util.concurrent.Executors
import java.util.stream.Stream
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println("MainActivity onCreate")
        setContentView(R.layout.activity_main)

        val result = buildSpannedString {
            bold {
                append("yuliyang")
            }
        }

        addRepeatingJob(Lifecycle.State.STARTED) {
            println("addRepeatingJob")
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Repeat when the lifecycle is STARTED, cancel when STOPPED
                // Do work with expensive object
            }
        }

//        println(ClassLoader.getSystemClassLoader())
//        println("MainActivity onCreate $taskId")

//        registerReceiver(object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent?) {
//                println("onReveive1")
//            }
//
//        }, IntentFilter("haha"))
//
//        registerReceiver(object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent?) {
//                println("onReveive2")I
//                applicationContext.startActivity(Intent(this@MainActivity, ProcessActivity::class.java))
//            }
//
//        }, IntentFilter("haha"))

        startProcessActivity.setOnClickListener {

//            MainScope().launch {
//                CoroutineScope(coroutineContext).launch {
//                    delay(1000)
//                    println("inner scope ")
//                }
//            }

//            val handler = CoroutineExceptionHandler(handler = { _, error ->
//                println("catch error")
//
//            })
//            CoroutineScope(handler).launch {
//                async {
//                    println("async")
//                    throw RuntimeException()
//                }
//                launch {
//                    println("launch")
//                }
//            }


//            println("MainActivity  $taskId")
//            startActivity(Intent(this, TaskAffinity1Activity::class.java).apply {
////                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
//            })

//            println("ProcessActivity  $taskId")
//            val intent = Intent(this, ProcessActivity::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
//            }
//            startActivity(intent)

//            sendBroadcast(Intent("haha"))


//            val activityService = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//            for (info in activityService.runningAppProcesses) {
//                println(info.processName)
//            }


//            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.test)
//            println(bitmap.width)

//            myViewGroup.requestLayout()

//            println(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 14f, resources.displayMetrics))

//            val metrics = resources.displayMetrics
//            println(metrics.density)
//            println(metrics.densityDpi)
//            println(metrics.scaledDensity)
//            println(metrics.heightPixels)
//            metrics.scaledDensity = 5f
//            recreate()

//            val intent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
//            startActivity(intent)

//            startActivity(Intent(this, ParentActivity::class.java))

//            val c1 = classLoader
//            println(c1)
//            val c2 = classLoader.parent
//            println(c2)

//            with(applicationInfo) {
//                println(publicSourceDir)
//                println(splitNames)
//                println(dataDir)
//                println(nativeLibraryDir)
//            }

//            val sp = getSharedPreferences("test", Context.MODE_PRIVATE)
//            sp.edit() {
//
//            }
        }

//        myViewGroup.setOnTouchListener { _, _ ->
//            println("onTouchListener")
//            return@setOnTouchListener true
//        }

        myViewGroup.setOnClickListener {
            myViewGroup.postInvalidate()
            println("xxx")
        }

//        myViewGroupB.setOnClickListener {
//
//        }


//        startForegroundService(Intent(this, ForgroundService::class.java))
        close.setOnClickListener {
//            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.cancel(0x1)
//            GlobalScope.launch {
//
//                launch {
//                    println("coroutine A")
//                }
//
//                coroutineScope {
//                    launch {
//                        println("coroutine B")
//                    }
//                    launch {
//                        delay(4000)
//                        println("coroutine C")
//                    }
//                }
//                launch {
//                    println("coroutine D")
//                }
//
//            }

            startActivity(Intent(this, TaskAffinity1Activity::class.java))

        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        println("MainActivity onAttachedToWindow")
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Handler(Looper.getMainLooper()).post(Runnable {

        })
    }

    override fun onStart() {
        super.onStart()
        println("MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        println("MainActivity onResume")
    }
}