package cl.cutiko.firebaseuiauth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import cl.cutiko.space.RC_AUTH_SPACE
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        danceIv.setView(R.drawable.thumbnail_dance, R.string.dance_demo)
        dogsIv.setView(R.drawable.thumbnail_dogs, R.string.dogs_demo)
        spaceIv.setView(R.drawable.thumbnail_space, R.string.space_demo)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (RC_AUTH_SPACE == requestCode && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "WELCOME ON BOARD", Toast.LENGTH_LONG).show();
        }
    }
}
