package com.demo.monesespecex.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class BaseFragment : Fragment() {
    val TAG = BaseFragment::class.java.simpleName
    private var activityRef: AppCompatActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activityRef = context as AppCompatActivity?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getParentFragment() == null) {
            setRetainInstance(true)
        }
    }

    fun getActivityRef(): AppCompatActivity? {
        return activityRef
    }
}