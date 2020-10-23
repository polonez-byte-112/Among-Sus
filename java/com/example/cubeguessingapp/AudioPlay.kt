package com.example.cubeguessingapp

import android.content.Context
import android.media.MediaPlayer



object AudioPlay {
    /**
     * I got problem with changing music from Another Activity
     * but I found a solution which is code below.
     * Link to author : https://stackoverflow.com/questions/16690057/how-can-i-stop-media-player-in-another-activity
     */
    var mediaPlayer: MediaPlayer? = null
    var lastResource: Int? = null

    fun playAudio(c: Context, id: Int, isLooping: Boolean = true) {
        createMediaPlayer(c, id)

        mediaPlayer?.let {
            it.isLooping = isLooping

            if (!it.isPlaying) {
                it.start()
            }
        }
    }

    private fun createMediaPlayer(c: Context, id: Int) {
        // jezeli juz gra  ( z automatu przyjmujemy ze ktos uruchomił nowe audio  nie zatrzymujac poprzedniego)
        mediaPlayer?.stop()

        mediaPlayer = MediaPlayer.create(c, id)
        lastResource = id
    }

    // zazwyczaj uzywane w metodzie onResume
    fun continuePlaying(c: Context, specificResource: Int? = null) {
        specificResource?.let {
            if (lastResource != specificResource) {
                //jezeli kontynujemy granie i zrodło jest inne to od nowa
                createMediaPlayer(c, specificResource)
            }
        }
// let odpala block kodu z  wartosciami tego obiektu (tut mediaPlayer)  a it sie odwołuje do tego jak this z JFrame

        //jezeli nie gra to uruchamiamy :)
        mediaPlayer?.let {
            if (!it.isPlaying) {
                it.start()
            }
        }
    }

    fun stopAudio() {
        // nie potrzebne w sytuacjach kiedy uruchamiamy nowe audio ale przydatne kiedy nie chcemy juz nic puszczac
        mediaPlayer?.stop()
    }

    fun pauseAudio(){
        mediaPlayer?.pause()
    }

}