package com.example.portal.ui.exams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.portal.R
import com.example.portal.adapter.ExamRecyclerViewAdapter
import com.example.portal.databinding.FragmentExamsBinding
import com.example.portal.ui.dialogs.ExamDetailsDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExamsFragment : Fragment(R.layout.fragment_exams) {

    private var _binding: FragmentExamsBinding? = null
    private val binding get() = _binding!!

    private lateinit var examsAdapter: ExamRecyclerViewAdapter
    private val viewModel: ExamsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExamsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        examsAdapter = ExamRecyclerViewAdapter()
        binding.rvExams.apply {
            adapter = examsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        examsAdapter.differ.submitList(viewModel.papers)
        examsAdapter.setOnItemClickListener { paper ->
            val dialog = ExamDetailsDialog(paper)
            dialog.show(childFragmentManager, "ExamDetails")
        }
    }
}