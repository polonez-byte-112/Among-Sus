package com.example.cubeguessingapp


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start_screen.*

class StartScreen : AppCompatActivity() {

    val ap : AudioPlay= AudioPlay
 //   var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

/*
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.theme)
            mediaPlayer!!.setVolume(1.0.toFloat(),1.0.toFloat());
            mediaPlayer!!.start()
        }
 */


        ap.playAudio(this,R.raw.theme,true)

        startButton.setOnClickListener {
            this.cacheDir.deleteRecursively()
            val start =  Intent(this, UserInput::class.java)
            startActivity(start)

        }


    }


}