package com.yazdaniha.handbookprototype

import android.content.Context
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.icu.util.UniversalTimeScale.toLong
import android.os.Build
import android.os.SystemClock
import android.transition.Scene
import android.util.Log
import android.view.*
import android.view.MotionEvent
import android.widget.*
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_2.*
import com.yazdaniha.handbookprototype.Global.Companion as Global

class MainActivity : AppCompatActivity() {

    /*lateinit var shapeDrawable : ShapeDrawable
    private val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
    private val canvas: Canvas = Canvas(bitmap)
    private var posX = 0.0
    private var posY = 0.0
    private val pen = Paint().apply {
        color = Color.GREEN
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
    }
    private var path = Path()*/
    private var menuIter: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Tag", "onCreate")
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        setContentView(R.layout.activity_main)
        Log.i("Tag", pref.getInt("PAGE", 628).toString())
        when (pref.getInt("PAGE", 1)) { //Location within handbook is saved onDestroy
            1 -> {val intent = Intent(this, MainActivity::class.java)}
            2 -> {val intent = Intent(this, Activity2::class.java)
            startActivity(intent)}
            3 -> {val intent = Intent(this, Activity3::class.java)
                startActivity(intent)}
            4 -> {val intent = Intent(this, Activity4a::class.java)
                startActivity(intent)
            Log.i("Tag", "Switch to page 4")}
            5 -> {val intent = Intent(this, Activity5::class.java)
                startActivity(intent)}
            6 -> {val intent = Intent(this, Activity6::class.java)
                startActivity(intent)}
            7 -> {val intent = Intent(this, Activity7::class.java)
                startActivity(intent)}
            8 -> {val intent = Intent(this, Activity8::class.java)
                startActivity(intent)}
            9 -> {val intent = Intent(this, Activity9::class.java)
                startActivity(intent)}
            10 -> {val intent = Intent(this, Activity10::class.java)
                startActivity(intent)}
            11 -> {val intent = Intent(this, Activity11::class.java)
                startActivity(intent)}
            12 -> {val intent = Intent(this, Activity12::class.java)
                startActivity(intent)}
            13 -> {val intent = Intent(this, Activity13::class.java)
                startActivity(intent)}
            14 -> {val intent = Intent(this, Activity14::class.java)
                startActivity(intent)}
            15 -> {val intent = Intent(this, Activity15::class.java)
                startActivity(intent)}
            16 -> {val intent = Intent(this, Activity16::class.java)
                startActivity(intent)}
            17 -> {val intent = Intent(this, Activity17::class.java)
                startActivity(intent)}
            18 -> {val intent = Intent(this, Activity18::class.java)
                startActivity(intent)}
            19 -> {val intent = Intent(this, Activity19::class.java)
                startActivity(intent)}
            20 -> {val intent = Intent(this, Activity20::class.java)
                startActivity(intent)}
            21 -> {val intent = Intent(this, Activity21::class.java)
                startActivity(intent)}
            22 -> {val intent = Intent(this, Activity22::class.java)
                startActivity(intent)}
            23 -> {val intent = Intent(this, Activity23::class.java)
                startActivity(intent)}
            24 -> {val intent = Intent(this, Activity24::class.java)
                startActivity(intent)}
            25 -> {val intent = Intent(this, Activity25::class.java)
                startActivity(intent)}
            26 -> {val intent = Intent(this, Activity26::class.java)
                startActivity(intent)}
            27 -> {val intent = Intent(this, Activity27::class.java)
                startActivity(intent)}
            28 -> {val intent = Intent(this, Activity28::class.java)
                startActivity(intent)}
            29 -> {val intent = Intent(this, Activity29::class.java)
                startActivity(intent)}
            30 -> {val intent = Intent(this, Activity30::class.java)
                startActivity(intent)}
            31 -> {val intent = Intent(this, Activity31::class.java)
                startActivity(intent)}
            32 -> {val intent = Intent(this, Activity32::class.java)
                startActivity(intent)}
        }
        val nextScr = findViewById<ImageView>(R.id.Start)
        //val test = findViewById<TextView>(R.id.textView6)
        nextScr.setOnClickListener{
            //test.text = "True" //Pauses for enough time to view this change
            val enterName = Intent(this, Activity2::class.java)
            val thirdPage = Intent(this, Activity3::class.java)
            val page = findViewById<ImageView>(R.id.Screen1)
            val pages = intArrayOf(R.drawable.page1t1,R.drawable.page1t2,R.drawable.page1t3)
            if (pref.getBoolean("ENTERED", false) != true) {
                Global.pageTurn(page, pages)
                startActivity(enterName)
                //overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            }
            else {
                Global.pageTurn(page, pages)
                startActivity(thirdPage)
            }
            finish()
        }
        val menu = findViewById<ImageView>(R.id.Menu)
        menu.setOnClickListener{
            val pen = findViewById<ImageView>(R.id.Pen)
            val eraser = findViewById<ImageView>(R.id.Eraser)
            val colorChoice = findViewById<ImageView>(R.id.Colorchoice)
            menuIter++
            if (menuIter % 2 == 0) {
                pen.visibility = View.VISIBLE
                eraser.visibility = View.VISIBLE
                colorChoice.visibility = View.VISIBLE
            }
            else {
                pen.visibility = View.INVISIBLE
                eraser.visibility = View.INVISIBLE
                colorChoice.visibility = View.INVISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Tag", "onDestroy")
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        Global.savePage(pref, 1)
    }
    //Testing out drawing on screen
    /*@RequiresApi(Build.VERSION_CODES.M)
    override fun onTouchEvent(event: MotionEvent): Boolean {
        posX = event.x.toDouble()
        posY = event.y.toDouble()
        when (event.action) { //Location within handbook is saved onDestroy
            MotionEvent.ACTION_DOWN -> touch()
            MotionEvent.ACTION_MOVE -> touchDrag()
            MotionEvent.ACTION_UP -> touchUp()
        }
        //Toast.makeText(this, "Screen dragged at "+event.x.toString()+", "+event.y.toString(), Toast.LENGTH_SHORT).show()
        canvas.drawPath(path, pen)
        return super.onTouchEvent(event)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun touch() {
        Toast.makeText(this, "Screen pressed at "+posX.toString()+", "+posY.toString(), Toast.LENGTH_SHORT).show()
        val bg = findViewById<ImageView>(R.id.Screen1)
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds((10+posX).toInt(), (10+posY).toInt(), (20+posX).toInt(),
            (20+posY).toInt()
        ) //Width = r-l, Height = b-t
        shapeDrawable.getPaint().setColor(Color.parseColor("#009944"))
        shapeDrawable.draw(canvas)
        canvas.drawRect(posX.toFloat(), posY.toFloat(), (posX+10).toFloat(), (posY+10).toFloat(), pen)
        bg.foreground = BitmapDrawable(getResources(), bitmap)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun touchDrag() {
        val bg = findViewById<ImageView>(R.id.Screen1)
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds((10+posX).toInt(), (10+posY).toInt(), (20+posX).toInt(),
            (20+posY).toInt()
        ) //Width = r-l, Height = b-t; left,top,right,bottom
        shapeDrawable.getPaint().setColor(Color.parseColor("#009944"))
        shapeDrawable.draw(canvas)
        bg.foreground = BitmapDrawable(getResources(), bitmap)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun touchUp() {
        val bg = findViewById<ImageView>(R.id.Screen1)
        //bg.foreground = BitmapDrawable(getResources(), bitmap)
    }*/
    private fun saveData() {
        val pref = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE) //Everything is stored in app data
        val editor = pref.edit()
        editor.apply {
            editor.putInt("PAGE", 1)
        }.apply()
    }
}