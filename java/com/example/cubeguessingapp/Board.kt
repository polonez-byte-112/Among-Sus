package com.example.cubeguessingapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_board.*
import java.lang.reflect.Array
import java.util.*

class Board : AppCompatActivity() {

    var correctTiles = IntArray(10)
    var currentClickedTile =0
    var currentNeededTile=0
    var currentRandomTile=0
    var currentTileToLightUp=0

    var random2=0
    var random3=0
    var random4=0
    var random5=0
    var random6=0
    var random7=0
    var random8=0
    var random9=0
    var random10=0


    var index=0
    var isEnd=false

    var countTick =0
    var countClicks=0

    var takedColor=""
    var takedName=""
var currentAnimation=0

    var isClicked=true

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

            playSound()
            isClicked=true
        //    checkIfClickedCorrect()
            changeMechanics()



        }


        upB2.setOnClickListener{
            currentClickedTile=2

            playSound()
            isClicked=true
         //   checkIfClickedCorrect()
            changeMechanics()
        }


        upB3.setOnClickListener{

            currentClickedTile=3

            playSound()
            isClicked=true
          //  checkIfClickedCorrect()
            changeMechanics()

        }


        upB4.setOnClickListener{
            currentClickedTile=4

            playSound()
            isClicked=true
           // checkIfClickedCorrect()
            changeMechanics()
        }

        upB5.setOnClickListener{
            currentClickedTile=5

            playSound()
            isClicked=true
          //  checkIfClickedCorrect()
            changeMechanics()
        }


        upB6.setOnClickListener{
            currentClickedTile=6

            playSound()
            isClicked=true
          //  checkIfClickedCorrect()
            changeMechanics()
        }


        upB7.setOnClickListener{
            currentClickedTile=7

            playSound()
            isClicked=true
          //  checkIfClickedCorrect()
            changeMechanics()
        }


        upB8.setOnClickListener{
            currentClickedTile=8

            playSound()
            isClicked=true
          //  checkIfClickedCorrect()
            changeMechanics()
        }


        upB9.setOnClickListener{
            currentClickedTile=9

            playSound()
            isClicked=true
          //  checkIfClickedCorrect()
            changeMechanics()
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
        when (currentTileToLightUp) {

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



    }
    fun displayIndex(){
        counterTextView.text = "Current: "+ (index+1)+"/10"
    }


    //Animacje


    fun animationForOne(){
            currentAnimation=1
                currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        object : CountDownTimer(1000, 1000) {
            override fun onTick(arg0: Long) {

                index=0
                currentNeededTile=currentRandomTile
                currentTileToLightUp=currentRandomTile
                changeTileColorToBlue()





            }

            override fun onFinish() {
                changeAllTileColorToBlack()
            }
        }.start()


    }
    fun animationForTwo(){
        currentAnimation=2


        currentRandomTile  = (Math.floor(Math.random()*9)+1).toInt()
        random2=currentRandomTile

        object : CountDownTimer(2000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++

                index=1

                if(countTick==1 && countTick<2){
              //      currentNeededTile= correctTiles[0]
                    currentTileToLightUp=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                //    currentNeededTile=currentRandomTile
                    currentTileToLightUp=currentRandomTile
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
        currentAnimation=3

        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        random3=currentRandomTile
        object : CountDownTimer(3000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++
                index=2


                if(countTick==1){
                 //   currentNeededTile=correctTiles[0]
                    currentTileToLightUp=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
               //     currentNeededTile=correctTiles[1]
                    currentTileToLightUp=correctTiles[1]
                    changeTileColorToBlue()
                }


                if(countTick==3){
                    changeAllTileColorToBlack()
                 //   currentNeededTile=currentRandomTile
                    currentTileToLightUp=currentRandomTile
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
        currentAnimation=4
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        random4=currentRandomTile
        object : CountDownTimer(4000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++





                index=3


                if(countTick==1){
             //       currentNeededTile=correctTiles[0]
                    currentTileToLightUp=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                  //  currentNeededTile=correctTiles[1]
                    currentTileToLightUp=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                 //   currentNeededTile=correctTiles[2]
                    currentTileToLightUp=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4) {
                    changeAllTileColorToBlack()
                 //   currentNeededTile = currentRandomTile
                    currentTileToLightUp=currentRandomTile
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
        currentAnimation=5
       currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        random5=currentRandomTile
        object : CountDownTimer(5000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++


                index=4


                if(countTick==1){
                    currentTileToLightUp=correctTiles[0]
                //    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[1]
                //    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[2]
                //    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[3]
                 //   currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5) {
                    changeAllTileColorToBlack()
                    currentTileToLightUp=currentRandomTile
                 //   currentNeededTile = currentRandomTile
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
        currentAnimation=6
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        random6=currentRandomTile
        object : CountDownTimer(6000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++


                index=5


                if(countTick==1){
                    currentTileToLightUp=correctTiles[0]
                 //   currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[1]
                  //  currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[2]
                 //   currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[3]
                 //   currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[4]
                //    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6) {
                    changeAllTileColorToBlack()
                    currentTileToLightUp=currentRandomTile
                //    currentNeededTile = currentRandomTile
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
        currentAnimation=7
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        random7=currentRandomTile
        object : CountDownTimer(7000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++


                index=6
                if(countTick==1){

                    currentTileToLightUp=correctTiles[0]
                 //   currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[1]
                 //   currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[2]
                 //   currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[3]
                 //   currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[4]
                //    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[5]
                  //  currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7) {
                    changeAllTileColorToBlack()
                    currentTileToLightUp=currentRandomTile
                 //   currentNeededTile = currentRandomTile
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
        currentAnimation=8
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        random8=currentRandomTile
        object : CountDownTimer(8000, 1000) {
            override fun onTick(arg0: Long) {

                countTick++


                index=7
                if(countTick==1){
                    currentTileToLightUp=correctTiles[0]
                  //  currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[1]
                  //  currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[2]
                 //   currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[3]
                  //  currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[4]
                  //  currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[5]
                  //  currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[6]
                  //  currentNeededTile=correctTiles[6]
                    changeTileColorToBlue()
                }

                if(countTick==8) {
                    changeAllTileColorToBlack()
                    currentTileToLightUp=currentRandomTile
                  //  currentNeededTile = currentRandomTile
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
        currentAnimation=9
        currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
        random9=currentRandomTile
        object : CountDownTimer(9000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++


                index=8
                if(countTick==1){
                    currentTileToLightUp=correctTiles[0]
                 //   currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[1]
                //    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[2]
                 //   currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[3]
                 //   currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[4]
                 //   currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[5]
                 //   currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[6]
                 //   currentNeededTile=correctTiles[6]
                    changeTileColorToBlue()
                }


                if(countTick==8){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[7]
                 //   currentNeededTile=correctTiles[7]
                    changeTileColorToBlue()
                }

                if(countTick==9) {
                    changeAllTileColorToBlack()
                    currentTileToLightUp=currentRandomTile
                 //   currentNeededTile = currentRandomTile
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
            currentAnimation=10

            currentRandomTile= (Math.floor(Math.random()*9)+1).toInt()
            random10=currentRandomTile
        object : CountDownTimer(10000, 1000) {
            override fun onTick(arg0: Long) {
                countTick++

                counterTextView.text = "Current: 10 / 10"
                index=9
                if(countTick==1){
                    currentTileToLightUp=correctTiles[0]
                //    currentNeededTile=correctTiles[0]
                    changeTileColorToBlue()
                }

                if(countTick==2){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[1]
                //    currentNeededTile=correctTiles[1]
                    changeTileColorToBlue()
                }

                if(countTick==3){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[2]
                //    currentNeededTile=correctTiles[2]
                    changeTileColorToBlue()
                }

                if(countTick==4){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[3]
                //    currentNeededTile=correctTiles[3]
                    changeTileColorToBlue()
                }

                if(countTick==5){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[4]
                //    currentNeededTile=correctTiles[4]
                    changeTileColorToBlue()
                }

                if(countTick==6){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[5]
                //    currentNeededTile=correctTiles[5]
                    changeTileColorToBlue()
                }

                if(countTick==7){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[6]
                 //   currentNeededTile=correctTiles[6]
                    changeTileColorToBlue()
                }


                if(countTick==8){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[7]
                //    currentNeededTile=correctTiles[7]
                    changeTileColorToBlue()
                }

                if(countTick==9){
                    changeAllTileColorToBlack()
                    currentTileToLightUp=correctTiles[8]
                 //   currentNeededTile=correctTiles[8]
                    changeTileColorToBlue()
                }

                if(countTick==10) {
                    changeAllTileColorToBlack()
                    currentTileToLightUp=currentRandomTile
                 //   currentNeededTile = currentRandomTile
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



        currentAnimation=0
        val fail = Intent(this, Defeat::class.java)
        fail.putExtra("Color", takedColor)
        fail.putExtra("username", takedName)
        startActivity(fail)
    }



    //trzeba dodac opcje mechanizmów które podpiete do przycisków oceniają czy jest błąd czy też nie.
    //Przedewszystkim mam tu na mysli sprawdzanie kolejnosci kombinacji

    fun changeMechanics(){

        this.cacheDir.deleteRecursively()

        if(isClicked==true){
            isClicked=false

            when(currentAnimation){
                1-> mech1()
                2-> mech2()
                3-> mech3()
                4-> mech4()
                5-> mech5()
                6-> mech6()
                7-> mech7()
                8-> mech8()
                9-> mech9()
                10-> mech10()
            }
        }
    }

    fun mech1(){




        if(currentNeededTile==currentClickedTile){

            correctTiles[index]=currentNeededTile

            changeIndex()
            displayIndex()
            changeColor(index)
            countClicks=0
        }else{
            defeat()
        }

    }

    fun mech2(){






        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }
        }else if(countClicks==1){

            if(currentClickedTile==random2){

                correctTiles[index]=random2

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }




    }

    fun mech3(){




        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }

        }else if(countClicks==2){
            if(currentClickedTile==random3){

                correctTiles[index]=random3

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }


    }

    fun mech4(){





        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }

        }else if(countClicks==2){
            if(correctTiles[2].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }

        }else if(countClicks==3){

            if(currentClickedTile==random4){

                correctTiles[index]=random4

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }



    }

    fun mech5(){




        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==2){
            if(correctTiles[2].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==3){
            if(correctTiles[3].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==4){

            if(currentClickedTile==random5){

                correctTiles[index]=random5

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }


    }

    fun mech6(){





        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==2){
            if(correctTiles[2].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==3){
            if(correctTiles[3].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==4){
            if(correctTiles[4].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==5){

            if(currentClickedTile==random6){

                correctTiles[index]=random6

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }


    }

    fun mech7(){





        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==2){
            if(correctTiles[2].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==3){
            if(correctTiles[3].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==4){
            if(correctTiles[4].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==5){
            if(correctTiles[5].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==6){

            if(currentClickedTile==random7){

                correctTiles[index]=random7

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }


    }

    fun mech8(){





        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==2){
            if(correctTiles[2].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==3){
            if(correctTiles[3].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==4){
            if(correctTiles[4].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==5){
            if(correctTiles[5].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==6){
            if(correctTiles[6].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==7){

            if(currentClickedTile==random8){

                correctTiles[index]=random8

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }


    }

    fun mech9(){






        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==2){
            if(correctTiles[2].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==3){
            if(correctTiles[3].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==4){
            if(correctTiles[4].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==5){
            if(correctTiles[5].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==6){
            if(correctTiles[6].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==7){
            if(correctTiles[7].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==8){

            if(currentClickedTile==random9){

                correctTiles[index]=random9

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
            }else{
                defeat()
            }

        }


    }

    fun mech10(){






        if(countClicks==0 ){
            if(correctTiles[0].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{

                defeat()
            }
        }else if(countClicks==1){
            if(correctTiles[1].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==2){
            if(correctTiles[2].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==3){
            if(correctTiles[3].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==4){
            if(correctTiles[4].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==5){
            if(correctTiles[5].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }else if(countClicks==6){
            if(correctTiles[6].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==7){
            if(correctTiles[7].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==8){
            if(correctTiles[8].equals(currentClickedTile)){
                countClicks=countClicks+1
            }else{
                defeat()
            }

        }
        else if(countClicks==9){

            if(currentClickedTile==random10){

                correctTiles[index]=random10

                changeIndex()
                displayIndex()
                changeColor(index)
                countClicks=0
                checkWin()
            }else{
                defeat()
            }

        }


    }


}