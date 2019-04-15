package com.demo.monesespecex;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class App extends Application {
    private static App appInstance;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance=this;
		
		
		
		
		
		
		
		
		
    }

    public RequestQueue getVolleyRequestQueue() {
        // If RequestQueue is null the initialize new RequestQueue
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this);
        }

        // Return RequestQueue
        return mRequestQueue;
    }

    public static final App getInstance(){
        return appInstance;
    }
}