package com.example.cpu02351_local.volleydemo

import com.squareup.okhttp.OkHttpClient
import com.android.volley.toolbox.HurlStack
import com.squareup.okhttp.OkUrlFactory
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.SSLContext


class OkHttpStack @JvmOverloads constructor(client: OkHttpClient? = OkHttpClient()) : HurlStack() {
    private val mFactory: OkUrlFactory

    init {
        if (client == null) {
            throw NullPointerException("Client must not be null.")
        }

        try {
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, null, null)
            client.sslSocketFactory = sslContext.socketFactory
        } catch (e: Exception) {
            throw AssertionError() // The system has no TLS. Just give up.
        }

        mFactory = OkUrlFactory(client)
    }

    @Throws(IOException::class)
    override fun createConnection(url: URL): HttpURLConnection {
        return mFactory.open(url)
    }
}