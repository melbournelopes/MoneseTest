package com.demo.monesespecex.adapters

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.demo.monesespecex.R
import com.demo.monesespecex.activities.RocketDetailsActivity
import com.demo.monesespecex.models.MainRocketModel
import com.demo.monesespecex.utilities.AppConstants
import com.demo.monesespecex.utilities.Utils


open class RocketsAdapter(context: Activity, mainRocketModelList: Array<MainRocketModel>) : RecyclerView.Adapter<RocketsAdapter.RocketViewHolder>(), View.OnClickListener {
    private var context: Activity = context
    private var mainRocketModelList: Array<MainRocketModel> = mainRocketModelList
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketsAdapter.RocketViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.rockets_item_row, parent, false)
        return RocketsAdapter.RocketViewHolder(v)
    }

    override fun onBindViewHolder(holder: RocketsAdapter.RocketViewHolder, position: Int) {
        val mainRocketModel = mainRocketModelList[position]
        holder.lblTitle.text = "" + mainRocketModel.rocket.rocket_name
        holder.lblFlightNumber.text = context.getString(R.string.flight_number)+" - " + mainRocketModel.flight_number
        holder.lblLaunchDate.text = context.getString(R.string.launch_date)+" - " + Utils.convertTimestampToDate(mainRocketModel.launch_date_unix)
        holder.cardRocket.tag = position
        holder.cardRocket.setOnClickListener(this)

        setAnimation(holder.itemView, position);
    }

    override fun onClick(v: View?) {
        val pos: Int = v?.tag as Int
        when (v?.id) {
            R.id.cardRocket -> {
                var i: Intent = Intent(context, RocketDetailsActivity::class.java)
                var bd: Bundle = Bundle()
                bd.putInt(AppConstants.BUNDLE_KEYS_ROCKET_POS, pos)
                i.putExtras(bd)
                context.startActivity(i)
            }

        }
    }

    override fun getItemCount(): Int {
        return mainRocketModelList.size
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    class RocketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardRocket: CardView = itemView.findViewById(R.id.cardRocket)
        var lblTitle: TextView = itemView.findViewById(R.id.lblTitle)
        var lblFlightNumber: TextView = itemView.findViewById(R.id.lblFlightNumber)
        var lblLaunchDate: TextView = itemView.findViewById(R.id.lblLaunchDate)
    }
}