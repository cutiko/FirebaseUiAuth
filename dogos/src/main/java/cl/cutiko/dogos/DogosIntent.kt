package cl.cutiko.dogos

import android.content.Intent
import com.firebase.ui.auth.AuthMethodPickerLayout
import com.firebase.ui.auth.AuthUI

const val RC_DOGOS_AUTH = 3

class DogosIntent {

    fun get() : Intent {
        val providers = mutableListOf<AuthUI.IdpConfig>()
        providers.add(AuthUI.IdpConfig.GoogleBuilder().build())

        val layout = AuthMethodPickerLayout
            .Builder(R.layout.layout_auth_dogos)
            .setGoogleButtonId(R.id.googleBtn)
            .build()
        return AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setAuthMethodPickerLayout(layout)
            .setAlwaysShowSignInMethodScreen(true)
            .setTheme(R.style.AppTheme_NoActionBar)
            .setIsSmartLockEnabled(false)
            .build()
    }

}