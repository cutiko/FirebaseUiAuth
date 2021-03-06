package cl.cutiko.space.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import cl.cutiko.space.R

class LoginButton(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.widget_login_button_content, this, true)
    }

    fun fadeIn() {
        animate().setStartDelay(500).alpha(1F).setDuration(600).start()
    }

}