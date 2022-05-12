package com.example.newapp.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newapp.R
import com.example.newapp.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :Fragment(R.layout.home_fragment) {

    lateinit var binding: HomeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = HomeFragmentBinding.bind(view)

        binding.btnOnline.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_onlineFragment)
        }

        binding.btnOffline.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_offLineFragment)
        }
    }
}