package com.example.standard_assignment_4.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_assignment_4.data.Card
import com.example.standard_assignment_4.R
import com.example.standard_assignment_4.data.DataSource
import com.example.standard_assignment_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private val dataList = mutableListOf<Card>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val multiCardAdapter : MultiCardAdapter by lazy {
        MultiCardAdapter { card ->
            adapterOnClick(card)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val cardList = DataSource.getDataSource().getCardList() // 연결!
        multiCardAdapter.cardList = cardList // 또 연결!

        with(binding.recyclerView) {
            adapter = multiCardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
//        val adapter = MultiCardAdapter(dataList,this)
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//
//        adapter.itemClick = object: MultiCardAdapter.ItemClick {
//            override fun onClick(view: View, position: Int) {
//                val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                val bundle = Bundle().apply { putParcelable("bundle",dataList[position])} // Fragment의 getInstance 함수 참고
//                intent.putExtra("intent",bundle)
//                startActivity(intent)
//            }
//        }
    }

    private fun adapterOnClick(card:Card) {
        //bundle로 넘기는 작업, extension 안쓰고 작업
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD,card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}