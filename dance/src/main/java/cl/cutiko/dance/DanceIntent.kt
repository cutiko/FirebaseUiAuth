package cl.cutiko.dance

import android.content.Intent
import com.firebase.ui.auth.AuthMethodPickerLayout
import com.firebase.ui.auth.AuthUI

const val RC_DANCE_AUTH = 2

class DanceIntent {

    fun get() : Intent {
        val providers = mutableListOf<AuthUI.IdpConfig>()
        providers.add(AuthUI.IdpConfig.EmailBuilder().build())
        providers.add(AuthUI.IdpConfig.GoogleBuilder().build())

        val layout = AuthMethodPickerLayout
            .Builder(R.layout.layout_auth_dance)
            .setGoogleButtonId(R.id.googleBtn)
            .setEmailButtonId(R.id.emailBtn)
            .build()
        return AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setAuthMethodPickerLayout(layout)
            .setTheme(R.style.FullscreenTheme_White)
            .setIsSmartLockEnabled(false)
            .build()
    }

}