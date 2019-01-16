package com.demo.monesespecex.activities

import android.app.AlertDialog
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

        showWelcome()?.show()
    }

    private fun showWelcome(): AlertDialog? {
        val builder = AlertDialog.Builder(this)

        val inflater = layoutInflater

        builder.setView(inflater.inflate(R.layout.dialog_welcome, null))
                .setTitle(R.string.welcome_title)
                .setCancelable(false)
                .setPositiveButton(R.string.enter, { dialog, which ->
                    replaceFragment(R.id.frmMain, HomeFragment(), "HomeFragment", false, null)
                })
        return builder.create()
    }

    private fun init() {
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
