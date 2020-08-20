package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText

class Activity19 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_19)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent6 = Intent(this, Activity20::class.java)
            startActivity(intent6)
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity18::class.java)
            startActivity(intent7)
            finish()
        }
        val f18 = findViewById<TextInputEditText>(R.id.editF13)
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        f18.setText(pref.getString("FIELD18", "Enter text"))
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,19)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
        val f18 = findViewById<TextInputEditText>(R.id.editF13)
        val editor = pref.edit()
        editor.apply {
            editor.putString("FIELD18", f18.text.toString())
        }.apply()
    }
}