package com.demo.monesespecex.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.demo.monesespecex.R
import com.demo.monesespecex.fragments.HomeFragment


class MainActivity : BaseActivity() {
    private var mToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        showWelcome()
    }

    private fun showWelcome() {
        AlertDialog.Builder(this)
                .setMessage(getString(R.string.welcome_msg))
                .setPositiveButton(getString(R.string.enter), DialogInterface.OnClickListener {
                    dialog, arg1 -> dialog.dismiss()
                    replaceFragment(R.id.frmMain, HomeFragment(), "HomeFragment", false, null)
                })
                .setCancelable(false)
                .create().show()
    }

    private fun init() {
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
