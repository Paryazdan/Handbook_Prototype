package com.yazdaniha.handbookprototype

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.SystemClock
import android.os.CountDownTimer
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.Toast

public class Global : Application() { //Stores Global values
    companion object {
        @JvmField
        //var name: String = ""
        var pageNum = 1
        var nameEntered = false
        var penActivated = false
        var eraserActivated = false
        var prevClicked = false
        var resultInt = 0
        fun pageTurn(page: ImageView, turns: IntArray) {
            var i = 0
            page.setImageResource(turns[i]) //First frame
            object : CountDownTimer(10000, 330) {
                override fun onFinish() {
                }

                override fun onTick(p0: Long) { //Subsequent frames
                    if (i <= 1) {
                        i += 1
                    }
                    page.setImageResource(turns[i])
                }
            }.start()
        }
        fun savePage(pref: SharedPreferences, pageNum: Int) {
            val editor = pref.edit()
            editor.apply {
                editor.putInt("PAGE", pageNum)
            }.apply()
        }
    }
}