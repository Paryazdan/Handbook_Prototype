package com.yazdaniha.handbookprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView

class Activity26 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_26)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent6 = Intent(this, Activity27::class.java)
            startActivity(intent6)
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity25::class.java)
            startActivity(intent7)
            finish()
        }
    }
}