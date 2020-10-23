package com.example.portal.ui.exams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.portal.R

class ExamsFragment : Fragment() {

    private lateinit var examsViewModel: ExamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        examsViewModel =
            ViewModelProvider(this).get(ExamsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_exams, container, false)
        return root
    }
}