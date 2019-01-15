package com.demo.monesespecex.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demo.monesespecex.fragments.BaseFragment

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun replaceFragment(containerViewId: Int, baseFragment: BaseFragment, tag: String, addToBackStack: Boolean, bd: Bundle?) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (bd != null) {
            baseFragment.arguments = bd
        }
        fragmentTransaction.replace(containerViewId, baseFragment, tag)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}