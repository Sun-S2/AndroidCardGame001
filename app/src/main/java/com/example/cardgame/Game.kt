package com.example.cardgame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlin.system.exitProcess


class Game : AppCompatActivity() {

    lateinit var random: Random
    lateinit var card1: ImageView
    lateinit var card2: ImageView
    lateinit var score: TextView
    lateinit var win: TextView
    lateinit var appWin: TextView
    lateinit var amountText: TextView
    //lateinit var score2: TextView
    lateinit var deal: Button
    lateinit var again: Button
    lateinit var end: Button
    var player1 = 0
    var appScore = 0
    var firstValue = 0
    var amountInt = 5
    var saved = 0
    var count = 0;
    var cardsArray = intArrayOf(
        //drawable/Cards/assets
        //R.drawable._0card,
        R.drawable._1card,
        R.drawable._2card,
        R.drawable._3card,
        R.drawable._4card,
        R.drawable._5card,
        R.drawable._6card,
        R.drawable._7card,
        R.drawable._8card,
        R.drawable._9card,
        R.drawable._0acard,
        R.drawable._1acard,
        R.drawable._2acard,
        R.drawable._3acard
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = Random
        firstValue = random.nextInt(cardsArray.size)
        //init objects
        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)
        amountText = findViewById(R.id.amountCount)

        card1.setImageResource(R.drawable._0aacard)
        card2.setImageResource(R.drawable._0card)
        amountText.text = "Antal kvar: $amountInt"
        //card2.setImageResource(cardsArray[firstValue])

        score = findViewById(R.id.score)
        //score2 = findViewById(R.id.tv_player2)




        deal = findViewById(R.id.deal)
        deal.setOnClickListener {
            //checkValue()
            Log.d("any", "this01")
            //generate cards
            if (count!=0)
            {
                card2.setImageResource(cardsArray[saved])
            }

            if (count==5)
            {
                setContentView(R.layout.end_game)
                win = findViewById(R.id.win)


                if (player1 > 2)
                    win.text = "Du vann!"
                else
                    win.text = "Appen vann!"

                again = findViewById(R.id.startAgain)
                end = findViewById(R.id.quit)

                again.setOnClickListener{
                    Log.d("any", "this02")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                end.setOnClickListener{
                    Log.d("any", "this03")
                    this@Game.finish()
                    exitProcess(0)
                }
            }

            val cardNext = random.nextInt(cardsArray.size)
            val cardFirst = saved;

            saved = cardNext
            //set images
            setCardImage(cardNext, card1)
            //setCardImage(card2, iv_card2)

            //compare values
            if (cardNext > cardFirst) {
                player1++
                score.text = "Poäng: $player1"
            } else if (cardNext < cardFirst) {
                appScore++
             //   score2.text = "Appen: $appScore"
                player1--
                score.text = "Poäng: $player1"
            }
            amountInt--
            amountText.text = "Antal kvar: $amountInt"
            count++
        }
    }

    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardsArray[number])
    }
}