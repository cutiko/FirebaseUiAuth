package cl.cutiko.firebaseuiauth.login.widgets

import android.content.Context
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import cl.cutiko.firebaseuiauth.R

class LoginButton(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.widget_login_button_content, this, true)
    }

    fun fadeIn() {
        animate().setStartDelay(500).alpha(1F).setDuration(600).start()
        val player = MediaPlayer.create(context, R.raw.teleport)
        player.start()
    }

}