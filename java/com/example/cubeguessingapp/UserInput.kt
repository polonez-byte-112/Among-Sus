package com.example.cubeguessingapp


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_input.*


class UserInput : AppCompatActivity() {


    val ap : AudioPlay= AudioPlay
    val ss : StartScreen= StartScreen()

    var color="white"

    var name=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_input)

        name= usernnameEditText.text.toString();

        ap.continuePlaying(this, R.raw.theme)



        whiteButton.setOnClickListener {
            color="white"
            changeColor()
        }

        yellowButton.setOnClickListener {
            color="yellow"
            changeColor()
        }

        limeButton.setOnClickListener {
            color="lime"
            changeColor()
        }


        orangeButton.setOnClickListener {
            color="orange"
            changeColor()
        }


        purpleButton.setOnClickListener {
            color="purple"
            changeColor()


        }


        continueB.setOnClickListener {

            val game = Intent(this, Board::class.java)
            startActivity(game)

            ap.stopAudio()
            this.cacheDir.deleteRecursively()




        }







    }

    fun changeColor(){
        when(color){
            "white"-> continueB.setBackgroundColor(Color.parseColor("#d9d9d9"))
            "yellow"-> continueB.setBackgroundColor(Color.parseColor("#f5f557"))
            "lime"-> continueB.setBackgroundColor(Color.parseColor("#50ef39"))
            "orange"-> continueB.setBackgroundColor(Color.parseColor("#ef7d0d"))
            "purple"-> continueB.setBackgroundColor(Color.parseColor("#6b2fba"))
        }


    }


}