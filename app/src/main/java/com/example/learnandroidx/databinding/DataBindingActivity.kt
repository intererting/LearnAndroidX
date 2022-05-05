package com.example.learnandroidx.databinding

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayMap
import com.example.learnandroidx.R
import com.google.android.material.shape.MaterialShapeDrawable
import kotlinx.android.synthetic.main.activity_databinding.*
import kotlinx.android.synthetic.main.viewstub_inflate.view.*

/**
 * @author    yiliyang
 * @date      20-12-4 上午10:21
 * @version   1.0
 * @since     1.0
 */
class DataBindingActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDatabindingBinding

    private val mapData = ObservableArrayMap<String, String>().apply {
        put("name", "yuliyang")
    }

    private val user by lazy {
        User()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)
        mBinding.mapData = mapData
        mBinding.user = user
        mBinding.testButton.setOnClickListener {
            val intent = Intent(this, RemoteService::class.java).apply {
                putExtra("name", "yuliyang")
            }
            bindService(intent, object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    println("onServiceConnected")
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    println("onServiceDisconnected")
                }
            }, BIND_AUTO_CREATE)


            //data->view的绑定
            mapData.put("name", "mapData changed")
//            user.name = "haha changed"
//            mBinding.testTextView.text = "haha testView changed"
//            println(user.name)

//            mBinding.testViewStub.setOnInflateListener { stub, inflated ->
//                println("inflated")
//                inflated.innerViewStub.text = "changed"
//            }
//            //测试一下ViewStub和DataBinding结合的使用
//            mBinding.testViewStub.viewStub?.inflate()
        }

        testMaterialShapeDrawable()
    }

    private fun testMaterialShapeDrawable() {
        val shapeDrawable = MaterialShapeDrawable()
        shapeDrawable.setCornerSize(12f)
        val stateList = arrayOf(
            intArrayOf(android.R.attr.state_pressed),
            intArrayOf()
        )
        shapeDrawable.fillColor = ColorStateList(
            stateList,
            intArrayOf(
                ResourcesCompat.getColor(resources, R.color.purple_200, theme),
                ResourcesCompat.getColor(resources, R.color.black, theme)
            )
        )
        shapeView.background = shapeDrawable
    }

    override fun onBackPressed() {
    }

    override fun onDestroy() {
        println("onDestroy")
        super.onDestroy()
        startActivity(Intent(this, DataBindingActivity::class.java))
    }
}