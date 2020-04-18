package cl.cutiko.space.widgets

import android.animation.ObjectAnimator
import android.content.Context
import androidx.core.content.ContextCompat
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import cl.cutiko.space.R

class ScrollBackground(context: Context?, attrs: AttributeSet?) : ScrollView(context, attrs) {

    init {
        setOnTouchListener { view, event -> true }
        val imageView = ImageView(context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        val image = ContextCompat.getDrawable(context!!, R.drawable.bg_space)
        imageView.setImageDrawable(image)
        addView(imageView)
    }

    fun startScroll() {
        post {
            val animation = ObjectAnimator.ofInt(this, "scrollY", getChildAt(0).bottom).setDuration(4000)
            animation.startDelay = 350
            animation.start()
        }
    }

}