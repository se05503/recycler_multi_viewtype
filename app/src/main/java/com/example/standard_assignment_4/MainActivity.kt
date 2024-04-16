package com.example.standard_assignment_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_assignment_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val dataList = mutableListOf<Item>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addData() // 데이터 초기화
        val adapter = CustomAdapter(dataList,this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this) // 이번엔 Linear 말고 constraint로 했는데 괜찮을까?

        adapter.itemClick = object: CustomAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                val bundle = Bundle().apply { putParcelable("bundle",dataList[position])}
                intent.putExtra("intent",bundle)
                startActivity(intent)
            }
        }
    }

    private fun addData() {
        dataList.add(Item("Anderson", "2423 3581 9503", "21 / 24","$3,100.30",R.color.dim_gray))
        dataList.add(Item("Katy", "1233 1981 6892", "12 / 25", "$2,499.80", R.color.sky_blue))
        dataList.add(Item("Mille", "9182 9138 3849", "19 / 19", "$1,381.70", R.color.orange_peel))
    }
}