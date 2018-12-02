package cl.cutiko.dance.body.intro

import cl.cutiko.dance.R

class MusicFragment : IntroFragment() {

    companion object {
        fun newInstance() : MusicFragment {
            return MusicFragment()
        }
    }

    override val getText: Int
        get() = R.string.intro_music

    override val getUndraw: Int
        get() = R.drawable.undraw_music
}