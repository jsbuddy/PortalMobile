package com.example.portal.data.repository

import com.example.portal.data.dao.ExamDao
import com.example.portal.data.model.Paper
import com.example.portal.data.model.Question
import javax.inject.Inject

class ExamRepository @Inject constructor(private val examDao: ExamDao) {

    fun getPapers(): List<Paper> = examDao.getPapers()

    fun getPaperQuestions(id: String): List<Question> {
        return examDao.getQuestions().filter { q -> q.paper === id }
    }
}