package cl.cutiko.dance.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import cl.cutiko.dance.body.intro.LoginFragment
import cl.cutiko.dance.body.intro.MusicFragment
import cl.cutiko.dance.body.intro.PartyFragment
import cl.cutiko.dance.body.intro.PermissionFragment

const val INTRO_SLIDES = 4

class IntroAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MusicFragment.newInstance()
            1 -> PartyFragment.newInstance()
            2 -> PermissionFragment.newInstance()
            else -> LoginFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return INTRO_SLIDES
    }
}