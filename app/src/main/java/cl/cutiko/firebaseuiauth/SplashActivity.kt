package cl.cutiko.firebaseuiauth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firebase.ui.auth.AuthMethodPickerLayout
import com.firebase.ui.auth.AuthUI


class SplashActivity : AppCompatActivity() {

    private val RCSIGNIN = 343

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val providers = mutableListOf<AuthUI.IdpConfig>()
        providers.add(AuthUI.IdpConfig.GoogleBuilder().build())

        val layout = AuthMethodPickerLayout
            .Builder(R.layout.activity_login)
            .setGoogleButtonId(R.id.loginBtn)
            .build()

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setAuthMethodPickerLayout(layout)
                .setTheme(R.style.AppTheme_NoActionBar)
                .build(),
            RCSIGNIN)
    }
}

/*
* LOGCAT
* 2018-11-20 18:42:02.737 9409-9409/cl.cutiko.firebaseuiauth E/AuthUI: A sign-in error occurred.
    com.firebase.ui.auth.FirebaseUiException: Error when saving credential.
        at com.firebase.ui.auth.viewmodel.smartlock.SmartLockHandler$1.onComplete(SmartLockHandler.java:98)
        at com.google.android.gms.tasks.zzj.run(Unknown Source)
        at android.os.Handler.handleCallback(Handler.java:751)
        at android.os.Handler.dispatchMessage(Handler.java:95)
        at android.os.Looper.loop(Looper.java:154)
        at android.app.ActivityThread.main(ActivityThread.java:6119)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:886)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:776)
     Caused by: com.google.android.gms.common.api.ApiException: 8:
        at com.google.android.gms.common.internal.ApiExceptionUtil.fromStatus(Unknown Source)
        at com.google.android.gms.common.internal.zai.zaf(Unknown Source)
        at com.google.android.gms.common.internal.zaj.onComplete(Unknown Source)
        at com.google.android.gms.common.api.internal.BasePendingResult.zaa(Unknown Source)
        at com.google.android.gms.common.api.internal.BasePendingResult.setResult(Unknown Source)
        at com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl.setResult(Unknown Source)
        at com.google.android.gms.internal.auth-api.zzo.zzc(Unknown Source)
        at com.google.android.gms.internal.auth-api.zzv.dispatchTransaction(Unknown Source)
        at com.google.android.gms.internal.auth-api.zzd.onTransact(Unknown Source)
        at android.os.Binder.execTransact(Binder.java:565)

* */
