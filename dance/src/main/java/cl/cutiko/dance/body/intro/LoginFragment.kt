package cl.cutiko.dance.body.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cutiko.dance.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val googleBtn = requireActivity().findViewById<View>(R.id.googleBtn)
        googleTv.setOnClickListener { googleBtn.performClick() }
        val emailBtn = requireActivity().findViewById<View>(R.id.emailBtn)
        emailTv.setOnClickListener { emailBtn.performClick() }
    }

}