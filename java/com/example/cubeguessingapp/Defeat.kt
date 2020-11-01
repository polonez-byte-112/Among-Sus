package com.example.cubeguessingapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat.setBackground
import kotlinx.android.synthetic.main.activity_defeat.*

class Defeat : AppCompatActivity()  {

    var endingColor = ""
    var username=""
    val ap : AudioPlay= AudioPlay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_defeat)

        endingColor=intent.getStringExtra("Color").toString()
        username=intent.getStringExtra("username").toString()


        changeBackgrounds()

        textAnimation()



        resetButton.setOnClickListener {
            val reset = Intent(this, StartScreen::class.java)
            startActivity(reset)
        }
    }


    fun changeBackgrounds(){

        when(endingColor){
            "white"-> resetButton.setTextColor(Color.parseColor("#000000"))
            "yellow"->resetButton.setTextColor(Color.parseColor("#f5f557"))
            "lime"-> resetButton.setTextColor(Color.parseColor("#50ef39"))
            "orange"->resetButton.setTextColor(Color.parseColor("#ef7d0d"))
            "purple"-> resetButton.setTextColor(Color.parseColor("#6b2fba"))

        }

        when(endingColor){
            "white"-> bg_fail.setBackgroundResource(R.drawable.fail_white)
            "yellow"->bg_fail.setBackgroundResource(R.drawable.fail_yellow)
            "lime"-> bg_fail.setBackgroundResource(R.drawable.fail_lime)
            "orange"->bg_fail.setBackgroundResource(R.drawable.fail_orange)
            "purple"-> bg_fail.setBackgroundResource(R.drawable.fail_purple)

        }
    }

    fun textAnimation(){
        Thread.sleep(400)
        ap.playAudio(this, R.raw.failsound, false)

        endingText.text = username+" was not An Impostor"
        coverText.text = username+" was not An Impostor"


        //odslanianie kto zginal

        coverText.animate().apply {
            duration=2500
            translationXBy(1100F)
        }.start()

    }



}