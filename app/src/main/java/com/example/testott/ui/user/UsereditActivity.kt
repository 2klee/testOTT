package com.example.testott.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testott.MainActivity
import com.example.testott.R
import com.example.testott.databinding.ActivityJoinBinding
import com.example.testott.databinding.ActivityUsereditBinding

class UsereditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsereditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useredit)


        binding.EditSummitButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            // 현재 액티비티를 종료하여 로그인 화면을 닫음
            finish()
        }
    }
}