package com.example.kotlindemoone

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.course_detail_row.view.*
import kotlinx.android.synthetic.main.video_row.view.*

class CourseDetainAdapter(val courseLesson: Array<CourseLesson>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val customView  = layoutInflater.inflate(R.layout.course_detail_row, parent, false)
        return ViewHolder(customView)
    }

    override fun getItemCount(): Int {

        return courseLesson.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val courseLesson = courseLesson[position]
        holder?.customView?.video_title.text = courseLesson.name
        holder?.customView?.duration.text = courseLesson.duration
        holder?.customView?.number.text = courseLesson.number.toString()
        Picasso.with(holder.customView.context).load(courseLesson.imageUrl).into(holder?.customView?.row_imageView)
    }
}

class ViewHolder(val customView: View): RecyclerView.ViewHolder(customView) {

}