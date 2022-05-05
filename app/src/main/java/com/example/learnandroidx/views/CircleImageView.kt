package com.example.learnandroidx.views

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.example.learnandroidx.R


/**
 * @author    yiliyang
 * @date      20-12-2 下午2:02
 * @version   1.0
 * @since     1.0
 */
class CircleImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    init {
        //第一步
//        clipToOutline = true
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed) {
//            outlineProvider = object : ViewOutlineProvider() {
//                override fun getOutline(view: View, outline: Outline) {
//                    outline.setOval(Rect(0, 0, width, height))
//                }
//            }
        }
    }

    val paint = Paint(Paint.FILTER_BITMAP_FLAG).apply {
        isAntiAlias = true
        isDither = true
    }

    private fun getBitmap(): Bitmap {
        //需要裁剪的图片
        val bitmapResource = BitmapFactory.decodeResource(resources, R.drawable.src)
        //蒙版
        val resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        resultBitmap.setHasAlpha(true)
        val canvasOut = Canvas(resultBitmap)
        //裁剪为圆形
        canvasOut.drawCircle(width / 2f, width / 2f, width / 2f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        //绘制src
        canvasOut.drawBitmap(bitmapResource, null, Rect(0, 0, width, height), paint)
        canvasOut.setBitmap(null)
        paint.xfermode = null
        return resultBitmap
    }

    private fun getBitmap2(): Bitmap {
        //需要裁剪的图片
        val bitmapResource = BitmapFactory.decodeResource(resources, R.drawable.src)
        //蒙版
        val resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        resultBitmap.setHasAlpha(true)
        val canvasOut = Canvas(resultBitmap)
        //绘制src
        canvasOut.drawBitmap(bitmapResource, null, Rect(0, 0, width, height), paint)
        val maskPath = Path().apply {
            //裁剪为圆形
            addCircle(width / 2f, width / 2f, width / 2f, Path.Direction.CW)
            fillType = Path.FillType.INVERSE_WINDING
        }
        //如果不加Clear，那么会有黑色背景
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        canvasOut.drawPath(maskPath, paint)
        canvasOut.setBitmap(null)
        paint.xfermode = null
        return resultBitmap
    }

    private fun getBitmap3(): Bitmap {
        //需要裁剪的图片
        val bitmapResource = BitmapFactory.decodeResource(resources, R.drawable.src)
        //蒙版
        val resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
//        resultBitmap.setHasAlpha(true)
        val canvasOut = Canvas(resultBitmap)
        //绘制src
        val shader: Shader = BitmapShader(bitmapResource, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = shader
//        val corners = Path()
//        corners.addCircle(width / 2f, width / 2f, width / 2f, Path.Direction.CW)
        canvasOut.drawCircle(width / 2f, width / 2f, width / 2f, paint)
        canvasOut.setBitmap(null)
        return resultBitmap
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        canvas.drawBitmap(getBitmap3(), null, Rect(0, 0, width, height), paint)
        val bitmapResource = BitmapFactory.decodeResource(resources, R.drawable.src)
        val shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.getPaint()
            .setShader(BitmapShader(bitmapResource, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT));
        shapeDrawable.setBounds(0, 0, width, height)
//        canvas.drawRect(0.toFloat(), 0f, width.toFloat(), height.toFloat(), paint);
//        canvas.drawBitmap(bitmapResource, null, Rect(0, 0, width, height), paint)
        shapeDrawable.draw(canvas);
    }
}