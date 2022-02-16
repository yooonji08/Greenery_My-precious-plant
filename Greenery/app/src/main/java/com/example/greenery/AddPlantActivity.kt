package com.example.greenery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AddPlantActivity : AppCompatActivity() {

    // 툴바 제목
    lateinit var sub_titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plant)

        sub_titleTextView = findViewById(R.id.sub_titleTextView)

        sub_titleTextView.text = "식물 등록하기"
    }
}