package cl.cutiko.space.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.support.v7.widget.AppCompatTextView
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import cl.cutiko.space.R

class WelcomeView(context: Context?, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    val welcome : String = context!!.getString(R.string.welcome_traveller)

    fun setCallback(callback: () -> Unit){
        addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s?.length == welcome.length) callback()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    fun welcomeUser() {
        writeTitle(0)
    }

    @SuppressLint("SetTextI18n")
    private fun writeTitle(position : Int, delay : Long = 1300) {
        Handler().postDelayed({
            val letter = welcome[position]
            text = "$text$letter"
            if (welcome.length == text.length) {
                animate().setStartDelay(800).translationY(-500F).setDuration(600).start()
            } else {
                writeTitle(position + 1, 250)
            }
        }, delay)
    }

}