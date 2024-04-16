package com.example.standard_assignment_4

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_assignment_4.databinding.CardLayoutBinding

class CustomAdapter(private val dataList: MutableList<Item>, private val context:Context):RecyclerView.Adapter<CustomAdapter.Holder>(){

    interface ItemClick {
        fun onClick(view: View, position:Int)
    }

    var itemClick: ItemClick? = null

    inner class Holder(binding:CardLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvName
        val cardNum = binding.tvCardNum
        val expire = binding.tvExpireDate
        val price = binding.tvBalanceNum
        val layout = binding.constraintLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,
            false)
        return Holder(binding)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }

        // 전체 데이터에 대해서 매번 실행
        holder.name.text = dataList[position].name
        holder.cardNum.text = dataList[position].cardNum
        holder.expire.text = dataList[position].expire
        holder.price.text = dataList[position].price
        // xml에서 설정한 background가 작동하려면 setBackgroundColor 말고 다른거 써야함
        // setBackgroundColor 속성이 xml에서 background 설정한 부분을 덮어버림(네모로 나오는 이유)
        holder.layout.setBackgroundColor(context.resources.getColor(dataList[position].color,null)) // 해당 코드 복습 및 공부하고 꼭 정리하기, 값을 안줄거면 null로 하기(deprecated 함수 방지)
//      holder.layout.setBackgroundColor(dataList[position].color) // 원래 이렇게 했었는데 해결이 안됨 ㅠㅠ
    }
}