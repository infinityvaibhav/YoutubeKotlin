package com.example.kotlindemoone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        val navBarTitle = intent.getStringExtra(MViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle


        fetchJSON()
    }

    private fun fetchJSON() {
        val videoKey = intent.getIntExtra(MViewHolder.VIDEO_ID_KEY, -1)
        val courseDetailURL = getString(R.string.course_detail_json_API) + videoKey

        val client = OkHttpClient()
        val request = Request.Builder().url(courseDetailURL).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("failure", "failed calling course detail")
            }

            override fun onResponse(call    : Call, response: Response) {
                val body = response?.body?.string()

                val gson = GsonBuilder().create()
                val courseLesson = gson.fromJson(body, Array<CourseLesson>::class.java)

                runOnUiThread {
                    recyclerview_main.adapter = CourseDetainAdapter(courseLesson)
                }
            }

        })
    }
}
