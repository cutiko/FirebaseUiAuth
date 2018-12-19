package cl.cutiko.firebaseuiauth.widgets

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.BitmapFactory
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import cl.cutiko.firebaseuiauth.R
import kotlinx.android.synthetic.main.content_intro_view.view.*

class IntroView(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    fun setView(@DrawableRes image : Int, @StringRes text : Int) {
        LayoutInflater.from(context).inflate(R.layout.content_intro_view, this, true)

        val bitmap = BitmapFactory.decodeResource(resources, image)
        val palette = Palette.from(bitmap).generate()
        val mainColor = palette.getDominantColor(ContextCompat.getColor(context, R.color.blackTransparent))

        imageIv.setImageBitmap(bitmap)

        overlayIv.backgroundTintList = ColorStateList.valueOf(mainColor)


        textIv.setTextColor(palette.getLightVibrantColor(ContextCompat.getColor(context, R.color.white)))
        textIv.setText(text)
    }

}