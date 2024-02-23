package com.example.testott.ui.user

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testott.MainActivity
import com.example.testott.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.JoinSummitButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            // 현재 액티비티를 종료하여 로그인 화면을 닫음
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // 뒤로가기 버튼을 눌렀을 때 현재 화면을 종료하고 이전 화면으로 돌아감
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
