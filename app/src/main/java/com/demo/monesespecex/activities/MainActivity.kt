package com.demo.monesespecex.activities

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
        replaceFragment(R.id.frmMain, HomeFragment(), "HomeFragment", false, null)
    }

    private fun init(){
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
