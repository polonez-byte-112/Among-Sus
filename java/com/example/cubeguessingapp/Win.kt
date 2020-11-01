package com.example.cubeguessingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_win.*

class Win : AppCompatActivity() {

    val ap : AudioPlay = AudioPlay

    var username=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        username = intent.getStringExtra("name").toString()
        ap.playAudio(this ,R.raw.win_sound, false)
        coverWinText.text = "Player \""+username+"\" won!"
        winText.text = "Player "+username+" won!"

        winButton.setOnClickListener {
            ap.stopAudio()
            val reset = Intent(this, StartScreen::class.java)
            startActivity(reset)

        }
    }
}