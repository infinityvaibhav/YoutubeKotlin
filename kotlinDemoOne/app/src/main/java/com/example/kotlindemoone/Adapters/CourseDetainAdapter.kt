package com.example.kotlindemoone.Adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemoone.Activity.CourseLessonActivity
import com.example.kotlindemoone.Bean.CourseLesson
import com.example.kotlindemoone.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.course_detail_row.view.*

class CourseDetainAdapter(val courseLesson: Array<CourseLesson>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val customView  = layoutInflater.inflate(R.layout.course_detail_row, parent, false)
        return ViewHolder(customView, null)
    }

    override fun getItemCount(): Int {

        return courseLesson.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val courseLesson = courseLesson[position]
        Log.d("holder", holder?.customView?.duration.text as String)
        holder?.customView?.courseTitle?.text = courseLesson.name
        holder?.customView?.duration?.text = courseLesson.duration
        holder?.customView?.number?.text = courseLesson.number.toString()
        Picasso.with(holder.customView.context).load(courseLesson.imageUrl).into(holder?.customView?.row_imageView)
        holder?.courseLesson = courseLesson
    }
}

class ViewHolder(val customView: View, var courseLesson: CourseLesson?): RecyclerView.ViewHolder(customView) {

    companion object {
        const val COURSE_LESSON_LINK_KEY = "COURSE_LESSON_LINK_KEY"
    }
    init {
        customView.setOnClickListener {
            val intent = Intent(customView.context, CourseLessonActivity::class.java)
            intent.putExtra(COURSE_LESSON_LINK_KEY, courseLesson?.link)
            customView.context.startActivity(intent)
        }
    }
}