package com.demo.monesespecex.fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.demo.monesespecex.App
import com.demo.monesespecex.R
import com.demo.monesespecex.adapters.RocketsAdapter
import com.demo.monesespecex.models.MainRocketModel
import com.demo.monesespecex.utilities.AppConstants
import com.demo.monesespecex.utilities.PreferenceUtils
import com.demo.monesespecex.utilities.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONException

open class HomeFragment : BaseFragment(), AdapterView.OnItemSelectedListener {
    private val OFFSET = 50
    private val LIMIT = 50
    private lateinit var rvRockets: RecyclerView
    private lateinit var pDialog: ProgressDialog
    private lateinit var spnFilter: Spinner

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        init(view!!)
        getRocketsDatails()

        return view
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
        when(pos){
            0 -> Toast.makeText(activity, "All filter coming soon", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(activity, "Active filter coming soon", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(activity, "Inactive filter coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    private fun getRocketsDatails() {
        pDialog?.show()
        val getCompany = AppConstants.BASE_URL + "?offset=" + OFFSET + "&limit=" + LIMIT
        Log.d("spaceX request", getCompany)
        if (Utils.isNetworkAvailable(activity)) {
            val stringRequest = StringRequest(Request.Method.GET,
                    getCompany,
                    Response.Listener { response ->
                        pDialog?.dismiss()
                        Log.d("spaceX response", response)
                        try {
                            val jsonArray = JSONArray(response)
                            val gson = Gson()
                            val listType = object : TypeToken<List<MainRocketModel>>() {

                            }.type
                            var rocketModelList = gson.fromJson<List<MainRocketModel>>(jsonArray.toString(), listType)
                            if (rocketModelList != null && rocketModelList.size > 0) {
                                val adapter = RocketsAdapter(activity, rocketModelList)
                                rvRockets.adapter = adapter
                                loadFilter()
                                PreferenceUtils.insertObject(PreferenceUtils.PREF_KEYS_ROCKET_RESPONSE, rocketModelList)
                            }

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }, Response.ErrorListener {
                pDialog?.dismiss()
                Toast.makeText(activity, "" + getString(R.string.connectivity_issue), Toast.LENGTH_SHORT).show()
            }
            )
            App.getInstance().volleyRequestQueue.add(stringRequest)
        } else {
            Toast.makeText(activity, "" + getString(R.string.check_internet_msg), Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadFilter(){
        val adapter = ArrayAdapter<String>(
                activity,
                android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.ar_rocket_status))
        spnFilter.adapter = adapter
        spnFilter.onItemSelectedListener = this
    }

    private fun init(view: View) {
        spnFilter = view?.findViewById(R.id.spnFilter)
        rvRockets = view?.findViewById(R.id.rvRockets)
        rvRockets.layoutManager = LinearLayoutManager(activity)

        pDialog = ProgressDialog(activity)
        pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        pDialog.setCancelable(false)
        pDialog.setMessage("" + getString(R.string.please_wait))
    }
}