package com.example.learnandroidx.vm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_flow_livedata.*
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect

/**
 * @author    yiliyang
 * @date      2021/6/29 下午4:31
 * @version   1.0
 * @since     1.0
 */
class FlowLiveDataTestActivity : AppCompatActivity(R.layout.activity_flow_livedata) {

    private val viewModel by viewModels<FlowLiveDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        lifecycleScope.launchWhenResumed {
//            viewModel.myStateFlow.collect {
//                println(it)
//            }
//        }
//        test.setOnClickListener {
//            viewModel.test()
//        }
    }
}