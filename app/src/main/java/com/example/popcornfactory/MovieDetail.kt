package com.example.popcornfactory

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class MovieDetail : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        var ns = -1
        val bundle = intent.extras
        var buyTickets: Button = findViewById(R.id.buyTickets)
        var headerImage: ImageView = findViewById(R.id.header_image)
        var movieTitle: TextView = findViewById(R.id.movie_title)
        var movieSinopsis: TextView = findViewById(R.id.movie_sinopsis)
        var seats: TextView = findViewById(R.id.seatsLeft)
        var id=0

        if (bundle != null) {
            ns = bundle.getInt("numbersSeats")
            var title = intent.getStringExtra("titulo")
            var sinopsis = intent.getStringExtra("sinopsis")
            var headerResId = intent.getIntExtra("header", 0)
            var imageResId = intent.getIntExtra("image", 0)
            var seatsSelection = intent.getIntExtra("asientos",0)
            id = bundle.getInt("pos")
            seats.setText("$ns seats available")
            movieTitle.text = title
            movieSinopsis.text = sinopsis
            headerImage.setImageResource(headerResId)
        }

        if (ns==0){
            buyTickets.isEnabled = false
        }else{
            buyTickets.isEnabled = true
            buyTickets.setOnClickListener{
        val intent: Intent= Intent(this,SeatsSelection::class.java)

                intent.putExtra("id",id)
                intent.putExtra("name",title)

                this.startActivity(intent)
            }
        }
    }
}
