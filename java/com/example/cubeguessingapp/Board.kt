package com.example.cubeguessingapp

import android.graphics.Color
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_board.*

class Board : AppCompatActivity() {
//jezeli przycisk na gorze ma ten sam numer co na dole to niech bd dobrze
 // nie mieszac 10 z 9 bo 9 to liczba przyciskow a 10 to liczba wszystkich tych
    var isTrue= BooleanArray(10)
    var correctTiles = IntArray(10)
    var currentClickedTile =0
    var currentNeededTile=0;
    var currentRandomTile=0

    var defeat=false
    var win=false
    var index=0

    var countTick =0

    val ap: AudioPlay = AudioPlay



    /** NOTATKI
     *         //tez naprawic pod kątem żeby to nie było tutaj albo tylko jeden przycisk tutaj a potem reszta po przyciskach bo to on create jest!!

    //fajnie zmienia kolor/* w zaleznosci od isTrue tylko ze isTrue ma wyswietlac ile jest  x/10

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
     *
     */


    // check
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

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
            defeat=true
            win=false

            println("Wcisniety: "+currentClickedTile +",  Potrzebowany: "+currentNeededTile)
            println("Przegrana!!")
            index=0
            correctTiles= IntArray(10)
            displayIndex()
            breakAnimation()
            animationForOne()
        }

        if(currentClickedTile==currentNeededTile){
            // dodajemy po numerze index który trzeba jakos przypisac
            //np tako  correctTile[index] = currentClickedTile  cos takiego

            correctTiles[index] = currentClickedTile

            changeIndex()
            displayIndex()
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
    //funkcja która w zaleznosci od ilosci tiles do zmienienia na niebieski, to robi  bez zamieszania
    //czyli kilka animacji na raz   np 0 robi tylko jedną  1 robi wiecej etc etc
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
        9-> println("Ostatni index, bez zmian")
        }


        println("Nowy index : "+index)
    }
    fun displayIndex(){
        counterTextView.setText("Current: "+ (index+1)+"/10")
    }


    //Animacje
    fun breakAnimation(){

        object : CountDownTimer(1000, 1000) {
            override fun onTick(arg0: Long) {

                changeAllTileColorToBlack()
            }

            override fun onFinish() {
                changeAllTileColorToBlack()
            }
        }.start()
    }

    fun animationForOne(){

                currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(1000, 1000) {
            override fun onTick(arg0: Long) {

                index=0
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()



                println("OBECNA ANIMACJA : "+1)

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

                currentNeededTile=currentRandomTile
                changeTileColorToBlue()

                println("OBECNA ANIMACJA : "+2)

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
                println("Count Tick : "+ countTick)

                index=2
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()
                println("OBECNA ANIMACJA "+3)

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
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()

                println("OBECNA ANIMACJA "+4)

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
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()
                println("OBECNA ANIMACJA "+5)

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
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()

                println("OBECNA ANIMACJA "+6)

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
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()
                println("OBECNA ANIMACJA "+7)

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
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()
                println("OBECNA ANIMACJA "+8)

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
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()

                println("OBECNA ANIMACJA "+9)

            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }
    fun animationForTen(){
        if(index<=9){
            countTick++
            println("Count Tick : "+ countTick)

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(10000, 1000) {
            override fun onTick(arg0: Long) {

                index=9
                currentNeededTile=currentRandomTile
                changeTileColorToBlue()
                println("OBECNA ANIMACJA "+10)
                counterTextView.setText("Current: 10 / 10")
            }

            override fun onFinish() {
                changeAllTileColorToBlack()
                countTick=0
            }
        }.start()
    }}












}