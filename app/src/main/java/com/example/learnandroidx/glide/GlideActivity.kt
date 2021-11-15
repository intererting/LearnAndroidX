package com.example.learnandroidx.glide

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnandroidx.fragment.FragmentFactoryActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_glide.*

/**
 * @author    yiliyang
 * @date      21-2-1 下午2:05
 * @version   1.0
 * @since     1.0
 */
class GlideActivity : AppCompatActivity(R.layout.activity_glide) {


    override fun onStop() {
        GlideApp.with(this).pauseAllRequests()
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        startService(Intent(this, GlideService::class.java))

        remove.setOnClickListener {
//            container.removeView(imageView)
            startActivity(Intent(this, FragmentFactoryActivity::class.java))
        }

        var target = GlideApp.with(this)
            .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3630447355,2094032427&fm=26&gp=0.jpg")
//            .miniThumb(100)
//            .transform(CircleCrop())
//            .thumbnail(.2f)
            .override(100, 100)
            .into(imageView)
//            .into(object : CustomTarget<Drawable>() {
//                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
//                    imageView.setImageDrawable(resource)
//                }
//
//                override fun onLoadCleared(placeholder: Drawable?) {
//                    println("s")
//                }
//            })

//        GlobalScope.launch {
//            delay(4000)
//            GlideApp.with(imageView).clear(target)
//        }

//            .into(imageView)


//        Thread({
//            GlideApp.with(this)
//                .asBitmap()
//                .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3630447355,2094032427&fm=26&gp=0.jpg")
//                .into(object : Target<Bitmap> {
//                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                        println("onResourceReady")
//                    }
//
//                    override fun onStart() {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onStop() {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onDestroy() {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onLoadStarted(placeholder: Drawable?) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onLoadFailed(errorDrawable: Drawable?) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onLoadCleared(placeholder: Drawable?) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun getSize(cb: SizeReadyCallback) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun removeCallback(cb: SizeReadyCallback) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun setRequest(request: Request?) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun getRequest(): Request? {
//                        TODO("Not yet implemented")
//                    }
//
//                })
//        }).start()
    }
}