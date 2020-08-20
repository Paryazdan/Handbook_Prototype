package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText

class Activity14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_14)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent6 = Intent(this, Activity15::class.java)
            startActivity(intent6)
            finish()
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity13::class.java)
            startActivity(intent7)
            finish()
        }
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        val f5 = findViewById<TextInputEditText>(R.id.editF5)
        val f6 = findViewById<TextInputEditText>(R.id.editF6)
        val f7 = findViewById<TextInputEditText>(R.id.editF7)
        val f8 = findViewById<TextInputEditText>(R.id.editF8)
        val f9 = findViewById<TextInputEditText>(R.id.editF9)
        val f10 = findViewById<TextInputEditText>(R.id.editF10)
        val f11 = findViewById<TextInputEditText>(R.id.editF11)
        val f12 = findViewById<TextInputEditText>(R.id.editF12)
        f5.setText(pref.getString("FIELD5", "Enter text"))
        f6.setText(pref.getString("FIELD6", "Enter text"))
        f7.setText(pref.getString("FIELD7", "Enter text"))
        f8.setText(pref.getString("FIELD8", "Enter text"))
        f9.setText(pref.getString("FIELD9", "Enter text"))
        f10.setText(pref.getString("FIELD10", "Enter text"))
        f11.setText(pref.getString("FIELD11", "Enter text"))
        f12.setText(pref.getString("FIELD12", "Enter text"))
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,14)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
        val f5 = findViewById<TextInputEditText>(R.id.editF5)
        val f6 = findViewById<TextInputEditText>(R.id.editF6)
        val f7 = findViewById<TextInputEditText>(R.id.editF7)
        val f8 = findViewById<TextInputEditText>(R.id.editF8)
        val f9 = findViewById<TextInputEditText>(R.id.editF9)
        val f10 = findViewById<TextInputEditText>(R.id.editF10)
        val f11 = findViewById<TextInputEditText>(R.id.editF11)
        val f12 = findViewById<TextInputEditText>(R.id.editF12)
        val editor = pref.edit()
        editor.apply {
            editor.putString("FIELD5", f5.text.toString())
            editor.putString("FIELD6", f6.text.toString())
            editor.putString("FIELD7", f7.text.toString())
            editor.putString("FIELD8", f8.text.toString())
            editor.putString("FIELD9", f9.text.toString())
            editor.putString("FIELD10", f10.text.toString())
            editor.putString("FIELD11", f11.text.toString())
            editor.putString("FIELD12", f12.text.toString())
        }.apply()
    }
}