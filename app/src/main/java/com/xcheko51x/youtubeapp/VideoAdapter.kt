package com.xcheko51x.youtubeapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xcheko51x.youtubeapp.response.Item

class VideoAdapter(
    val context: Context,
    var listaVideos: List<Item>
): RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cvVideo = itemView.findViewById(R.id.cvVideo) as CardView
        val ivThumbnails = itemView.findViewById(R.id.ivThumbnails) as ImageView
        val tvTitle = itemView.findViewById(R.id.tvTitle) as TextView
        val tvDescription = itemView.findViewById(R.id.tvDescription) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_video, parent,false)
        return ViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaVideos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = listaVideos[position]

        holder.cvVideo.setOnClickListener {
            val intent = Uri.parse("https://www.youtube.com/watch?v="+video.id.videoId).let {
                Intent(Intent.ACTION_VIEW, it)
            }
            context.startActivity(intent)
        }

        Glide
            .with(context)
            .load(video.snippet.thumbnails.high.url)
            .centerInside()
            .into(holder.ivThumbnails)

        holder.tvTitle.text = video.snippet.title
        holder.tvDescription.text = video.snippet.description
    }
}