package com.example.learnandroidx.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed

/**
 * @author    yiliyang
 * @date      2021/6/29 下午4:27
 * @version   1.0
 * @since     1.0
 */
class FlowLiveDataViewModel : ViewModel() {
    /* 传统的LiveData模式
     val myLiveData = MutableLiveData("default")

     fun test() {
         viewModelScope.launch {
             myLiveData.value = "state change"
         }
     }*/

/* 传统StateFlow方式
    val myStateFlow = MutableStateFlow("default")

    fun test() {
        myStateFlow.value = "value change"
    }*/


    /*改进的LiveData
     val result: LiveData<String> = liveData {
        emit("default")
        delay(1000)
        emit("change")
    }*/

    val result: StateFlow<String> = flow {
        emit("change")
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000), //由于是一次性操作，也可以使用 Lazily
        initialValue = "default"
    )

}