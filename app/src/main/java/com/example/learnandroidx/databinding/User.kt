package com.example.learnandroidx.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayList
import com.example.learnandroidx.BR

/**
 * @author    yiliyang
 * @date      20-12-4 上午10:39
 * @version   1.0
 * @since     1.0
 */
class User : BaseObservable() {
    //只能是val，public
//    val name = ObservableField<String>()
//    val age = ObservableInt()
//    val maps = ObservableArrayMap<String, String>()
    val lists = ObservableArrayList<String>()

    @get:Bindable
    var name: String = "default"
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
}