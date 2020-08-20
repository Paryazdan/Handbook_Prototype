package com.yazdaniha.handbookprototype

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Activity4a : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity4a)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent4 = Intent(this, Activity5::class.java)
            startActivity(intent4)
            finish()
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent5 = Intent(this, Activity3::class.java)
            startActivity(intent5)
            finish()
        }
        setButtons()
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref, 4)
        Log.i("Tag", pref.getInt("PAGE", 678).toString())
    }
    private fun setButtons() {
        //Find views by button id
        //Set on click listeners linking to nav
        val b1 = findViewById<Button>(R.id.b1)
        b1.setOnClickListener{
            Nav(1)
        }
    }
    private fun Nav(page: Int) {
        when(page) {
            1 -> {val intent = Intent(this, Activity6::class.java) //Page 1 is activity6 in the ToC
                startActivity(intent)
                Toast.makeText(this, "Switch to page 6", Toast.LENGTH_SHORT).show()}
            2 -> {val intent = Intent(this, Activity7::class.java)
                startActivity(intent)}
            3 -> {val intent = Intent(this, Activity8::class.java)
                startActivity(intent)}
            4 -> {val intent = Intent(this, Activity9::class.java)
                startActivity(intent)}
            5 -> {val intent = Intent(this, Activity10::class.java)
                startActivity(intent)}
            6 -> {val intent = Intent(this, Activity11::class.java)
                startActivity(intent)}
            7 -> {val intent = Intent(this, Activity12::class.java)
                startActivity(intent)}
            8 -> {val intent = Intent(this, Activity13::class.java)
                startActivity(intent)}
            9 -> {val intent = Intent(this, Activity14::class.java)
                startActivity(intent)}
            10 -> {val intent = Intent(this, Activity15::class.java)
                startActivity(intent)}
            11 -> {val intent = Intent(this, Activity16::class.java)
                startActivity(intent)}
            12 -> {val intent = Intent(this, Activity17::class.java)
                startActivity(intent)}
            13 -> {val intent = Intent(this, Activity18::class.java)
                startActivity(intent)}
            14 -> {val intent = Intent(this, Activity19::class.java)
                startActivity(intent)}
            15 -> {val intent = Intent(this, Activity20::class.java)
                startActivity(intent)}
            16 -> {val intent = Intent(this, Activity21::class.java)
                startActivity(intent)}
            17 -> {val intent = Intent(this, Activity22::class.java)
                startActivity(intent)}
            18 -> {val intent = Intent(this, Activity23::class.java)
                startActivity(intent)}
            19 -> {val intent = Intent(this, Activity24::class.java)
                startActivity(intent)}
            20 -> {val intent = Intent(this, Activity25::class.java)
                startActivity(intent)}
            21 -> {val intent = Intent(this, Activity26::class.java)
                startActivity(intent)}
            22 -> {val intent = Intent(this, Activity27::class.java)
                startActivity(intent)}
            23 -> {val intent = Intent(this, Activity28::class.java)
                startActivity(intent)}
            24 -> {val intent = Intent(this, Activity29::class.java)
                startActivity(intent)}
            25 -> {val intent = Intent(this, Activity30::class.java)
                startActivity(intent)}
            26 -> {val intent = Intent(this, Activity31::class.java)
                startActivity(intent)}
            27 -> Toast.makeText(this, "Please complete the entirety of the handbook", Toast.LENGTH_SHORT).show() //Not needed
        }
    }
}