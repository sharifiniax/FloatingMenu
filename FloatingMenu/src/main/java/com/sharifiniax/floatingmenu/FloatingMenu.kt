package com.sharifiniax.floatingmenu


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*


@SuppressLint("ClickableViewAccessibility")
class FloatingMenu(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs),
    ISwipe {


    private lateinit var sticky: Sticky
    private var show: Boolean = true
    private var shape: GradientDrawable = GradientDrawable()
    private var countDownTimer: CountDownTimer

    init {

        shape.setColor(Color.GRAY)
        shape.cornerRadius = 50F
        countDownTimer= object : CountDownTimer(3000, 4000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                hide()
            }
        }
    }

    override fun setOnTouchListener(l: OnTouchListener?) {

        countDownTimer.cancel()
        countDownTimer.start()
        super.setOnTouchListener(l)
    }

    enum class Sticky {
        Right,
        Left
    }


    private fun autoHide(timer: Long) {
        val mainHandler = Handler(Looper.getMainLooper())
        val myRunnable = Runnable {
            sticky = getStickyState()

                hide(400)


        }
        mainHandler.postDelayed(myRunnable, timer)
    }

    private fun hide(time: Long = 400L) {

        if (sticky == Sticky.Left) {

            if (show) {

                this.animate().apply {
                    duration = time
                    alpha(0.2F)
                    val value = (width.toFloat().times(-0.9F))
                    translationX(value)
                }.start()

                show = !show
            }
        } else {
            if (show) {

                this.animate().apply {
                    duration = time
                    alpha(0.2F)
                    val value = (width.toFloat().times(0.9F))
                    translationX(value)
                }.start()

                show = !show
            }
        }

    }

    private fun show() {
        if (sticky == Sticky.Left) {
            if (!show) {
                this.animate().apply {
                    duration = 400L
                    alpha(1F)
                    val value = (width.toFloat().times(-0.1F))
                    translationX(value)
                }.start()
                countDownTimer.start()
                show = !show
            }

        } else {
            if (!show) {
                this.animate().apply {
                    duration = 400L
                    alpha(1F)
                    val value = (width.toFloat().times(0.1F))
                    translationX(value)
                }.start()
               countDownTimer.start()
                show = !show
            }
        }

    }



    private fun getStickyState(): Sticky {
        val isLeftToRight =
            TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_LTR
        val start = if (isLeftToRight) {
            Sticky.Left
        } else {
            Sticky.Right
        }

        val param = this.layoutParams as LayoutParams
        sticky = if (start == Sticky.Left) {
            if (param.leftToLeft == 0 || param.startToStart == 0) {
                Sticky.Left
            } else {
                Sticky.Right
            }
        } else {
            if (param.rightToRight == 0 || param.startToStart == 0) {
                Sticky.Right
            } else {
                Sticky.Left
            }
        }
        return sticky

    }

    override fun onSwipeLeft() {
        sticky = getStickyState()
        if (sticky == Sticky.Right) {
            show()
        } else {
            hide()
        }
    }

    override fun onSwipeRight() {
        sticky = getStickyState()
        if (sticky == Sticky.Right) {
            hide()
        } else {
            show()
        }
    }

    override fun onTouch() {
       countDownTimer.cancel()
       countDownTimer.start()
    }



    init {
        this.shape = GradientDrawable()
        shape.cornerRadius = 50F
        shape.setColor(Color.GRAY)
        this.background = shape

        this.setOnTouchListener(OnSwipeTouchListener(context, this))
        autoHide(400)
    }


}