package com.example.cubeguessingapp

import android.graphics.Color
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

            displayIndex()

        // losowanie  pierwszego miejsca na niebieski
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()

        //wyswietlanie pierwszej liczby (zrobic podobnie w przyszlosci
      animationForOne()







        upB1.setOnClickListener{
            currentClickedTile=1
            println(currentClickedTile)
            playSound()
            checkIfClickedCorrect()



        }


        upB2.setOnClickListener{
            currentClickedTile=2
            println(currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB3.setOnClickListener{

            currentClickedTile=3
            println(currentClickedTile)
            playSound()

            checkIfClickedCorrect()

        }


        upB4.setOnClickListener{
            currentClickedTile=4
            println(currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }

        upB5.setOnClickListener{
            currentClickedTile=5
            println(currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB6.setOnClickListener{
            currentClickedTile=6
            println(currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB7.setOnClickListener{
            currentClickedTile=7
            println(currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB8.setOnClickListener{
            currentClickedTile=8
            println(currentClickedTile)
            playSound()
            checkIfClickedCorrect()
        }


        upB9.setOnClickListener{
            currentClickedTile=9
            println(currentClickedTile)
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
    // protyp jak zmieniac muzyke
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
        when (currentRandomTile) {

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
           // 0-> animationForOne()
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
        object : CountDownTimer(800, 800) {
            override fun onTick(arg0: Long) {

                index=0
                changeTileColorToBlue()
                currentNeededTile=currentRandomTile


                println("OBECNA ANIMACJA : "+1)

            }

            override fun onFinish() {
                changeAllTileColorToBlack()
            }
        }.start()
    }

    fun animationForTwo(){
        animationForOne()
        breakAnimation()

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(800, 800) {
            override fun onTick(arg0: Long) {

                index=1
                changeTileColorToBlue()
                currentNeededTile=currentRandomTile
                println("OBECNA ANIMACJA : "+2)

            }

            override fun onFinish() {
                changeAllTileColorToBlack()
            }
        }.start()


    }

    fun animationForThree(){
        animationForTwo()
        breakAnimation()
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(800, 800) {
            override fun onTick(arg0: Long) {

                index=2
                changeTileColorToBlue()
                currentNeededTile=currentRandomTile


            }

            override fun onFinish() {
                changeAllTileColorToBlack()
            }
        }.start()
    }

    fun animationForFour(){
        animationForThree()
        breakAnimation()
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(800, 800) {
            override fun onTick(arg0: Long) {

                index=3
                changeTileColorToBlue()
                currentNeededTile=currentRandomTile


            }

            override fun onFinish() {
                changeAllTileColorToBlack()
            }
        }.start()
    }


    // ponizej nie zmienione narazie


    fun animationForFive(){
        animationForFour()
    }

    fun animationForSix(){
        animationForFive()
    }

    fun animationForSeven(){
        animationForSix()
    }

    fun animationForEight(){
        animationForSeven()
    }

    fun animationForNine(){
        animationForEight()
    }

    fun animationForTen(){
        animationForNine()
    }





}