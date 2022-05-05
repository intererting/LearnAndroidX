package com.example.learnandroidx.eventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_eventbus.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * @author    yiliyang
 * @date      21-1-19 上午8:58
 * @version   1.0
 * @since     1.0
 */
class EventBusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        EventBus.builder().addIndex(MyEventBusIndex()).installDefaultEventBus();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eventbus)
        testEventBus.setOnClickListener {
            EventBus.getDefault().post(MessageEvent("yuliyang"))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        println("event receive  ${event.message}")
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}
