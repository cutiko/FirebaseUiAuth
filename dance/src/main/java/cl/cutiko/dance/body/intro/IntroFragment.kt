package cl.cutiko.dance.body.intro

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cutiko.dance.R
import kotlinx.android.synthetic.main.fragment_intro.*

abstract class IntroFragment : Fragment() {

    @get:StringRes
    protected abstract val getText: Int

    @get:DrawableRes
    protected abstract val getUndraw : Int

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        descriptionTv.setText(getText)
        if (context != null) {
            val drawable = ContextCompat.getDrawable(context!!, getUndraw)
            unDrawIv.setImageDrawable(drawable)
        }

    }

}