package com.example.learnandroidx

import android.graphics.*
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.decodeBitmap
import androidx.core.graphics.decodeDrawable
import kotlinx.android.synthetic.main.activity_image_decoder.*

/**
 * @author    yiliyang
 * @date      21-1-22 上午10:17
 * @version   1.0
 * @since     1.0
 */
@RequiresApi(Build.VERSION_CODES.P)
class ImageDecoderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_decoder)
        imageDecoder.setOnClickListener {
            val imageDecoder = ImageDecoder.createSource(resources, R.drawable.src)
            val result = imageDecoder.decodeBitmap { info, source ->
                //设置解码的大小
//                this.setTargetSize(300, 300)
                //设置为原来的1/n
//                this.setTargetSampleSize(4)
//                this.crop = Rect(0, 0, 300, 200)
                this.postProcessor = PostProcessor {
                    val path = Path();
                    path.fillType = Path.FillType.INVERSE_EVEN_ODD;
                    val width = it.width
                    val height = it.height
                    path.addRoundRect(
                        0f, 0f, width * 1f,
                        height * 1f, 20f, 20f, Path.Direction.CW
                    )
                    val paint = Paint()
                    paint.isAntiAlias = true
                    paint.color = Color.TRANSPARENT
                    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
                    it.drawPath(path, paint)
                    PixelFormat.TRANSLUCENT
                }
                println("info.size.width  ${info.size.width}  info.size.height  ${info.size.height}")
            }
            image.setImageBitmap(result)
        }
    }
}