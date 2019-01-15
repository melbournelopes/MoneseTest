package com.demo.monesespecex.adapters

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.demo.monesespecex.R
import com.demo.monesespecex.activities.RocketDetailsActivity
import com.demo.monesespecex.models.MainRocketModel
import com.demo.monesespecex.utilities.AppConstants

open class RocketsAdapter(context: Activity, mainRocketModelList: List<MainRocketModel>) : RecyclerView.Adapter<RocketsAdapter.RocketViewHolder>(), View.OnClickListener {
    private var context: Activity = context
    private var mainRocketModelList: List<MainRocketModel> = mainRocketModelList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketsAdapter.RocketViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.rockets_item_row, parent, false)
        return RocketsAdapter.RocketViewHolder(v)
    }

    override fun onBindViewHolder(holder: RocketsAdapter.RocketViewHolder, position: Int) {
        val mainRocketModel = mainRocketModelList[position]
        holder.lblTitle.text = "" + mainRocketModel.rocket.rocket_name
        holder.lblType.text = "" + mainRocketModel.rocket.rocket_name
        holder.cardRocket.tag = position
        holder.cardRocket.setOnClickListener(this)
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

    class RocketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardRocket: CardView = itemView.findViewById(R.id.cardRocket)
        var lblTitle: TextView = itemView.findViewById(R.id.lblTitle)
        var lblType: TextView = itemView.findViewById(R.id.lblType)
    }
}