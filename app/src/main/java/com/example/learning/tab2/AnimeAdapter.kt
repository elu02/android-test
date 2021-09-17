package com.example.learning.tab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.learning.R

class AnimeAdapter(
    private val animes : List<Anime>
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bindAnime(anime: Anime) {
            itemView.findViewById<TextView>(R.id.card_title).text = anime.title
            itemView.findViewById<TextView>(R.id.card_rating).text = "${anime.score}/10"
            Glide.with(itemView).load(anime.image_url).into(itemView.findViewById<ImageView>(R.id.card_image))
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeAdapter.AnimeViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.anime_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeAdapter.AnimeViewHolder, position: Int) {
        holder.bindAnime(animes.get(position))
    }

    override fun getItemCount(): Int = animes.size

}