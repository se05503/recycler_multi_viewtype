package com.example.standard_assignment_4.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.standard_assignment_4.data.Card
import com.example.standard_assignment_4.databinding.ItemBlueCardBinding
import com.example.standard_assignment_4.databinding.ItemLightBlueCardBinding
import com.example.standard_assignment_4.databinding.ItemOrangeCardBinding
import java.lang.IllegalArgumentException
import java.text.DecimalFormat

class MultiCardAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var cardList = listOf<Card>()

//    companion object {
//        private const val CARD_ITEM_1 = 0
//        private const val CARD_ITEM_2 = 1
//        private const val CARD_ITEM_3 = 2
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when (position) {
//            0 -> CARD_ITEM_1
//            1 -> CARD_ITEM_2
//            else -> CARD_ITEM_3
//        }
//    }
//
//    interface ItemClick {
//        fun onClick(view: View, position: Int)
//    }

//    var itemClick: ItemClick? = null

    inner class BlueTypeViewHolder(private val binding: ItemBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) { // onBindViewHolder에서 해당 함수를 불러와서 씀, 정의 자체는 ViewHolder에서 함
            binding.apply {
                tvUsername.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    inner class LightBlueTypeViewHolder(private val binding: ItemLightBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUsername.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    inner class OrangeTypeViewHolder(private val binding: ItemOrangeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUsername.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // multi view type 에서는 when절로 경우를 나눈다
        return when (viewType) {
            MultiViewEnum.BLUE.viewType -> {
                // binding 만들고 ViewHolder에다가 binding 넣어서 ViewHolder 생성하기!
                val binding =
                    ItemBlueCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlueTypeViewHolder(binding)
            }

            MultiViewEnum.LIGHTBLUE.viewType -> {
                val binding = ItemLightBlueCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                LightBlueTypeViewHolder(binding)
            }

            MultiViewEnum.ORANGE.viewType -> {
                val binding = ItemOrangeCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                OrangeTypeViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = cardList[position]
        when(holder.itemViewType) {
            MultiViewEnum.BLUE.viewType -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            MultiViewEnum.LIGHTBLUE.viewType -> {
                val lightBlueHolder = holder as LightBlueTypeViewHolder
                lightBlueHolder.bind(currentItem)

                holder.itemView.setOnClickListener { // 이 부분!!
                    onClick(currentItem)
                }
            }
            MultiViewEnum.ORANGE.viewType -> {
                val orangeBlueHolder = holder as OrangeTypeViewHolder
                orangeBlueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        // position 과 itemviewtype 을 연결시킴
        return when (position) {
            0 -> MultiViewEnum.BLUE.viewType
            1 -> MultiViewEnum.LIGHTBLUE.viewType
            2 -> MultiViewEnum.ORANGE.viewType
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return when (viewType) {
//            CARD_ITEM_1 -> {
//                val binding = CardItem1Binding.inflate(inflater, parent, false)
//                CardItemOneHolder(binding)
//            }
//
//            CARD_ITEM_2 -> {
//                val binding = CardItem2Binding.inflate(inflater, parent, false)
//                CardItemTwoHolder(binding)
//            }
//
//            else -> {
//                // CARD_ITEM_3
//                val binding = CardItem3Binding.inflate(inflater, parent, false)
//                CardItemThreeHolder(binding)
//            }
//        }
//    }
//
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val decimal = DecimalFormat("#,###.00")
//
//        holder.itemView.setOnClickListener {
//            itemClick?.onClick(it, position)
//        }
//        when (position) {
//            0 -> {
//                (holder as CardItemOneHolder).name.text = dataList[position].name
//                holder.cardNum.text = dataList[position].cardNum
//                holder.expire.text = dataList[position].expire
//                holder.price.text = "$${decimal.format(dataList[position].price)}"
//            }
//
//            1 -> {
//                (holder as CardItemTwoHolder).name.text = dataList[position].name
//                holder.cardNum.text = dataList[position].cardNum
//                holder.expire.text = dataList[position].expire
//                holder.price.text = "$${decimal.format(dataList[position].price)}"
//            }
//
//            2 -> {
//                (holder as CardItemThreeHolder).name.text = dataList[position].name
//                holder.cardNum.text = dataList[position].cardNum
//                holder.expire.text = dataList[position].expire
//                holder.price.text = "$${decimal.format(dataList[position].price)}"
//            }
//        }
//    }
}