package cl.cutiko.space

import android.content.Intent
import com.firebase.ui.auth.AuthMethodPickerLayout
import com.firebase.ui.auth.AuthUI

const val RC_AUTH_SPACE = 1

class SpaceIntent {

    fun get() : Intent {
        val providers = mutableListOf<AuthUI.IdpConfig>()
        providers.add(AuthUI.IdpConfig.GoogleBuilder().build())

        val layout = AuthMethodPickerLayout
            .Builder(R.layout.layout_auth_space)
            .setGoogleButtonId(R.id.loginBtn)
            .build()
        return AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setAuthMethodPickerLayout(layout)
            .setTheme(R.style.AppTheme_NoActionBar)
            .setAlwaysShowSignInMethodScreen(true)
            .setIsSmartLockEnabled(false)
            .build()
    }

}