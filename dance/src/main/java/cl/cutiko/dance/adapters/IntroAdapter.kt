package cl.cutiko.dance.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import cl.cutiko.dance.body.MusicFragment
import cl.cutiko.dance.body.PartyFragment
import cl.cutiko.dance.body.PermissionFragment

class IntroAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MusicFragment.newInstance()
            1 -> PartyFragment.newInstance()
            else -> PermissionFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}