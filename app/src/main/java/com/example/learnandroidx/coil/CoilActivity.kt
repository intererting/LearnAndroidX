package com.example.learnandroidx.coil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_coil.*
import kotlinx.coroutines.coroutineScope


const val URL =
    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201409%2F30%2F20140930150745_WNiLZ.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1621411686&t=80bc97df95610238b1b605d71d33f8da"

/**
 * @author    yiliyang
 * @date      21-4-19 下午4:02
 * @version   1.0
 * @since     1.0
 */
class CoilActivity : AppCompatActivity(R.layout.activity_coil) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestLayout.setOnClickListener {
            requestLayout.requestLayout()
        }

        val imageLoader = ImageLoader.Builder(this)
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()

        lifecycleScope.launchWhenResumed {
//            imageView.load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201409%2F30%2F20140930150745_WNiLZ.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1621411686&t=80bc97df95610238b1b605d71d33f8da")
//            {
//                crossfade(true)
//            }

            // enqueue，异步加载
            val request = ImageRequest.Builder(this@CoilActivity)
                .data(URL)
                .allowHardware(false)
                .target(imageView)
                .build()
            val disposable = imageLoader.enqueue(request)
// execute
//            val request = ImageRequest.Builder(context)
//                .data("https://www.example.com/image.jpg")
//                .build()
//            val result = imageLoader.execute(request)

        }
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
        Handler(Looper.getMainLooper()).postDelayed({
            requestLayout.requestLayout()
            println("after requestLayout")
        }, 3000)
    }
}