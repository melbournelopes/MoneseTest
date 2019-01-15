package com.demo.monesespecex.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.demo.monesespecex.R
import com.demo.monesespecex.fragments.RocketDetailsFragment

open class RocketDetailsActivity : BaseActivity() {
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_details)
        init()
        replaceFragment(R.id.frmDetails, RocketDetailsFragment(), "RocketDetailsFragment", false, intent.extras)
    }

    private fun init(){
        mToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        mToolbar?.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
    }
}
