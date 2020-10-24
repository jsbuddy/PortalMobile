package com.example.portal.data.dao

import com.example.portal.data.model.Paper
import com.example.portal.data.model.Question
import com.example.portal.data.model.QuestionOption

class ExamDao {
    fun getPapers(): List<Paper> {
        val papers: MutableList<Paper> = arrayListOf()
        papers.add(
            Paper(
                id = "1",
                code = "CSC 101",
                title = "Introduction to computer science",
                session = "2020/2021",
                semester = 1,
                date = "Tue, Sep 2020",
                time = "2:00pm",
                duration = 2
            )
        )
        papers.add(
            Paper(
                id = "2",
                code = "GNS 102",
                title = "Introduction to Politics",
                session = "2020/2021",
                semester = 1,
                date = "Wed, Sep 2020",
                time = "9:00am",
                duration = 2
            )
        )
        return papers
    }

    fun getQuestions(): List<Question> {
        val questions: MutableList<Question> = arrayListOf()

        questions.add(
            Question(
                "1",
                "1",
                "What is computer science?",
                arrayListOf(
                    QuestionOption("Something", true),
                    QuestionOption("Something 1", false),
                    QuestionOption("Something 2", false),
                    QuestionOption("Something 3", false),
                )
            )
        )

        return questions
    }
}