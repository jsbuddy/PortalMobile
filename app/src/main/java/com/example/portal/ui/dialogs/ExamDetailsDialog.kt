package com.example.portal.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.portal.R
import com.example.portal.data.model.Paper
import com.example.portal.databinding.DialogExamDetailsBinding
import com.example.portal.ui.exams.ExamsFragmentDirections
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.format.DateTimeFormatter

class ExamDetailsDialog(private val paper: Paper) : BottomSheetDialogFragment() {
    private var _binding: DialogExamDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogExamDetailsBinding.inflate(inflater, container, false)

        binding.paper = paper

        binding.btnStart.setOnClickListener {
            dismiss()
            findNavController().navigate(ExamsFragmentDirections.actionNavExamsToNavExam(paper))
        }

        return binding.root
    }
}