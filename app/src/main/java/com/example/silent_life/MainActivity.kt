package com.example.silent_life

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.balloon
import com.skydoves.balloon.createBalloon


class MainActivity : AppCompatActivity() {
    // キーボード表示を制御するためのオブジェクト
    private lateinit var inputMethodManager: InputMethodManager

    // 背景のレイアウト
    lateinit var container: ConstraintLayout

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sendButton: ImageButton = findViewById(R.id.sendButton)


        val balloon = createBalloon(baseContext) {
            setArrowSize(10)
            setWidthRatio(0.5f)
            setHeight(65)
            setArrowPosition(0.5f)
            setCornerRadius(4f)
            setAlpha(0.9f)
            setText("Hello, Balloon!")
            setBackgroundColor(R.color.white)
            setBalloonAnimation(BalloonAnimation.FADE)
            setLifecycleOwner(this@MainActivity)
        }



        //背景のレイアウトを取得
        container = findViewById(R.id.container)
        // InputMethodManagerを取得
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val editText: EditText = findViewById(R.id.editText)

        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                inputText()
                //テキストの中身を空にする
                editText.text.clear()

                return@OnKeyListener true
            }
            false
        })

        sendButton.setOnClickListener() {
            inputText()
            //テキストの中身を空にする
            editText.text.clear()
            balloon.showAlignTop(findViewById(R.id.imageView))
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        inputText()

        return false
    }


    fun inputText() {
        // キーボードを隠す
        inputMethodManager.hideSoftInputFromWindow(
            container.getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS
        )

        // 背景にフォーカスを移す
        container.requestFocus()
    }




}

