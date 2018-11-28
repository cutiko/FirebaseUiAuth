package cl.cutiko.firebaseuiauth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.firebase.ui.auth.AuthMethodPickerLayout
import com.firebase.ui.auth.AuthUI


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val providers = mutableListOf<AuthUI.IdpConfig>()
        providers.add(AuthUI.IdpConfig.GoogleBuilder().build())

        val layout = AuthMethodPickerLayout
            .Builder(R.layout.layout_auth_space)
            .setGoogleButtonId(R.id.loginBtn)
            .build()

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setAuthMethodPickerLayout(layout)
                .setTheme(R.style.AppTheme_NoActionBar)
                .setAlwaysShowSignInMethodScreen(true)
                .setIsSmartLockEnabled(false)
                .build(),
            RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (RC_SIGN_IN == requestCode && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "WELCOME ON BOARD", Toast.LENGTH_LONG).show();
        }
    }

    companion object {
        private const val RC_SIGN_IN = 343
    }
}
