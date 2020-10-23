package com.example.cubeguessingapp

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_board.*

class Board : AppCompatActivity() {

    var isTrue= BooleanArray(9)
    var correctTiles = IntArray(9)
    var currentTile =0

    var correctCurrentTile=true
    var badCurrentTile=false

    val ap: AudioPlay = AudioPlay
    var player: MediaPlayer? = null

    var currentRandomTile=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)


        // losowanie miejsca na niebieski
        isTrue[0]=true



        //tez naprawic pod kątem żeby to nie było tutaj albo tylko jeden przycisk tutaj a potem reszta po przyciskach bo to on create jest!!

        //fajnie zmienia kolor w zaleznosci od isTrue tylko ze isTrue ma wyswietlac ile jest  x/10
        /*
 for(i in 9 downTo 0 step 1){

            if(isTrue[i]==true){

                when(i){
                    0->downB1.setBackgroundColor(Color.parseColor("#42aaff"))
                    1->downB2.setBackgroundColor(Color.parseColor("#42aaff"))
                    2->downB3.setBackgroundColor(Color.parseColor("#42aaff"))
                    3->downB4.setBackgroundColor(Color.parseColor("#42aaff"))
                    4->downB5.setBackgroundColor(Color.parseColor("#42aaff"))
                    5->downB6.setBackgroundColor(Color.parseColor("#42aaff"))
                    6->downB7.setBackgroundColor(Color.parseColor("#42aaff"))
                    7->downB8.setBackgroundColor(Color.parseColor("#42aaff"))
                    8->downB9.setBackgroundColor(Color.parseColor("#42aaff"))
                }
            }

        }
 */

                currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()



        //wyswietlanie pierwszej liczby (zrobic podobnie w przyszlosci
        object : CountDownTimer(1500, 500) {
            override fun onTick(arg0: Long) {

                when (currentRandomTile) {
                    0 -> downB1.setBackgroundColor(Color.parseColor("#42aaff"))
                    1 -> downB2.setBackgroundColor(Color.parseColor("#42aaff"))
                    2 -> downB3.setBackgroundColor(Color.parseColor("#42aaff"))
                    3 -> downB4.setBackgroundColor(Color.parseColor("#42aaff"))
                    4 -> downB5.setBackgroundColor(Color.parseColor("#42aaff"))
                    5 -> downB6.setBackgroundColor(Color.parseColor("#42aaff"))
                    6 -> downB7.setBackgroundColor(Color.parseColor("#42aaff"))
                    7 -> downB8.setBackgroundColor(Color.parseColor("#42aaff"))
                    8 -> downB9.setBackgroundColor(Color.parseColor("#42aaff"))
                }


                correctTiles[0]==currentRandomTile


            }

            override fun onFinish() {
                downB1.setBackgroundColor(Color.parseColor("#000000"))
                 downB2.setBackgroundColor(Color.parseColor("#000000"))
                 downB3.setBackgroundColor(Color.parseColor("#000000"))
                 downB4.setBackgroundColor(Color.parseColor("#000000"))
                downB5.setBackgroundColor(Color.parseColor("#000000"))
                 downB6.setBackgroundColor(Color.parseColor("#000000"))
                 downB7.setBackgroundColor(Color.parseColor("#000000"))
                downB8.setBackgroundColor(Color.parseColor("#000000"))
                 downB9.setBackgroundColor(Color.parseColor("#000000"))
            }
        }.start()







        upB1.setOnClickListener{
            currentTile=1
            println(currentTile)
            playSound()

            currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()

            println("Current random Tile : "+currentRandomTile)
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

/* tymczasowo wylaczam
        if(correctTile==true && badTile==false){
            ap.playAudio(this, R.raw.good_click,false)

        }

        if(correctTile==false && badTile==true){

            ap.playAudio(this, R.raw.fail_click,false)

        }

 */

        this.cacheDir.deleteRecursively()

    }








}