package com.example.learnandroidx.glide

import android.app.Service
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.IBinder
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition

/**
 * @author    yiliyang
 * @date      21-2-1 下午4:42
 * @version   1.0
 * @since     1.0
 */
class GlideService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        GlideApp.with(this)
            .asBitmap()
            .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3630447355,2094032427&fm=26&gp=0.jpg")
            .into(object : Target<Bitmap> {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    println("onResourceReady")
                }

                override fun onStart() {
                    TODO("Not yet implemented")
                }

                override fun onStop() {
                    TODO("Not yet implemented")
                }

                override fun onDestroy() {
                    TODO("Not yet implemented")
                }

                override fun onLoadStarted(placeholder: Drawable?) {
                    TODO("Not yet implemented")
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    TODO("Not yet implemented")
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    TODO("Not yet implemented")
                }

                override fun getSize(cb: SizeReadyCallback) {
                    TODO("Not yet implemented")
                }

                override fun removeCallback(cb: SizeReadyCallback) {
                    TODO("Not yet implemented")
                }

                override fun setRequest(request: Request?) {
                    TODO("Not yet implemented")
                }

                override fun getRequest(): Request? {
                    TODO("Not yet implemented")
                }

            })
    }
}