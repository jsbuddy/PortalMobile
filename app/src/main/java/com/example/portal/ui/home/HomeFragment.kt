package com.example.portal.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.portal.R
import com.example.portal.databinding.FragmentHomeBinding
import com.example.portal.ui.exams.ExamsViewModel
import com.example.portal.utils.DrawerLocker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val examsViewModel: ExamsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.show()
        (activity as DrawerLocker).setDrawerEnabled(true)
        binding = FragmentHomeBinding.bind(view)
        binding.examsViewModel = examsViewModel
        binding.btnExams.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_exams)
        }
    }
}