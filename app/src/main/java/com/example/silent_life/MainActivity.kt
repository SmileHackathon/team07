package com.example.silent_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private var layoutParams: LinearLayout.LayoutParams? = null
    private var imageView: ImageView? = null
    private var imageWidth = 0
    private var imageHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // リニアレイアウトのインスタンス生成
    val layout = LinearLayout(this)

    //垂直方向にレイアウト内のパーツを並べる設定とする
    layout.orientation = LinearLayout.VERTICAL

    //レイアウトの縦横サイズをMATCH_PARENTにする
    layout.layoutParams = LinearLayout.LayoutParams(
    LinearLayout.LayoutParams.MATCH_PARENT,
    LinearLayout.LayoutParams.MATCH_PARENT
    )

    //setContentViewにlayoutを設定
    setContentView(layout)


    // ImageViewのインスタンス生成
    imageView = ImageView(this);
    imageView?.setImageResource(R.drawable.avatar1)
    // droid
    //imageView.setImageResource(R.drawable.ic_launcher);

    // 元画像の1/2
    imageWidth = 300
    imageHeight = 300

    //画像の縦横サイズをimageViewのサイズとして設定
    layoutParams = LinearLayout.LayoutParams(imageWidth, imageHeight)
    imageView?.setLayoutParams(layoutParams)

    //layoutにimageViewを追加
    layout.addView(imageView)

    // lambda
    imageView?.setOnClickListener { v ->
        // 画像タップ毎に画像を拡大
        imageWidth += 200
        imageHeight += 200
        layoutParams = LinearLayout.LayoutParams(imageWidth, imageHeight)
        imageView?.setLayoutParams(layoutParams)
    }
}
}