package cl.cutiko.firebaseuiauth.login


import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast

import cl.cutiko.firebaseuiauth.R
import cl.cutiko.firebaseuiauth.login.service.PlayerService

class MusicFragment : Fragment(), ServiceConnection {

    private lateinit var playerService: PlayerService

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val intent = Intent(context, PlayerService::class.java)
        val activity = context as AppCompatActivity
        activity.bindService(intent, this, Context.BIND_AUTO_CREATE)
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        val binder : PlayerService.LocalBinder = service as PlayerService.LocalBinder
        playerService = binder.getPlayerService()
        if (context != null) {
            playerService.playMusic(context!!)
        }


    }

    override fun onServiceDisconnected(name: ComponentName?) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cb = view.findViewById<CheckBox>(R.id.musicCb)
        cb.setOnCheckedChangeListener { _, isChecked -> Toast.makeText(context, "VAL: $isChecked", Toast.LENGTH_LONG).show() }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }


}
