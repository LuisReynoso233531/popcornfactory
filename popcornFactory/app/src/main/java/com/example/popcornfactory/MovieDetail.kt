package com.example.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val headerImage: ImageView = findViewById(R.id.header_image)
        val movieTitle: TextView = findViewById(R.id.movie_title)
        val movieSinopsis: TextView = findViewById(R.id.movie_sinopsis)

        val intent = intent
        val title = intent.getStringExtra("titulo")
        val sinopsis = intent.getStringExtra("sinopsis")
        val headerResId = intent.getIntExtra("header", 0)
        val imageResId = intent.getIntExtra("image", 0)

        movieTitle.text = title
        movieSinopsis.text = sinopsis
        headerImage.setImageResource(headerResId)
    }
}
