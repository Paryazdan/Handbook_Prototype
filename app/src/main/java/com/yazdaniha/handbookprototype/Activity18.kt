package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText

class Activity18 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_18)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            //val intent6 = Intent(this, Activity19::class.java)
            //startActivity(intent6)
            val intent = Intent(this, Activity31::class.java)
            startActivity(intent)
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity17::class.java)
            startActivity(intent7)
            finish()
        }
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        val f13 = findViewById<TextInputEditText>(R.id.editF13)
        val f14 = findViewById<TextInputEditText>(R.id.editF14)
        val f15 = findViewById<TextInputEditText>(R.id.editF15)
        val f16 = findViewById<TextInputEditText>(R.id.editF16)
        val f17 = findViewById<TextInputEditText>(R.id.editF17)
        f13.setText(pref.getString("FIELD13", "Enter text"))
        f14.setText(pref.getString("FIELD14", "Enter text"))
        f15.setText(pref.getString("FIELD15", "Enter text"))
        f16.setText(pref.getString("FIELD16", "Enter text"))
        f17.setText(pref.getString("FIELD17", "Enter text"))
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,18)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
        val f13 = findViewById<TextInputEditText>(R.id.editF13)
        val f14 = findViewById<TextInputEditText>(R.id.editF14)
        val f15 = findViewById<TextInputEditText>(R.id.editF15)
        val f16 = findViewById<TextInputEditText>(R.id.editF16)
        val f17 = findViewById<TextInputEditText>(R.id.editF17)
        val editor = pref.edit()
        editor.apply {
            editor.putString("FIELD13", f13.text.toString())
            editor.putString("FIELD14", f14.text.toString())
            editor.putString("FIELD15", f15.text.toString())
            editor.putString("FIELD16", f16.text.toString())
            editor.putString("FIELD17", f17.text.toString())
        }.apply()
    }
}
