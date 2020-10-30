package com.example.portal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.portal.R
import com.example.portal.adapter.OnboardingViewPagerAdapter
import com.example.portal.data.model.OnboardingSlide
import com.example.portal.databinding.FragmentOnboardingBinding

val slides = arrayListOf(
    OnboardingSlide(
        "Connect with lecturers, colleagues and friends",
        R.drawable.ic_students_digital
    ),
    OnboardingSlide(
        "Stay up to date with school activities",
        R.drawable.ic_student_connected
    ),
    OnboardingSlide(
        "Study, take assessments and examinations",
        R.drawable.ic_student_checklist
    ),
)

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            if (position + 1 < slides.size) {
                binding.btnNext.visibility = View.VISIBLE
                binding.btnFinish.visibility = View.GONE
            }
            if (position + 1 == slides.size) {
                binding.btnNext.visibility = View.GONE
                binding.btnFinish.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        val adapter = OnboardingViewPagerAdapter(slides)
        binding.slides.adapter = adapter

        binding.slides.registerOnPageChangeCallback(pageChangeCallback)

        binding.btnNext.setOnClickListener {
            binding.slides.currentItem = binding.slides.currentItem + 1
        }

        binding.btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_nav_home)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.slides.unregisterOnPageChangeCallback(pageChangeCallback)
    }
}