package com.example.silent_life

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout




class MainActivity : AppCompatActivity() {
    // キーボード表示を制御するためのオブジェクト
    private lateinit var inputMethodManager: InputMethodManager
    // 背景のレイアウト
    lateinit var container:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //背景のレイアウトを取得
        container = findViewById(R.id.container)
        // InputMethodManagerを取得
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val editText:EditText= findViewById(R.id.editText)

        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code

                // キーボードを隠す
                inputMethodManager.hideSoftInputFromWindow(container.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)

                // 背景にフォーカスを移す
                container.requestFocus()

                return@OnKeyListener true
            }
            false
        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        // キーボードを隠す
        inputMethodManager.hideSoftInputFromWindow(container.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)

        // 背景にフォーカスを移す
        container.requestFocus()

        return false
    }


}

