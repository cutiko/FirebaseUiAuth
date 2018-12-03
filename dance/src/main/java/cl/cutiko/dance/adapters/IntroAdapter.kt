package cl.cutiko.dance.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import cl.cutiko.dance.body.intro.MusicFragment
import cl.cutiko.dance.body.intro.PartyFragment
import cl.cutiko.dance.body.intro.PermissionFragment

const val INTRO_SLIDES = 4

class IntroAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MusicFragment.newInstance()
            1 -> PartyFragment.newInstance()
            else -> PermissionFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return INTRO_SLIDES
    }
}