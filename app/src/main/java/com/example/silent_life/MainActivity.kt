package com.example.silent_life


import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button


private var imageView: ImageView? = null
// ImageViewのインスタンス生成


val move: Int = 150//移動量

var array = IntArray(2)


class MainActivity : AppCompatActivity() {

    var scounter: Int = 0//縦移動の値
    var bcounter: Int  = 0//横移動の値



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


}
}


