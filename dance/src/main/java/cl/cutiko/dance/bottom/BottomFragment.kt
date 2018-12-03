package cl.cutiko.dance.bottom


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cutiko.dance.R
import cl.cutiko.dance.adapters.INTRO_SLIDES

class BottomFragment : Fragment(), ViewPager.OnPageChangeListener {

    companion object {
        private const val FADE_IN = 1F
        private const val FADE_OUT = 0F
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.findViewById<ViewPager>(R.id.pagerFragment).addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(p0: Int) {}

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

    override fun onPageSelected(page: Int) {
        if (INTRO_SLIDES == page) {
            fade(FADE_OUT)
            return
        }
        if (view?.alpha != FADE_IN) {
            fade(FADE_IN)
        }
    }


    private fun fade(alpha : Float) {
        view?.animate()?.alpha(alpha)?.setDuration(200)?.start()
    }

}