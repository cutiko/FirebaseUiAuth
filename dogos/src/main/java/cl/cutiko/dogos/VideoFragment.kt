package cl.cutiko.dogos

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView

class VideoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view as VideoView
        val uri = Uri.parse("android.resource://${context!!.getPackageName()}/raw/dogs")
        view.setVideoURI(uri)
        view.setOnPreparedListener { it.isLooping = true }
        view.start()
    }

    override fun onResume() {
        super.onResume()
        val video = view as VideoView
        video.start()
    }

    override fun onPause() {
        val video = view as VideoView
        video.pause()
        super.onPause()
    }


    override fun onStop() {
        val video = view as VideoView
        video.stopPlayback()
        super.onStop()
    }
}