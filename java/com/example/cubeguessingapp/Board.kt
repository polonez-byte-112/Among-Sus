package com.example.cubeguessingapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_board.*

class Board : AppCompatActivity() {

    var currentTile =0

    var correctTile=true
    var badTile=false

    val ap: AudioPlay = AudioPlay
    var player: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)



        upB1.setOnClickListener{
            currentTile=1
            println(currentTile)
            playSound()
        }


        upB2.setOnClickListener{
            currentTile=2
            println(currentTile)
            playSound()
        }


        upB3.setOnClickListener{

            currentTile=3
            println(currentTile)
            playSound()
        }


        upB4.setOnClickListener{
            currentTile=4
            println(currentTile)
            playSound()
        }

        upB5.setOnClickListener{
            currentTile=5
            println(currentTile)
            playSound()
        }


        upB6.setOnClickListener{
            currentTile=6
            println(currentTile)
            playSound()
        }


        upB7.setOnClickListener{
            currentTile=7
            println(currentTile)
            playSound()
        }


        upB8.setOnClickListener{
            currentTile=8
            println(currentTile)
            playSound()
        }


        upB9.setOnClickListener{
            currentTile=9
            println(currentTile)
            playSound()
        }
    }
    // protyp jak zmieniac muzyke
    fun playSound(){

        if(currentTile!=0){
            ap.playAudio(this, R.raw.good_click,false)
        }

        if(correctTile==true && badTile==false){
            ap.playAudio(this, R.raw.good_click,false)
        }

        if(correctTile==false && badTile==true){

            ap.playAudio(this, R.raw.fail_click,false)
        }
    }




}