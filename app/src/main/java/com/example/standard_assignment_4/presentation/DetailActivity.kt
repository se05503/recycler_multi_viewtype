package com.example.standard_assignment_4.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standard_assignment_4.data.Card
import com.example.standard_assignment_4.R
import com.example.standard_assignment_4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD : String = "extra_card"
    }
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val cardItem = intent.getParcelableExtra<Card>(EXTRA_CARD) // intent에서 bundle 꺼내오고 bundle에서 data class 꺼내오는 구조가 아니라, intent에서 바로 data class 를 꺼내올 수 있음
        // 이후는 할 수 있죠?
    }
}