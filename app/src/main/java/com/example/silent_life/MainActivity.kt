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
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.balloon
import com.skydoves.balloon.createBalloon


private var imageView: ImageView? = null
// ImageViewのインスタンス生成


val move: Int = 150//移動量

var array = IntArray(2)

class MainActivity : AppCompatActivity() {
    var scounter: Int = 0//縦移動の値
    var bcounter: Int  = 0//横移動の値
    // キーボード表示を制御するためのオブジェクト
    private lateinit var inputMethodManager: InputMethodManager

    // 背景のレイアウト
    lateinit var container: ConstraintLayout

    //吹き出しの数仮管理
    var chatCount: Int = 0
    var delete: Int = 0

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタン認識
        val upbutton = findViewById<Button>(R.id.upb)//上ボタン
        val dwbutton = findViewById<Button>(R.id.dwb)//下ボタン
        val rbutton =  findViewById<Button>(R.id.rb)//右ボタン
        val lbutton =  findViewById<Button>(R.id.lb)//左ボタン
        imageView = findViewById(R.id.image)

        //imageView!!.x = 200F
        //imageView!!.y = 300F


        //アイコンの移動用変数
        var left: Int = 0
        var top: Int = 0
        var right: Int = 0
        var bottom: Int = 0
        imageView!!.verticalScrollbarPosition

        //fun Window

        upbutton.setOnClickListener{//上ボタン
            scounter -=move
            left = bcounter
            top = scounter
            right = bcounter + imageView!!.getWidth()
            bottom =  scounter + imageView!!.getHeight()
            imageView!!.layout(left, top, right, bottom)
        }

        dwbutton.setOnClickListener{//下ボタン
            scounter += move
            left = bcounter
            top = scounter
            right = bcounter + imageView!!.getWidth()
            bottom =  scounter + imageView!!.getHeight()
            imageView!!.layout(left, top, right, bottom)
        }

        lbutton.setOnClickListener{//左ボタン
            bcounter -= move
            left = bcounter
            top = scounter
            right =  bcounter + imageView!!.getWidth()
            bottom = scounter + imageView!!.getHeight()
            imageView!!.layout(left, top, right, bottom)
        }

        rbutton.setOnClickListener{//右ボタン
            bcounter += move
            left = bcounter
            top = scounter
            right =  bcounter + imageView!!.getWidth()
            bottom = scounter + imageView!!.getHeight()
            imageView!!.layout(left, top, right, bottom)
        }

        val sendButton: ImageButton = findViewById(R.id.sendButton)
        val messages = mutableListOf<String>()


        //背景のレイアウトを取得
        container = findViewById(R.id.container)
        // InputMethodManagerを取得
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val editText: EditText = findViewById(R.id.editText)

        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                chatCount += 1
                messages.add(editText.text.toString())

                if (chatCount == 1) {
                    leaveText()
                    val balloon = createBalloon(baseContext) {
                        setArrowSize(10)
                        setWidthRatio(0.5f)
                        setHeight(65)
                        setArrowPosition(0.5f)
                        setCornerRadius(4f)
                        setAlpha(1.0f)
                        setText(messages[0])
                        setBackgroundColorResource(R.color.white)
                        setTextColor(R.color.black)
                        setBalloonAnimation(BalloonAnimation.FADE)
//                        setLifecycleOwner(this@MainActivity)
                        setDismissWhenTouchOutside(false)//キーボードタップで消されない
                    }
                    //テキストの中身を空にする
                    editText.text.clear()
                    balloon.showAlignTop(findViewById(R.id.imageView), 0, 0)

                } else if (chatCount == 2) {
                    leaveText()
                    val balloon = createBalloon(baseContext) {
                        setArrowSize(10)
                        setWidthRatio(0.5f)
                        setHeight(65)
                        setArrowPosition(0.5f)
                        setCornerRadius(4f)
                        setAlpha(1.0f)
                        setText(messages[1])
                        setBackgroundColorResource(R.color.white)
                        setTextColor(R.color.black)
                        setBalloonAnimation(BalloonAnimation.FADE)
//                        setLifecycleOwner(this@MainActivity)
                        setDismissWhenTouchOutside(false)//キーボードタップで消されない
                    }
                    //テキストの中身を空にする
                    editText.text.clear()
                    balloon.showAlignTop(findViewById(R.id.imageView), 0, 0)

                    val balloon2 = createBalloon(baseContext) {
                        setArrowSize(10)
                        setWidthRatio(0.5f)
                        setHeight(65)
                        setArrowPosition(0.5f)
                        setCornerRadius(4f)
                        setAlpha(1.0f)
                        setText(messages[0])
                        setBackgroundColorResource(R.color.white)
                        setTextColor(R.color.black)
                        setBalloonAnimation(BalloonAnimation.FADE)
//                        setLifecycleOwner(this@MainActivity)
                        setDismissWhenTouchOutside(false)//キーボードタップで消されない
                    }
                    balloon2.showAlignTop(findViewById(R.id.imageView), 0, -150)
                } else if (chatCount == 3) {
                    leaveText()
                    val balloon = createBalloon(baseContext) {
                        setArrowSize(10)
                        setWidthRatio(0.5f)
                        setHeight(65)
                        setArrowPosition(0.5f)
                        setCornerRadius(4f)
                        setAlpha(1.0f)
                        setText(messages[2])
                        setBackgroundColorResource(R.color.white)
                        setBalloonAnimation(BalloonAnimation.FADE)
                        setTextColor(R.color.black)
//                        setLifecycleOwner(this@MainActivity)
                        setDismissWhenTouchOutside(false)//キーボードタップで消されない
                    }
                    //テキストの中身を空にする
                    editText.text.clear()
                    balloon.showAlignTop(findViewById(R.id.imageView), 0, 0)

                    val balloon2 = createBalloon(baseContext) {
                        setArrowSize(10)
                        setWidthRatio(0.5f)
                        setHeight(65)
                        setArrowPosition(0.5f)
                        setCornerRadius(4f)
                        setAlpha(1.0f)
                        setText(messages[1])
                        setBackgroundColorResource(R.color.white)
                        setTextColor(R.color.black)
                        setBalloonAnimation(BalloonAnimation.FADE)
//                        setLifecycleOwner(this@MainActivity)
                        setDismissWhenTouchOutside(false)//キーボードタップで消されない
                    }
                    balloon2.showAlignTop(findViewById(R.id.imageView), 0, -150)

                    val balloon3 = createBalloon(baseContext) {
                        setArrowSize(10)
                        setWidthRatio(0.5f)
                        setHeight(65)
                        setArrowPosition(0.5f)
                        setCornerRadius(4f)
                        setAlpha(1.0f)
                        setText(messages[0])
                        setBackgroundColorResource(R.color.white)
                        setTextColor(R.color.black)
                        setBalloonAnimation(BalloonAnimation.FADE)
//                        setLifecycleOwner(this@MainActivity)
                        setDismissWhenTouchOutside(false)//キーボードタップで消されない
                    }
                    balloon3.showAlignTop(findViewById(R.id.imageView), 0, -300)
                } else {

                }
                return@OnKeyListener true
            }
            false
        })

        sendButton.setOnClickListener() {
            leaveText()
            val balloon = createBalloon(baseContext) {
                setArrowSize(10)
                setWidthRatio(0.5f)
                setHeight(65)
                setArrowPosition(0.5f)
                setCornerRadius(4f)
                setAlpha(0.9f)
                setText(editText.text)
                setBackgroundColor(R.color.white)
                setBalloonAnimation(BalloonAnimation.FADE)
                setLifecycleOwner(this@MainActivity)
                setDismissWhenTouchOutside(false)//キーボードタップで消されない
            }
            //テキストの中身を空にする
            editText.text.clear()
            balloon.showAlignTop(findViewById(R.id.imageView))
        }
    }

    //画面の背景に触れた時の処理
    override fun onTouchEvent(event: MotionEvent): Boolean {

        leaveText()

        return false
    }


    fun leaveText() {

        // キーボードを隠す
        inputMethodManager.hideSoftInputFromWindow(
            container.getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS
        )

        // 背景にフォーカスを移す
        container.requestFocus()
    }

    fun delete(balloon:Balloon){
        balloon.dismiss()
    }


}



