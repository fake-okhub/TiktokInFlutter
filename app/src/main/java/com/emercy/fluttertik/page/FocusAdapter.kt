package com.emercy.fluttertik.page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.emercy.fluttertik.R

/**
 * @author Emercy
 * @description
 * @data 2022/3/6
 */
class FocusAdapter : RecyclerView.Adapter<FocusAdapter.VideoHolder>() {

    class VideoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var video: VideoView = itemView.findViewById(R.id.video)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_video_page, parent, false)
        view.findViewById<VideoView>(R.id.video).apply {
            setVideoPath("android.resource://" + context.packageName + "/" + R.raw.video1)
            setOnPreparedListener {
                it.isLooping = true
            }
            setOnClickListener {
                if (isPlaying) {
                    pause()
                    view.findViewById<View>(R.id.play).visibility = View.VISIBLE
                } else {
                    start()
                    view.findViewById<View>(R.id.play).visibility = View.GONE
                }
            }
        }
        return VideoHolder(view)
    }

    override fun onBindViewHolder(holder: VideoHolder, p1: Int) {
        holder.video.apply {

        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}