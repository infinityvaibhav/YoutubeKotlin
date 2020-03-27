package com.example.kotlindemoone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemoone.Adapters.RecyclerViewAdapter
import com.example.kotlindemoone.Bean.HomeFeed
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        recyclerview_main.setBackgroundColor(Color.RED)
        recyclerview_main.layoutManager = LinearLayoutManager(this)


        fetchJSON()
    }

    private fun fetchJSON() {
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                Log.i("response",body)
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

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


//class HomeFeed(val videos: List<Videos>)
//
//class Videos(id: Int, name: String)