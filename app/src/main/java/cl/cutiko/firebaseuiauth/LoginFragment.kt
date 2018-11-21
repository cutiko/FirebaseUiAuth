package cl.cutiko.firebaseuiauth


import android.animation.Animator
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*

class LoginFragment : Fragment() {

    private lateinit var welcomeTv : TextView
    private lateinit var scrollV : ScrollView

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
        scrollV = activity!!.findViewById(R.id.scrollView)
        scrollV.setOnTouchListener { view, event -> true }
        val rootView = activity!!.findViewById<ViewGroup>(R.id.rootVg)
        rootView?.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

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
        scrollV.post {
            val animation = ObjectAnimator.ofInt(scrollV, "scrollY",  scrollV.getChildAt(0).bottom).setDuration(4000)
            animation.startDelay = 350
            animation.start()
        }
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
