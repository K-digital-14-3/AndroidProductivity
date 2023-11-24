package com.example.androidscaffolding.ui.Main.MyPage

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.ActivityMyPageBinding
import com.example.androidscaffolding.ui.Main.MyPage.adapter.Adapter

class MyPage : AppCompatActivity() {
    lateinit var binding : ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 더미 데이터로 텍스트만 임시로 사용하지만,
        // 공공데이터, 사용자 정의한 데이터를 가지고 와서,
        // 원하는 뷰에 데이터를 넣는 , 바인딩 작업을 함.
        val datas = mutableListOf<String>()
        for(i in 1..10) {
            datas.add("라바 $i")
        }
        // 기본 값으로 세로 방향 출력.
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // 가로 방향으로 출력 해보기.
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = layoutManager

        // 액티비티 -> 리사이클러뷰 -> 실제 데이터를 연결하는 부분. 중요함.!!!!!!!!!!!!
        binding.recyclerView.adapter = Adapter(datas)
        // 구분선 넣기, 나중에 옵션으로 배경이미지도 넣기 가능.
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL)
        )

//        // 2번째 리사이클러 뷰 출력해보기. 기존 데이터 재사용, 뷰홀더, 마이 어댑터 재사용해보기.
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // 기존 재사용
        binding.recyclerView.adapter = Adapter(datas)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL))

    }
}