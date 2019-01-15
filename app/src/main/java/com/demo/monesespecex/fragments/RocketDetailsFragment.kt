package com.demo.monesespecex.fragments

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.demo.monesespecex.R
import com.demo.monesespecex.models.MainRocketModel
import com.demo.monesespecex.utilities.AppConstants
import com.demo.monesespecex.utilities.PreferenceUtils
import com.demo.monesespecex.utilities.Utils

open class RocketDetailsFragment : BaseFragment() {
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    private lateinit var lblRocketName: TextView
    private lateinit var lblFlightNumber: TextView
    private lateinit var lblMissionName: TextView
    private lateinit var launchYear: TextView
    private lateinit var lblLaunchDate: TextView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_rocket_details, container, false)
        init(view!!)
        setToolbarTextAppernce()
        var rocketModelList: Array<MainRocketModel> = PreferenceUtils.getObject(PreferenceUtils.PREF_KEYS_ROCKET_RESPONSE, Array<MainRocketModel>::class.java) as Array<MainRocketModel>
        var rocket: MainRocketModel = rocketModelList[arguments.getInt(AppConstants.BUNDLE_KEYS_ROCKET_POS)]
        setData(rocket)
        return view
    }

    private fun setData(rocketModel: MainRocketModel) {
        lblRocketName.text = rocketModel.rocket.rocket_name
        lblFlightNumber.text = ""+rocketModel.flight_number
        lblMissionName.text = rocketModel.mission_name
        launchYear.text = rocketModel.launch_year
        lblLaunchDate.text = Utils.convertTimestampToDate(rocketModel.launch_date_unix)

    }

    private fun setToolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar)
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar)
    }

    private fun init(view: View) {
        collapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar)
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar)
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar)

        lblRocketName = view.findViewById(R.id.lblRocketName)
        lblFlightNumber = view.findViewById(R.id.lblFlightNumber)
        lblMissionName = view.findViewById(R.id.lblMissionName)
        launchYear = view.findViewById(R.id.launchYear)
        lblLaunchDate = view.findViewById(R.id.lblLaunchDate)
    }
}