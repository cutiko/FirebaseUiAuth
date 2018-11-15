package cl.cutiko.firebaseuiauth

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        scrollView.post {
            val animation = ObjectAnimator.ofInt(scrollView, "scrollY",  spaceIv.bottom).setDuration(4200)
            animation.startDelay = 300
            animation.start()
        }
    }
}
