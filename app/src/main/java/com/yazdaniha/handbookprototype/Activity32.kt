package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class Activity32 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_32)
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity31::class.java)
            startActivity(intent7)
            finish()
        }
        val finName = findViewById<TextView>(R.id.finalName)
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        finName.text = pref.getString("NAME", "Default Name")
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,12)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
    }
}