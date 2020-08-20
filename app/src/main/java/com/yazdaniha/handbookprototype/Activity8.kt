package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout
import android.widget.Toast

class Activity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_8)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent6 = Intent(this, Activity9::class.java)
            startActivity(intent6)
            finish()
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity7::class.java)
            startActivity(intent7)
            finish()
        }
        var path = Path()
        var pen = Paint()
        var canvas = Canvas()
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,8)
        Log.i("Tag", pref.getInt("PAGE", 678).toString())
    }
}