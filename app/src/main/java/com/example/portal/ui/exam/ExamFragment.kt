package com.example.portal.ui.exam

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.portal.R
import com.example.portal.databinding.FragmentExamBinding
import com.example.portal.ui.dialogs.ExamResultDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ExamFragment : Fragment(R.layout.fragment_exam) {

    private lateinit var binding: FragmentExamBinding

    private val args: ExamFragmentArgs by navArgs()
    private val viewModel: ExamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        if (!viewModel.initialized) viewModel.initialize(args.paper)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            MaterialAlertDialogBuilder(requireContext())
                .setMessage("Exiting this paper without submitting will automatically be recorded as a failure, are you sure you want to continue?")
                .setNegativeButton("Stay") { _, _ -> }
                .setPositiveButton("Exit") { _, _ -> findNavController().navigateUp() }
                .show()
        }.isEnabled = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = args.paper.code
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding = FragmentExamBinding.bind(view)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.exam, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_submit -> {
                val remains = viewModel.getRemains()
                val message =
                    "Are you sure you want to submit? ${if (remains > 0) "There are $remains unanswered questions" else ""}"
                MaterialAlertDialogBuilder(requireContext())
                    .setMessage(message)
                    .setNegativeButton("Cancel") { _, _ -> }
                    .setPositiveButton("Submit") { _, _ -> submit() }
                    .show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun submit() {
        val correct = viewModel.getCorrectAnswers()
        val total = viewModel.questions.size
        val percentage: Double = (correct.toDouble() / total.toDouble()) * 100
        Timber.d("Correct: $correct, Total: $total, Percentage: $percentage")
        val dialog = ExamResultDialog(correct, total, percentage)
        dialog.show(childFragmentManager, "ExamResultDialog")
    }
}