package cl.cutiko.firebaseuiauth.login.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import cl.cutiko.firebaseuiauth.R

class LoginButton(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.widget_login_button_content, this, true)
    }

}