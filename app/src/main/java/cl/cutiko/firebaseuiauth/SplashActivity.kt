package cl.cutiko.firebaseuiauth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import cl.cutiko.dance.DanceIntent
import cl.cutiko.dance.RC_DANCE_AUTH
import cl.cutiko.space.RC_AUTH_SPACE


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        startActivityForResult(DanceIntent().get(), RC_DANCE_AUTH)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (RC_AUTH_SPACE == requestCode && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "WELCOME ON BOARD", Toast.LENGTH_LONG).show();
        }
    }
}
