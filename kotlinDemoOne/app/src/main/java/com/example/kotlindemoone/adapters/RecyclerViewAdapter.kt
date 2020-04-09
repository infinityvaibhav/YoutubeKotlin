package com.example.kotlindemoone.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemoone.Bean.HomeFeed
import com.example.kotlindemoone.Bean.Videos
import com.example.kotlindemoone.activity.CourseDetailActivity
import com.example.kotlindemoone.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*


class RecyclerViewAdapter(private val homeFeed: HomeFeed): RecyclerView.Adapter<MViewHolder>() {

    //number of item
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return MViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val video = homeFeed.videos[position]
        val videoThumbnailImageView = holder.view.videoThumnail
        val videoChannelImageView = holder.view.channelIcon
        val descriptionText = video.channel.name + " + 20k Views\n4 days ago"
        holder.view.video_title?.text = video.name
        holder.view.video_description?.text = descriptionText
        Picasso.with(holder.view.context).load(video.imageUrl).into(videoThumbnailImageView)
        Picasso.with(holder.view.context).load(video.channel.profileImageUrl).into(videoChannelImageView)

        holder.video = video
    }


}

class MViewHolder(val view: View, var video: Videos? = null): RecyclerView.ViewHolder(view) {

    companion object {
        const val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        const val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {
        view.setOnClickListener {
            Log.i("Test", "testing click")
            val intent = Intent(view.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
            view.context.startActivity(intent)
        }
    }
}