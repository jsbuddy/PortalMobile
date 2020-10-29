package com.example.portal.ui.exams

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.portal.data.repository.ExamRepository

class ExamsViewModel @ViewModelInject constructor(
    repository: ExamRepository
) : ViewModel() {

    val papers = repository.getPapers()
}