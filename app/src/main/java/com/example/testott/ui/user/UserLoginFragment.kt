package com.example.testott.ui.user

import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.testott.databinding.FragmentJoinBinding
import com.example.testott.databinding.FragmentLoginBinding

class UserLoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setContentView(root: LinearLayout) {

    }
}