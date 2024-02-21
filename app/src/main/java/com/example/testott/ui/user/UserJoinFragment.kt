package com.example.testott.ui.user

import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.testott.databinding.FragmentJoinBinding

class UserJoinFragment : Fragment() {

    private lateinit var binding: FragmentJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setContentView(root: LinearLayout) {

    }
}