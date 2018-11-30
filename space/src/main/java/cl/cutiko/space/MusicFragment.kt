package cl.cutiko.space


import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import cl.cutiko.space.service.PlayerService
import cl.cutiko.space.widgets.EXPLOSION

class MusicFragment : Fragment(), ServiceConnection, CompoundButton.OnCheckedChangeListener {

    private lateinit var playerService: PlayerService
    private var isServiceRunning = false
    private lateinit var broadcastReceiver: BroadcastReceiver

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
            broadcastReceiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    when {
                        EXPLOSION.equals(intent?.action) && isServiceRunning -> playerService.explosion(context)
                    }
                }
            }
            val filter = IntentFilter(EXPLOSION)
            LocalBroadcastManager.getInstance(context!!).registerReceiver(broadcastReceiver, filter)
        }
        isServiceRunning = true
    }

    override fun onServiceDisconnected(name: ComponentName?) { isServiceRunning = false }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cb = view.findViewById<CheckBox>(R.id.musicCb)
        cb.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (!isServiceRunning) return
        if (isChecked) playerService.resume() else playerService.pause()
    }

    override fun onResume() {
        super.onResume()
        if (isServiceRunning) playerService.resume()
    }

    override fun onPause() {
        super.onPause()
        if (isServiceRunning) playerService.pause()
    }

    override fun onStop() {
        if (context != null) LocalBroadcastManager.getInstance(context!!).unregisterReceiver(broadcastReceiver)
        super.onStop()
    }
}
