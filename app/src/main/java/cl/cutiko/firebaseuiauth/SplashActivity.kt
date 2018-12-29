package cl.cutiko.firebaseuiauth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cl.cutiko.dance.DanceIntent
import cl.cutiko.dance.RC_DANCE_AUTH
import cl.cutiko.dogos.DogosIntent
import cl.cutiko.dogos.RC_DOGOS_AUTH
import cl.cutiko.firebaseuiauth.menu.MenuFragment
import cl.cutiko.space.RC_SPACE_AUTH
import cl.cutiko.space.SpaceIntent
import com.firebase.ui.auth.IdpResponse
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        danceIv.setView(R.drawable.thumbnail_dance, R.string.dance_demo)
            .setOnClickListener { startActivityForResult(DanceIntent().get(), RC_DANCE_AUTH) }
        dogsIv.setView(R.drawable.thumbnail_dogs, R.string.dogs_demo)
            .setOnClickListener { startActivityForResult(DogosIntent().get(), RC_DOGOS_AUTH) }
        spaceIv.setView(R.drawable.thumbnail_space, R.string.space_demo)
            .setOnClickListener { startActivityForResult(SpaceIntent().get(), RC_SPACE_AUTH) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val response = IdpResponse.fromResultIntent(data)
        val menuFragment = supportFragmentManager.findFragmentById(R.id.menuFragment) as MenuFragment
        menuFragment.showResult(resultCode, requestCode, response)
    }
}
