package com.yazdaniha.handbookprototype

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        Global.prevClicked = false
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent = Intent(this, Activity4a::class.java)
            startActivity(intent)
            finish()
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val enterName = Intent(this, Activity2::class.java)
            val firstPage = Intent(this, MainActivity::class.java)
            //startActivity(firstPage)
            val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
            if (pref.getBoolean("ENTERED", false) != true) {
                startActivity(enterName)
            }
            else {
                val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
                Global.savePage(pref,1) //Necessary for switching to first page
                Global.prevClicked = true
                startActivity(firstPage)
            }
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        if (Global.prevClicked == false) {
            val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
            Global.savePage(pref, 3)
        }
    }
}