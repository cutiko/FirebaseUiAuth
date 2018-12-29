package cl.cutiko.firebaseuiauth.menu

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cl.cutiko.dance.RC_DANCE_AUTH
import cl.cutiko.dogos.RC_DOGOS_AUTH
import cl.cutiko.firebaseuiauth.R
import cl.cutiko.space.RC_SPACE_AUTH
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logout()
    }

    fun showResult(resultCode: Int, reqCode: Int, response: IdpResponse?) {
        var demo = ""
        if (RC_DANCE_AUTH == reqCode) {
            demo = getString(R.string.dance)
        }
        if (RC_DOGOS_AUTH == reqCode) {
            demo = getString(R.string.dogos)
        }
        if (RC_SPACE_AUTH == reqCode) {
            demo = getString(R.string.space)
        }
        if (Activity.RESULT_OK == resultCode) {
            logout()
            setText(demo, getString(R.string.logged))
            return
        } else {
            var result = ""
            if (response == null) {
                result = getString(R.string.cancelled)
                setText(demo, result)
                return
            }
            if (response.getError()?.getErrorCode() == ErrorCodes.NO_NETWORK) {
                result = getString(R.string.no_internet)
                setText(demo, result)
                return
            }

            result = getString(R.string.unknown)
            setText(demo, result)
        }

    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()
    }

    private fun setText(demo : String, result: String) {
        val text = getString(R.string.result, demo, result)
        val textView = view as TextView
        textView.text = text
    }
}