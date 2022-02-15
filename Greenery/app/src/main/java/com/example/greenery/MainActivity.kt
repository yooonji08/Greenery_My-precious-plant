package com.example.greenery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var main_plusPlantButton: ImageView // 식물 추가 버튼
    private lateinit var main_plusDiaryButton: ImageView // 식물 일기 추가 버튼

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_plusPlantButton = findViewById(R.id.main_plusPlantButton)
        main_plusDiaryButton = findViewById(R.id.main_plusDiaryButton)

        // 커스텀 툴바
        setCustomToolBar(R.id.include_toolbar)

        // 툴바 내 메뉴 클릭 이벤트
        main_plusPlantButton.setOnClickListener { // 식물 추가 버튼 클릭
            Toast.makeText(this, "식물 추가!", Toast.LENGTH_SHORT).show()
        }
        main_plusDiaryButton.setOnClickListener { // 식물 일기 추가 버튼 클릭
            Toast.makeText(this, "식물 일기 추가!", Toast.LENGTH_SHORT).show()
        }

        // 현재 화면을 시작 화면으로 설정
        NavigationBarView.OnItemSelectedListener { item ->
            onNavigationItemSelected(item)
        }
    }

    // 커스텀 툴바 적용
    private fun setCustomToolBar(layout: Int) {

        val toolbar: Toolbar = findViewById(layout)

        setSupportActionBar(toolbar) // 커스텀 툴바 적용
        val actionBar = supportActionBar
        actionBar?.setDisplayShowTitleEnabled(false) // 앱 이름 숨기기
    }

    // 하단 네비게이션 클릭 이벤트
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menu_my_plant -> { // 내 식물 목록
                Toast.makeText(this, "식물목록", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_to_do -> { // 오늘 할 일
                Toast.makeText(this, "오늘 할 일", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_dictionary -> { // 사전
                Toast.makeText(this, "사전", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_community -> { // 커뮤니티
                Toast.makeText(this, "커뮤니티", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_profile -> { // 프로필
                Toast.makeText(this, "프로필", Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return false
    }

    // 아래 코드는 툴바에 있는 메뉴를 menu파일로 따로 만들었을 경우 사용
    // 커스텀 툴바의 메뉴 설정
    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // 메뉴 레이아웃 적용
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_myplant_navigation, menu)

        // 식물추가 메뉴 클릭 이벤트 설정
        val plusPlantMenu = menu?.findItem(R.id.menu_plusPlant)
        plusPlantMenu?.actionView?.setOnClickListener {
            onOptionsItemSelected(plusPlantMenu)
        }
        // 식물일기추가 메뉴 클릭 이벤트 설정
        val plusDiaryMenu = menu?.findItem(R.id.menu_plusDiary)
        plusDiaryMenu?.actionView?.setOnClickListener {
            onOptionsItemSelected(plusDiaryMenu)
        }

        return super.onCreateOptionsMenu(menu)
    }

    // 커스텀 툴바의 메뉴 클릭 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menu_plusPlant -> { // 내 식물 추가
                Toast.makeText(this, "플러스버튼", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_plusDiary -> { // 식물 일기 추가
                Toast.makeText(this, "일기버튼", Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }*/
}