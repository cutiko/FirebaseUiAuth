package cl.cutiko.dance.body.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cutiko.dance.R

class PermissionFragment : IntroFragment() {

    companion object {
        fun newInstance() : PermissionFragment {
            return PermissionFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LayoutInflater.from(view.context).inflate(R.layout.content_fragment_permission, view as ViewGroup, true)
    }

    override val getText: Int
        get() = R.string.intro_permissions
    override val getUndraw: Int
        get() = R.drawable.undraw_android
}