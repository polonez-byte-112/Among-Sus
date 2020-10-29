package com.example.cubeguessingapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_board.*
import java.util.*

class Board : AppCompatActivity() {

    var correctTiles = IntArray(10)
    var currentClickedTile =0
    var currentNeededTile=0
    var currentRandomTile=0


    var index=0
    var isEnd=false

    var countTick =0

    var takedColor=""
    var takedName=""

    val ap: AudioPlay = AudioPlay


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        takedColor=intent.getStringExtra("Color").toString()
        takedName=intent.getStringExtra("Name").toString()

        displayIndex()
        animationForOne()

        upB1.setOnClickListener{
            currentClickedTile=1
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()



        }


        upB2.setOnClickListener{
            currentClickedTile=2
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB3.setOnClickListener{

            currentClickedTile=3
            println("Current Clicked : "+ currentClickedTile)
            playSound()

            checkIfClickedCorrect()

        }


        upB4.setOnClickListener{
            currentClickedTile=4
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }

        upB5.setOnClickListener{
            currentClickedTile=5
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB6.setOnClickListener{
            currentClickedTile=6
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB7.setOnClickListener{
            currentClickedTile=7
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB8.setOnClickListener{
            currentClickedTile=8
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB9.setOnClickListener{
            currentClickedTile=9
            println("Current Clicked : "+ currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }
    }

    fun checkIfClickedCorrect(){

        if(currentClickedTile!=currentNeededTile){

            println("Wcisniety: "+currentClickedTile +",  Potrzebowany: "+currentNeededTile)
            defeat()
/*
            index=0
            correctTiles= IntArray(10)
            displayIndex()
            breakAnimation()
            animationForOne()
 */
        }

        if(currentClickedTile==currentNeededTile){
            // dodajemy po numerze index który trzeba jakos przypisac
            //np tako  correctTile[index] = currentClickedTile  cos takiego

            correctTiles[index] = currentClickedTile

            changeIndex()
            displayIndex()

           if(isEnd==true){ checkWin()}
            //  zmieniamy kolor dla nowego
            changeColor(index)

        }

    }
    fun playSound(){

        if(currentClickedTile!=0){
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
    fun changeTileColorToBlue(){
        when (currentNeededTile) {

            1 -> downB1.setBackgroundColor(Color.parseColor("#42aaff"))
            2 -> downB2.setBackgroundColor(Color.parseColor("#42aaff"))
            3 -> downB3.setBackgroundColor(Color.parseColor("#42aaff"))
            4 -> downB4.setBackgroundColor(Color.parseColor("#42aaff"))
            5 -> downB5.setBackgroundColor(Color.parseColor("#42aaff"))
            6 -> downB6.setBackgroundColor(Color.parseColor("#42aaff"))
            7 -> downB7.setBackgroundColor(Color.parseColor("#42aaff"))
            8 -> downB8.setBackgroundColor(Color.parseColor("#42aaff"))
            9 -> downB9.setBackgroundColor(Color.parseColor("#42aaff"))
        }
    }
    fun changeAllTileColorToBlack(){
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

    fun changeColor(i: Int?){
        //tutaj funkcja która będzie zmieniać kolor

        when(i){
            0-> animationForOne()
            1-> animationForTwo()
            2-> animationForThree()
            3-> animationForFour()
            4-> animationForFive()
            5-> animationForSix()
            6->animationForSeven()
            7-> animationForEight()
            8->animationForNine()
            9-> animationForTen()

        }
    }

    fun changeIndex(){
        when(index){
        0-> index=1
        1-> index=2
        2->index=3
        3-> index=4
        4-> index=5
        5-> index=6
        6-> index=7
        7-> index=8
        8->index=9
        9->isEnd=true
        }


        println("Nowy index : "+index)
    }
    fun displayIndex(){
        counterTextView.setText("Current: "+ (index+1)+"/10")
    }


    //Animacje


    fun animationForOne(){

                currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(1000, 1000) {
            override fun onTick(arg0: Long) {

                index=0
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()





            }

            override fun onFinish() {
                changeAllTileColorToBlack()
            }
        }.start()

    }
    fun animationForTwo(){



        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()


        object : CountDownTimer(2000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++
                println("Count Tick : "+ countTick)
                index=1

                if(countTick==1 && countTick<2){
                    currentNeededTile= correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=currentRandomTile
                    changeTileColorToBlue()
                }




            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()


    }
    fun animationForThree(){


        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(3000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++
                index=2
                println("Count Tick : "+ countTick)

                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }


                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=currentRandomTile
                    changeTileColorToBlue()
                }





            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }
    fun animationForFour(){

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(4000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++
                println("Count Tick : "+ countTick)




                index=3


                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4) {
                    changeAllTileColorToBlack()
                    currentNeededTile = currentRandomTile
                    changeTileColorToBlue()
                }


            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }
    fun animationForFive(){

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(5000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++
                println("Count Tick : "+ countTick)

                index=4


                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5) {
                    changeAllTileColorToBlack()
                    currentNeededTile = currentRandomTile
                    changeTileColorToBlue()
                }




            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }
    fun animationForSix(){

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(6000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++
                println("Count Tick : "+ countTick)

                index=5


                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6) {
                    changeAllTileColorToBlack()
                    currentNeededTile = currentRandomTile
                    changeTileColorToBlue()
                }




            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }
    fun animationForSeven() {

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(7000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++
                println("Count Tick : "+ countTick)

                index=6
                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7) {
                    changeAllTileColorToBlack()
                    currentNeededTile = currentRandomTile
                    changeTileColorToBlue()
                }


            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }
    fun animationForEight(){

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(8000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++
                println("Count Tick : "+ countTick)

                index=7
                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[6]
                    changeTileColorToBlue()
                }

                if(countTick==8) {
                    changeAllTileColorToBlack()
                    currentNeededTile = currentRandomTile
                    changeTileColorToBlue()
                }


            }

            override fun onFinish() {
                changeAllTileColorToBlack()

                countTick=0
            }
        }.start()
    }
    fun animationForNine(){

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(9000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++
                println("Count Tick : "+ countTick)

                index=8
                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[6]
                    changeTileColorToBlue()
                }


                if(countTick==8){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[7]
                    changeTileColorToBlue()
                }

                if(countTick==9) {
                    changeAllTileColorToBlack()
                    currentNeededTile = currentRandomTile
                    changeTileColorToBlue()
                }



            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }
    fun animationForTen(){
        if(isEnd==false){


        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(10000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++
                println("Count Tick : "+ countTick)
                counterTextView.setText("Current: 10 / 10")
                index=9
                if(countTick==1){
                    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[6]
                    changeTileColorToBlue()
                }


                if(countTick==8){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[7]
                    changeTileColorToBlue()
                }

                if(countTick==9){
                    changeAllTileColorToBlack()
                    currentNeededTile=correctTiles[8]
                    changeTileColorToBlue()
                }

                if(countTick==10) {
                    changeAllTileColorToBlack()
                    currentNeededTile = currentRandomTile
                    changeTileColorToBlue()
                }


            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }}


    fun checkWin(){

        println(Arrays.toString(correctTiles))
        var countGoodOnes=0
        for (x in 9 downTo 0 step 1){

            if(correctTiles[x]>0){
                countGoodOnes++
            }
        }


        if(countGoodOnes==10){
            val winner = Intent(this, Win::class.java)
            winner.putExtra("name", takedName)
            startActivity(winner)
        }
    }

    fun defeat(){
        val fail = Intent(this, Defeat::class.java)
        fail.putExtra("Color", takedColor)
        fail.putExtra("username", takedName)
        startActivity(fail)
    }















}