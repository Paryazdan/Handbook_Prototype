package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Activity31 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_31)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val enterOver = findViewById<TextInputEditText>(R.id.editOver)
            if (enterOver.text.toString() == "Override") {
                val intent6 = Intent(this, Activity32::class.java)
                startActivity(intent6)
            }
            else {
                Toast.makeText(this, "Please complete the activity", Toast.LENGTH_SHORT).show()
            }
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity30::class.java)
            startActivity(intent7)
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,12)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
    }
}