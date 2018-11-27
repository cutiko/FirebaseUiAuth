package cl.cutiko.firebaseuiauth.login


import android.animation.Animator
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cl.cutiko.firebaseuiauth.R
import cl.cutiko.firebaseuiauth.login.widgets.ScrollBackground
import kotlinx.android.synthetic.main.layout_auth_login.*

class LoginFragment : Fragment() {

    private lateinit var welcomeTv : TextView
    private lateinit var scrollingBg : ScrollBackground

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.visibility = View.GONE

        val player = MediaPlayer.create(context, R.raw.menu_audio)
        player.start()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity == null) return
        scrollingBg = activity!!.findViewById(R.id.scrollView)
        welcomeTv = activity!!.welcomeTv
        writeTitle(0, 1300)
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

    fun scrollBackground() {
        scrollingBg.startScroll()
        startOverlay()
    }

    fun startOverlay() {
        activity!!.findViewById<View>(R.id.overlayV).animate().setStartDelay(2800).setDuration(400).alpha(1F).setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationStart(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator) {
                explosion()
                showLoginBtn()
            }
        }).start()
    }

    fun explosion() {
        val view = activity!!.findViewById<View>(R.id.explosionV)
        view.visibility = View.VISIBLE
        val animation : AnimationDrawable = view.background as AnimationDrawable
        animation.start()
    }

    fun showLoginBtn() {
        val view = activity!!.findViewById<View>(R.id.helmetBtn)
        view.animate().setStartDelay(500).alpha(1F).setDuration(600).start()
        val player = MediaPlayer.create(context, R.raw.teleport)
        player.start()
    }

}
