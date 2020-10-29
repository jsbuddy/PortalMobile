package com.example.portal.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.portal.R
import com.example.portal.databinding.DialogExamResultBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ExamResultDialog(
    private val correct: Int,
    private val total: Int,
    private val percentage: Double
) : DialogFragment() {
    private var _binding: DialogExamResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogExamResultBinding.inflate(requireActivity().layoutInflater)
        val builder = MaterialAlertDialogBuilder(requireContext()).setView(binding.root)

        isCancelable = false

        binding.tvScore.text = "Your score: $percentage/100"
        binding.tvInfo.text = "You answered $correct out of $total questions correctly"
        binding.btnFinish.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.action_nav_exam_to_nav_exams)
        }

        return builder.create()
    }
}