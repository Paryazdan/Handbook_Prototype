package com.yazdaniha.handbookprototype

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val nextScr = findViewById<ImageView>(R.id.Start)
        val textInput = findViewById<TextInputEditText>(R.id.editName)
        /*textInput.setOnKeyListener { v, i, keyEvent ->
            if (i == KeyEvent.KEYCODE_ENTER) {
                Global.name = textInput.text.toString()
                Toast.makeText(this, "Submitted "+Global.name+". Continue forward.", Toast.LENGTH_SHORT).show()
                true
            }
            else {
                false
            }
        }*/
        nextScr.setOnClickListener{
            val intent = Intent(this, Activity3::class.java)
            //Global.name = textInput.text.toString()
            if (textInput.text.toString() == "") {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
            }
            else {
                Global.nameEntered = true
                saveData()
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        //Toast.makeText(this, "Back pressed", Toast.LENGTH_SHORT).show()
        finish()
        val intent2 = Intent(this, MainActivity::class.java)
        val page = findViewById<ImageView>(R.id.Screen2)
        val pages = intArrayOf(R.drawable.page1t1,R.drawable.page1t2,R.drawable.page1t3)
        Global.pageTurn(page, pages)
        startActivity(intent2)
        return super.onKeyDown(keyCode, event)
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        //editName.setText(pref.getString("NAME", null))
        //editName.setText("Name entered")
    }

    private fun saveData() {
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE) //Everything is stored in app data
        val editor = pref.edit()
        editor.apply {
            editor.putString("NAME", editName.text.toString())
            //editor.putInt("PAGE", pageNum)
            if (Global.nameEntered) {
                editor.putBoolean("ENTERED", true)
            }
        }.apply()
    }
}