package com.example.cardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var start_game: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_scn)
//        setContentView(R.layout.activity_main)
        start_game = findViewById(R.id.startButton)

        start_game.setOnClickListener {
            Log.d("any", "this00")
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
            //setContentView(R.layout.activity_main)
        }
    }
}