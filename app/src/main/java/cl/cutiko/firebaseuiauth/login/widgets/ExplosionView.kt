package cl.cutiko.firebaseuiauth.login.widgets

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import cl.cutiko.firebaseuiauth.R

class ExplosionView(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {

    init {
        setImageDrawable(
            ContextCompat.getDrawable(context!!, R.drawable.animation_explosion)
        )
    }

    fun explode() {
        visibility = View.VISIBLE
        val animation : AnimationDrawable = drawable as AnimationDrawable
        animation.start()
    }

}