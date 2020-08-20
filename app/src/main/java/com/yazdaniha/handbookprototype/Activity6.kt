package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Activity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_6)
        setButtons()
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent6 = Intent(this, Activity7::class.java)
            startActivity(intent6)
            finish()
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity5::class.java)
            startActivity(intent7)
            finish()
        }
    }
    fun setButtons() {
        val resText = findViewById<TextView>(R.id.Result)
        val b1 = findViewById<Button>(R.id.b1)
        val c1 = findViewById<ImageView>(R.id.c1)
        val b2 = findViewById<Button>(R.id.b2)
        val c2 = findViewById<ImageView>(R.id.c2)
        b1.setOnClickListener{
            enumerate(resText, c1)
        }
        b2.setOnClickListener{
            enumerate(resText, c2)
        }
    }
    fun enumerate(resText: TextView, c: ImageView) {
        if (c.alpha != 1F) {
            c.alpha = 1F
            Global.resultInt++
        }
        else {
            c.alpha = 0F
            Global.resultInt--
        }
        resText.text = Global.resultInt.toString()
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,6)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
    }
}