package com.example.popularmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.popularmovies.databinding.ActivityDetailsBinding
import com.example.popularmovies.model.Movie

class DetailsActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "movie"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w185/"
    }
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        movie?.run {
            binding.titleText.text = title
            binding.releaseText.text = release_date.take(4)
            binding.overviewText.text = String.format(getString(R.string.overview), overview)
            Glide.with(this@DetailsActivity)
                .load("$IMAGE_URL$poster_path")
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(binding.moviePoster)
        }
    }
}