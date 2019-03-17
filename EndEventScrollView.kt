package com.jino.documentsearch

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Handler
import android.util.AttributeSet
import android.widget.ScrollView

class EndEventScrollView(context: Context?, attrs: AttributeSet?) : ScrollView(context, attrs) {

    private lateinit var rect: Rect


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        checkIsLocationAtFooter()
    }

    fun checkIsLocationAtFooter() {
        if (!::rect.isInitialized) {
            rect = Rect()
            getLocalVisibleRect(rect)
            return
        }
        val oldBottom = rect.bottom
        getLocalVisibleRect(rect)
        val height = measuredHeight
        val v = getChildAt(0)
        if (oldBottom > 0 && height > 0) {
            if (oldBottom != rect.bottom && rect.bottom == v.measuredHeight) {
                if (handler != null) {
                    handler!!.sendEmptyMessage(0)
                }
            }
        }
    }
}