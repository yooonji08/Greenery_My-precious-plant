package com.example.greenery

import android.graphics.drawable.GradientDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationBarView

// 뒤로가기 버튼과 연관된 상수
private const val TIME_INTERVAL = 2000 // 1,2번째 버튼 클릭 사이의 시간차

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    // 툴바의 메뉴
    private lateinit var main_plusPlantButton: ImageView // 식물 추가 버튼
    private lateinit var main_plusDiaryButton: ImageView // 식물 일기 추가 버튼

    // 리사이클러뷰(식물 카드뷰)
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    // 뒤로가기 버튼과 연관된 변수
    private var backPressedTime: Long = 0 // '뒤로가기'버튼을 클릭했을 때의 시간

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

        // 뷰매니저 설정
        viewManager = GridLayoutManager(this, 2)
        // 어댑터 설정
        viewAdapter = CardViewAdapter()
        // 리사이클러뷰와 어댑터 연결
        recyclerView = findViewById(R.id.main_RecyclerView)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
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

    // 뒤로가기 버튼 클릭 이벤트
    override fun onBackPressed() {

        // 1번째 버튼 클릭 시간과 현재 시간 비교 -> 1,2번째 버튼 클릭 사이의 시간차가 2초보다 크면 앱 종료X
        if (System.currentTimeMillis() > backPressedTime + TIME_INTERVAL) {
            backPressedTime = System.currentTimeMillis() // 현재 시간을 저장

            Toast.makeText(this, "'뒤로'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
        else { // 1,2번째 버튼 클릭 사이의 시간차가 2초보다 작으면 앱 종료
            finish() // 앱 종료
        }
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