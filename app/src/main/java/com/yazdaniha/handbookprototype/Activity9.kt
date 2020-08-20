package com.yazdaniha.handbookprototype

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_2.*

class Activity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Tag", "Activity 9")
        setContentView(R.layout.activity_9)
        val nextScr = findViewById<ImageView>(R.id.Start)
        nextScr.setOnClickListener{
            val intent6 = Intent(this, Activity10::class.java)
            startActivity(intent6)
            finish()
        }
        val prevScr = findViewById<ImageView>(R.id.Back)
        prevScr.setOnClickListener{
            val intent7 = Intent(this, Activity8::class.java)
            startActivity(intent7)
            finish()
        }
        val f1 = findViewById<TextView>(R.id.Field1)
        val field1 = findViewById<TextView>(R.id.Field1)
        val field2 = findViewById<TextView>(R.id.Field2)
        val field3 = findViewById<TextView>(R.id.Field3)
        val field4 = findViewById<TextView>(R.id.Field4)
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        field1.text = pref.getString("FIELD1", "Enter text here.")
        field2.text = pref.getString("FIELD2", "Enter text here.")
        field3.text = pref.getString("FIELD3", "Enter text here.")
        field4.text = pref.getString("FIELD4", "Enter text here.")
    }
    override fun onDestroy() {
        super.onDestroy()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref,9)
        Log.i("Tag", "Activity 9 closed")
        Log.i("Tag", pref.getInt("PAGE", 678).toString())
        val f1 = findViewById<TextView>(R.id.Field1)
        val field1 = findViewById<TextView>(R.id.Field1)
        val field2 = findViewById<TextView>(R.id.Field2)
        val field3 = findViewById<TextView>(R.id.Field3)
        val field4 = findViewById<TextView>(R.id.Field4)
        field1.text = f1.text.toString()
        val editor = pref.edit()
        editor.apply {
            editor.putString("FIELD1", field1.text.toString())
            editor.putString("FIELD2", field2.text.toString())
            editor.putString("FIELD3", field3.text.toString())
            editor.putString("FIELD4", field4.text.toString())
        }.apply()
    }
}