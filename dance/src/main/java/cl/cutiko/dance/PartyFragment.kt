package cl.cutiko.dance

class PartyFragment : IntroFragment() {

    companion object {
        fun newInstance() : PartyFragment {
            return PartyFragment()
        }
    }

    override val getText: Int
        get() = R.string.intro_party

    override val getUndraw: Int
        get() = R.drawable.undraw_fun

}