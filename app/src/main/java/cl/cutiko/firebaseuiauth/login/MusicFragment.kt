package cl.cutiko.firebaseuiauth.login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast

import cl.cutiko.firebaseuiauth.R

class MusicFragment : Fragment() {

    //PlayerService
    //https://github.com/cutiko/Soliloquio/blob/master/app/src/main/java/cl/cutiko/soliloquio/background/PlayerService.java

    //Fragment binding
    //https://github.com/cutiko/Soliloquio/blob/master/app/src/main/java/cl/cutiko/soliloquio/views/main/bottomsheet/BottomSheetFragment.java

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

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
