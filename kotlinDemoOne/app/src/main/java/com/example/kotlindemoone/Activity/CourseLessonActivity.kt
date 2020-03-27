package com.example.kotlindemoone.Activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemoone.Adapters.ViewHolder
import com.example.kotlindemoone.R
import kotlinx.android.synthetic.main.course_lesson_activity.*

class CourseLessonActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_lesson_activity)
        webview_course_lesson.setBackgroundColor(Color.YELLOW)
        val webViewUrl = intent.getStringExtra(ViewHolder.COURSE_LESSON_LINK_KEY)

        webview_course_lesson.settings.javaScriptEnabled = true
        webview_course_lesson.settings.loadWithOverviewMode = true
        webview_course_lesson.settings.useWideViewPort = true
        webview_course_lesson.loadUrl(webViewUrl)
    }
}