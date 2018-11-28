package cl.cutiko.firebaseuiauth.login


import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cl.cutiko.firebaseuiauth.R
import cl.cutiko.firebaseuiauth.login.widgets.ExplosionView
import cl.cutiko.firebaseuiauth.login.widgets.OverlayView
import cl.cutiko.firebaseuiauth.login.widgets.ScrollBackground
import cl.cutiko.firebaseuiauth.login.widgets.WelcomeView

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
        val welcomeView = activity!!.findViewById<WelcomeView>(R.id.welcomeTv)
        welcomeView.setCallback { scrollBackground() }
        welcomeView.welcomeUser()
    }

    private fun scrollBackground() {
        activity!!.findViewById<ScrollBackground>(R.id.scrollView).startScroll()
        activity!!.findViewById<OverlayView>(R.id.overlayV).fadIn { showLogin() }
    }

    private fun showLogin() {
        activity!!.findViewById<ExplosionView>(R.id.explosionV).explode()
        showLoginBtn()
    }

    private fun showLoginBtn() {
        val view = activity!!.findViewById<View>(R.id.helmetBtn)
        view.animate().setStartDelay(500).alpha(1F).setDuration(600).start()
        val player = MediaPlayer.create(context, R.raw.teleport)
        player.start()
    }

}
