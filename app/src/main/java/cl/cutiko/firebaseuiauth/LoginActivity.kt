package cl.cutiko.firebaseuiauth

import android.animation.Animator
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        rootVg.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION


        val player = MediaPlayer.create(this, R.raw.menu_audio)
        player.start()


        writeTitle(0, 1300)
        scrollView.setOnTouchListener { view, event -> true }

        loginBtn.setOnClickListener {
            //TODO log the user
        }
    }

    fun showLoginBtn() {
        helmetBtn.animate().setStartDelay(500).alpha(1F).setDuration(600).start()
        val player = MediaPlayer.create(this, R.raw.teleport)
        player.start()
    }

    fun explosion() {
        explosionV.visibility = View.VISIBLE
        val animation : AnimationDrawable = explosionV.background as AnimationDrawable
        animation.start()
    }

    fun scrollBackground() {
        scrollView.post {
            val animation = ObjectAnimator.ofInt(scrollView, "scrollY",  spaceIv.bottom).setDuration(4000)
            animation.startDelay = 350
            animation.start()
        }
        startOverlay()
    }

    fun startOverlay() {
        overlayV.animate().setStartDelay(2800).setDuration(400).alpha(1F).setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationStart(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator) {
                explosion()
                showLoginBtn()
            }
        }).start()
    }

    fun writeTitle(position: Int, delay: Long) {
        val text = "Welcome Traveller"
        Handler().postDelayed({
            val current = welcomeTv.text
            val letter = text.get(position)
            welcomeTv.text = "$current$letter"
            if (text.length == position + 1) {
                scrollBackground()
                welcomeTv.animate().setStartDelay(800).translationY(-500F).setDuration(600).start()
            } else {
                writeTitle(position + 1, 250)
            }
        }, delay)
    }
}
