package com.example.kotlindemoone.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemoone.adapters.ViewHolder
import com.example.kotlindemoone.R
import kotlinx.android.synthetic.main.course_lesson_activity.*

class CourseLessonActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_lesson_activity)
        val webViewUrl = intent.getStringExtra(ViewHolder.COURSE_LESSON_LINK_KEY)

        web_view_course_lesson.settings.javaScriptEnabled = true
        web_view_course_lesson.settings.loadWithOverviewMode = true
        web_view_course_lesson.settings.useWideViewPort = true
        web_view_course_lesson.loadUrl(webViewUrl)
    }
}