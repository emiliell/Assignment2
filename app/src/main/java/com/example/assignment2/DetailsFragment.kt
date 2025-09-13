package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val arguments: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detail = arguments.details

        view.findViewById<TextView>(R.id.textArtistName)?.text = "Artist Name: ${detail.artist_name ?: "NA"}"
        view.findViewById<TextView>(R.id.textAlbumTitle)?.text = "Album Title: ${detail.album_title ?: "NA"}"
        view.findViewById<TextView>(R.id.textReleaseYear)?.text = "Release Year: ${detail.release_year ?: "NA"}"
        view.findViewById<TextView>(R.id.textGenre)?.text = "Genre: ${detail.genre ?: "NA"}"
        view.findViewById<TextView>(R.id.textTrackCount)?.text = "Track Count: ${detail.track_count ?: "NA"}"
        view.findViewById<TextView>(R.id.textPopularTrack)?.text = "Popular Track: ${detail.popular_track ?: "NA"}"
        view.findViewById<TextView>(R.id.textDescription)?.text = "Description: ${detail.description ?: "NA"}"

    }


}