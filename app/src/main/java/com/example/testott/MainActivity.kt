package com.example.testott

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testott.databinding.ActivityMainBinding
import com.example.testott.ui.user.JoinActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_movie, R.id.navigation_tv, R.id.navigation_actor
            ), binding.drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        // 툴바의 홈 버튼을 항상 표시
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // login_layout의 클릭 이벤트를 가로채기, 옆창 나온 상태에서 다른거 클릭 안되게
        binding.loginLayout.setOnClickListener { }
        binding.mypageLayout.setOnClickListener { }


        binding.loginSummitButton.setOnClickListener {
            // 로그인 버튼을 클릭했을 때 로그인 레이아웃을 숨기고, 대신 마이페이지 레이아웃을 표시
            binding.loginLayout.visibility = View.GONE
            binding.mypageLayout.visibility = View.VISIBLE
        }

        binding.logoutButton.setOnClickListener {
            // 로그인 버튼을 클릭했을 때 로그인 레이아웃을 숨기고, 대신 마이페이지 레이아웃을 표시
            binding.loginLayout.visibility = View.VISIBLE
            binding.mypageLayout.visibility = View.GONE
        }


        // 회원가입 버튼 클릭 시 JoinActivity 시작
        binding.joinButton.setOnClickListener {
            startActivity(Intent(this, JoinActivity::class.java))
            // 현재 액티비티를 종료하여 로그인 화면을 닫음
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // 네비게이션 드로어 열기
                binding.drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object {
        const val MOVIE_BACKDROP = "extra_movie_backdrop"
        const val MOVIE_POSTER = "extra_movie_poster"
        const val MOVIE_TITLE = "extra_movie_title"
        const val MOVIE_RATING = "extra_movie_rating"
        const val MOVIE_RELEASE_DATE = "extra_movie_release_date"
        const val MOVIE_OVERVIEW = "extra_movie_overview"
    }
}
