package cl.cutiko.firebaseuiauth

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        /*val animation = ObjectAnimator.ofInt(scrollView, "scrollY", spaceIv.bottom)
        animation.startDelay = 200
        animation.setDuration(3200)
        animation.start()*/


        scrollView.post {
            val animation = ObjectAnimator.ofInt(scrollView, "scrollY",  spaceIv.bottom).setDuration(4200)
            animation.startDelay = 300
            animation.start()
        }
    }
}
