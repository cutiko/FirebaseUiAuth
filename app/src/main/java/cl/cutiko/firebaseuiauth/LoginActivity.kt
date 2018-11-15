package cl.cutiko.firebaseuiauth

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        writeTitle(0)
        scrollView.setOnTouchListener { view, event -> true }
        rootVg.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        loginBtn.setOnClickListener {
            Toast.makeText(it.context, "here", Toast.LENGTH_SHORT).show()
        }
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
        overlayV.animate().setStartDelay(2800).setDuration(400).alpha(1F).start()
    }

    fun writeTitle(position: Int) {
        val text = "Welcome Traveller"
        Handler().postDelayed({
            val current = welcomeTv.text
            val letter = text.get(position)
            welcomeTv.text = "$current$letter"
            if (text.length == position + 1) {
                scrollBackground()
                welcomeTv.animate().setStartDelay(800).translationY(-500F).setDuration(600).start()
            } else {
                writeTitle(position + 1)
            }
        }, 250)
    }
}
