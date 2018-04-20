package com.example.cpu02351_local.volleydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import okhttp3.OkHttpClient


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url = "https://api.github.com/users/ldbach-apcs/repos"
        val start = System.currentTimeMillis()
        // Add the request to the RequestQueue.
        val request = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> {
                    Log.d("VOLLEY_SINGLE", "${System.currentTimeMillis() - start}")
                },
                Response.ErrorListener {}
        )
        queue.add(request)
    }
}
