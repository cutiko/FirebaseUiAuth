package cl.cutiko.space


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cutiko.space.widgets.*

const val EXPLOSION = "cl.cutiko.space.widgets.action.EXPLOSION"

class CoordinatorFragment : Fragment() {

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
        if (activity == null) return
        activity!!.findViewById<ScrollBackground>(R.id.scrollView).startScroll()
        activity!!.findViewById<OverlayView>(R.id.overlayV).fadIn { showLogin() }
    }

    private fun showLogin() {
        if (activity == null) return
        activity!!.findViewById<ExplosionView>(R.id.explosionV).explode()
        activity!!.findViewById<LoginButton>(R.id.helmetBtn).fadeIn()
        LocalBroadcastManager.getInstance(context!!).sendBroadcast(Intent(EXPLOSION))
    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<RootViewGroup>(R.id.rootVg)?.setImmersive()
    }

}