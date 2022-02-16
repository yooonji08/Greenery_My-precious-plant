package com.example.greenery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// RecyclerView와 커스텀한 카드뷰를 연결해주는 어댑터
class CardViewAdapter(): RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {
    class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.myPlant_ImageView)
        var itemNickname: TextView = itemView.findViewById(R.id.myPlant_nicknameTextView)
        var itemSpecies: TextView = itemView.findViewById(R.id.myPlant_speciesTextView)
        var itemDate: TextView = itemView.findViewById(R.id.myPlant_dateTextView)
    }

    // 커스텀한 카드 레이아웃 가져오기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.layout_my_plant_cardview, parent, false)

        return CardViewHolder(cardView)
    }

    // 데이터 연결하기
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemImage.setImageResource(R.drawable.img_money_tree)
        holder.itemImage.clipToOutline = true // 둥근 모서리 적용(background속성 적용)
        holder.itemNickname.text = "닉네임"
        holder.itemSpecies.text = "식물 종류"
        holder.itemDate.text = "식물을 데려온 날짜"
    }

    // 카드뷰의 개수 정하기
    override fun getItemCount(): Int {
        return 5
    }
}