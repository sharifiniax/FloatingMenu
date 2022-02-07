package com.sharifiniax.floatingmenu

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import java.util.*
import kotlin.math.abs


class OnSwipeTouchListener(
    ctx: Context?,
    private val swipeInterface: ISwipe,

    ) : OnTouchListener {

    private var view: View? = null
    private  var start: FloatingMenu.Sticky
    private  var gestureDetector: GestureDetector


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        view = v
        swipeInterface.onTouch()
        return gestureDetector.onTouchEvent(event)
    }

    init {
        val isLeftToRight =
            TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_LTR
        start = if (isLeftToRight) {
            FloatingMenu.Sticky.Left
        } else {
            FloatingMenu.Sticky.Right
        }
        gestureDetector = GestureDetector(ctx, GestureListener())

    }

    companion object {
        private const val SWIPE_THRESHOLD = 60
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }

    private inner class GestureListener : SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {

            return true
        }



        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {



            val result = false
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (abs(diffX) > abs(diffY)) {
                    if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLeft()
                        }
                    }
                } else {
                    // onTouch(e);
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return result
        }
    }

    fun onSwipeRight() {
        swipeInterface.onSwipeRight()
    }

    fun onSwipeLeft() {
        swipeInterface.onSwipeLeft()

    }


}
