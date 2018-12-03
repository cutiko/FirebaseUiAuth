package cl.cutiko.dance.body.intro

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cl.cutiko.dance.R
import kotlinx.android.synthetic.main.content_fragment_permission.*

class PermissionFragment : IntroFragment(), View.OnClickListener {

    companion object {
        private const val RC_READ_CONTACTS = 88
        fun newInstance() : PermissionFragment {
            return PermissionFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LayoutInflater.from(view.context).inflate(R.layout.content_fragment_permission, view as ViewGroup, true)
        permissionBtn.setOnClickListener(this)
    }

    override val getText: Int
        get() = R.string.intro_permissions
    override val getUndraw: Int
        get() = R.drawable.undraw_android

    override fun onClick(v: View?) {
        if (context == null || activity == null) return
        val readContacts = Manifest.permission.READ_CONTACTS
        if (ContextCompat.checkSelfPermission(context!!, readContacts) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(readContacts), RC_READ_CONTACTS)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Toast.makeText(context, "$requestCode", Toast.LENGTH_LONG).show()
    }
}