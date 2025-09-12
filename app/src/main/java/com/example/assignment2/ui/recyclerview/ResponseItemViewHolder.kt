package com.example.assignment2.ui.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.network.ResponseItem

class ResponseItemViewHolder(view: View, private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.ViewHolder(view) {

    private val artistname: TextView = view.findViewById(R.id.itemArtistNametext)
    private val albumtitle: TextView = view.findViewById(R.id.itemAlbumTitleText)
    private val releaseyear: TextView = view.findViewById(R.id.itemReleaseYearText)
    private val genre: TextView = view.findViewById(R.id.itemGenreText)
    private val trackcount: TextView = view.findViewById(R.id.itemTrackCountText)
    private val populartrack: TextView = view.findViewById(R.id.itemPopularTrackText)
    private val details: TextView = view.findViewById(R.id.detailsText)
    private val button: Button = view.findViewById(R.id.navigationButton)

    fun bind(item: ResponseItem) {
        artistname.text = "Artist Name: " + item.artist_name
        albumtitle.text = "Album Title: " + item.album_title
        releaseyear.text = "Release Year: " + item.release_year
        genre.text = "Genre: " + item.genre
        trackcount.text = "Track Count: " + item.track_count
        populartrack.text = "Popular Track: " + item.popular_track

        val showDetails = if (item.description.isNullOrEmpty()) View.INVISIBLE else View.VISIBLE
        details.visibility = showDetails
        button.visibility = showDetails

        if (showDetails == View.VISIBLE) {
            button.setOnClickListener {
                navigationFunction(item)
            }
        }
    }
}
