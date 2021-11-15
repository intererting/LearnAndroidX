package com.example.learnandroidx

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.learnandroidx.vm.FlowSearchViewModel
import kotlinx.android.synthetic.main.activity_flow_with_vm.*
import kotlinx.coroutines.*

/**
 * @author    yiliyang
 * @date      21-4-13 上午9:11
 * @version   1.0
 * @since     1.0
 */
class FlowWithViewModelActivity : AppCompatActivity(R.layout.activity_flow_with_vm) {

    private val viewModel by viewModels<FlowSearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.showProgressBarLiveData.observe(this) { show ->
            println("showProgressBarLiveData $show")
        }

        viewModel.showRecyclerViewLiveData.observe(this) { show ->
            println("showRecyclerViewLiveData  $show")
        }

        viewModel.showEmptyStateLiveData.observe(this) { show ->
            println("showEmptyStateLiveData  $show")
        }
//
//        lifecycleScope.launchWhenResumed {
//            while (true) {
//                println("in progress")
//                delay(1000)
//            }
//        }

        search.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.search("yuliyang")
            }
        }
    }
}