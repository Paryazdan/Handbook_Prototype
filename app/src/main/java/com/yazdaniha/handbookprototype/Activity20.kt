package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.ImageView

class Activity20 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_20)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent6 = Intent(this, Activity21::class.java)
            startActivity(intent6)
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity19::class.java)
            startActivity(intent7)
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,20)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
    }
}