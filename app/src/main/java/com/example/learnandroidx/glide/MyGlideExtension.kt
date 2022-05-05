package com.example.learnandroidx.glide

import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.annotation.GlideType
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestOptions
import com.example.learnandroidx.glide.GlideOptions.decodeTypeOf


/**
 * @author    yiliyang
 * @date      21-2-1 下午2:23
 * @version   1.0
 * @since     1.0
 */
@GlideExtension
object MyGlideExtension {

    @GlideOption
    @JvmStatic
    fun miniThumb(options: BaseRequestOptions<*>, size: Int): BaseRequestOptions<*> {
        return options
            .centerCrop()
            .override(size)
    }

    private val DECODE_TYPE_GIF: RequestOptions = decodeTypeOf(GifDrawable::class.java).lock()

//    @JvmStatic
//    @GlideType(GifDrawable::class)
//    fun asGif(requestBuilder: RequestBuilder<GifDrawable>): RequestBuilder<GifDrawable> {
//        return requestBuilder
//            .transition(DrawableTransitionOptions())
//            .apply(DECODE_TYPE_GIF)
//    }
}