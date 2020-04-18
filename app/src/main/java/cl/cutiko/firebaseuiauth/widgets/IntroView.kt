package cl.cutiko.firebaseuiauth.widgets

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.BitmapFactory
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import cl.cutiko.firebaseuiauth.R
import kotlinx.android.synthetic.main.content_intro_view.view.*

class IntroView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    fun setView(@DrawableRes image: Int, @StringRes text: Int): View {
        LayoutInflater.from(context).inflate(R.layout.content_intro_view, this, true)

        val bitmap = BitmapFactory.decodeResource(resources, image)
        val palette = Palette.from(bitmap).generate()
        val mainColor =
            palette.getDarkMutedColor(ContextCompat.getColor(context, R.color.blackTransparent))

        imageIv.setImageBitmap(bitmap)

        overlayIv.backgroundTintList = ColorStateList.valueOf(mainColor)


        textIv.setTextColor(
            palette.getLightVibrantColor(
                ContextCompat.getColor(
                    context,
                    R.color.white
                )
            )
        )
        textIv.setText(text)

        return textIv
    }

}