package cl.cutiko.firebaseuiauth.login.widgets

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.View

class ExplosionView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    fun explode() {
        visibility = View.VISIBLE
        val animation : AnimationDrawable = background as AnimationDrawable
        animation.start()
    }

}