package cl.cutiko.firebaseuiauth.login


import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cutiko.firebaseuiauth.R
import cl.cutiko.firebaseuiauth.login.widgets.*

class CoordinatorFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val player = MediaPlayer.create(context, R.raw.menu_audio)
        player.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = View(context)
        root.visibility = View.GONE
        return root
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
        activity!!.findViewById<LoginButton>(R.id.helmetBtn).fadeIn()
    }

}
