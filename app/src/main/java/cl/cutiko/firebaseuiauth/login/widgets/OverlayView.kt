package cl.cutiko.firebaseuiauth.login.widgets

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.View

class OverlayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    fun fadIn(callback: () -> Unit) {
        animate().setStartDelay(2800).setDuration(400).alpha(1F).setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationStart(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator) {
                callback()
            }
        }).start()
    }

}