package com.example.cpu02351_local.volleydemo

import android.content.Context
import com.android.volley.toolbox.Volley
import com.android.volley.RequestQueue


class SingletonRequestQueue private constructor(private val mContext: Context) {
    private var mRequestQueue: RequestQueue? = null

    private val requestQueue: RequestQueue
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(mContext)
            }
            return mRequestQueue!!
        }

    init {
        mRequestQueue = requestQueue
    }

    companion object {

        private var mInstance: SingletonRequestQueue? = null

        @Synchronized
        fun getInstance(context: Context): SingletonRequestQueue {
            if (mInstance == null) {
                mInstance = SingletonRequestQueue(context)
            }
            return mInstance!!
        }
    }
}
