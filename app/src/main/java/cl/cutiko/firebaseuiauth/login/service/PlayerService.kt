package cl.cutiko.firebaseuiauth.login.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import cl.cutiko.firebaseuiauth.R


class PlayerService : Service() {

    private val binder = LocalBinder()
    private lateinit var mediaPlayer : MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun playMusic(context: Context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.menu_audio)
        mediaPlayer.start()
    }

    fun pause() {
        if (mediaPlayer.isPlaying) mediaPlayer.pause()
    }

    fun resume() {
        if (!mediaPlayer.isPlaying) mediaPlayer.start()
    }

    class LocalBinder : Binder() {
        fun getPlayerService() : PlayerService {
            return PlayerService()
        }
    }
}
