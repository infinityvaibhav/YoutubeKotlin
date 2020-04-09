package com.example.kotlindemoone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemoone.adapters.RecyclerViewAdapter
import com.example.kotlindemoone.Bean.HomeFeed
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        fetchJSON()
    }

    private fun fetchJSON() {
        val url = getString(R.string.home_feed_json_API)

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gsonObject = GsonBuilder().create()
                val homeFeed = gsonObject.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerview_main.adapter =
                        RecyclerViewAdapter(
                            homeFeed
                        )
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                print(R.string.error_message)
            }
        })
    }
}
