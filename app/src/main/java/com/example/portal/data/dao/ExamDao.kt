package com.example.portal.data.dao

import com.example.portal.data.model.Paper
import com.example.portal.data.model.Question
import com.example.portal.data.model.QuestionOption
import java.time.LocalDate
import java.time.LocalDateTime

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
                date = LocalDateTime.parse("2020-10-10T09:00:00"),
                duration = 2,
                active = true
            )
        )
        papers.add(
            Paper(
                id = "2",
                code = "GNS 102",
                title = "Introduction to Politics",
                session = "2020/2021",
                semester = 1,
                date = LocalDateTime.parse("2020-10-10T09:00:00"),
                duration = 2,
                active = false
            )
        )
        return papers
    }

    fun getQuestions(): List<Question> {
        val questions: MutableList<Question> = arrayListOf()

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "Which of the following is true about a computer?",
                options = arrayListOf(
                    QuestionOption("It has a CPU", true),
                    QuestionOption("It cannot be used to play video games", false),
                    QuestionOption("It doesn't require user input", false),
                    QuestionOption("Only rich people can afford it", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "One of the following is not a type of error which can occur during the execution of a program.",
                options = arrayListOf(
                    QuestionOption("Syntax Error", false),
                    QuestionOption("Runtime Error", false),
                    QuestionOption("Logical Error", false),
                    QuestionOption("Compiler Error", true),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "A finite set of steps which, if followed, accomplish a particular task, is commonly referred to as",
                options = arrayListOf(
                    QuestionOption("Flowchart", false),
                    QuestionOption("Steps", false),
                    QuestionOption("Algorithm", true),
                    QuestionOption("Analysis", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "Named memory locations (memory cells) which are used to store the program’s input and its computational results during program execution is known as",
                options = arrayListOf(
                    QuestionOption("Memory cell", false),
                    QuestionOption("Variable", true),
                    QuestionOption("Program storage", false),
                    QuestionOption("Hard drive", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "What is the process of finding and removing errors in a program?",
                options = arrayListOf(
                    QuestionOption("Error removal", false),
                    QuestionOption("Diagnosing", false),
                    QuestionOption("Troubleshooting", false),
                    QuestionOption("Debugging", true),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "Which data structure uses LIFO?",
                options = arrayListOf(
                    QuestionOption("Array", false),
                    QuestionOption("Int", false),
                    QuestionOption("Stacks", true),
                    QuestionOption("Queues", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "What is FIFO?",
                options = arrayListOf(
                    QuestionOption("First in Few Out", false),
                    QuestionOption("Few In Few out", false),
                    QuestionOption("First In First Out", true),
                    QuestionOption("Few In First Out", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "A memory location that holds a single letter or number is commonly known as what?",
                options = arrayListOf(
                    QuestionOption("Double", false),
                    QuestionOption("Char", true),
                    QuestionOption("Int", false),
                    QuestionOption("Word", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "What dose this equation mean ? a != t",
                options = arrayListOf(
                    QuestionOption("A is assigned t", false),
                    QuestionOption("A and t are equal", false),
                    QuestionOption("T is add to a", false),
                    QuestionOption("A is not equal to t", true),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "What does HTML stand for?",
                options = arrayListOf(
                    QuestionOption("Hyper Trainer Marking Language", false),
                    QuestionOption("Hyper Text Marketing Language", false),
                    QuestionOption("Hyper Text Markup Language", true),
                    QuestionOption("Hyper Text Markup Leveler", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "Which of the following is the correct way of making a string in Java?",
                options = arrayListOf(
                    QuestionOption("String \"Text\"", false),
                    QuestionOption("String text = 'text';", false),
                    QuestionOption("String text = \"text\"", false),
                    QuestionOption("String text = \"text\";", true),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "Which of the following is used to perform computations on the entered data?",
                options = arrayListOf(
                    QuestionOption("Memory", false),
                    QuestionOption("Processor", true),
                    QuestionOption("Input Device", false),
                    QuestionOption("Output Device", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "In which of the following languages,the instructions are written in the form of 0s and 1s?",
                options = arrayListOf(
                    QuestionOption("Assembly Language", false),
                    QuestionOption("Programming Language", false),
                    QuestionOption("High-Level Language", false),
                    QuestionOption("Machine Language", true),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "Creating an object is called?",
                options = arrayListOf(
                    QuestionOption("Instantiation", true),
                    QuestionOption("Reference", false),
                    QuestionOption("Variable", false),
                    QuestionOption("Abstraction", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "__________ is software that displays web pages and allows you to interact with text, images, music, video and other resources found on a website on the World Wide Web",
                options = arrayListOf(
                    QuestionOption("Device Driver", false),
                    QuestionOption("Web Browser", true),
                    QuestionOption("Operating System", false),
                    QuestionOption("Computer Aided Instruction", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "What is a constructor?",
                options = arrayListOf(
                    QuestionOption(
                        "Class method that is executed when an object of a given type is created",
                        true
                    ),
                    QuestionOption("Constructor that has parameters", false),
                    QuestionOption("Method name with its parameter list", false),
                    QuestionOption("All of the above", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "What is a Ternary Operator?",
                options = arrayListOf(
                    QuestionOption("Shortcut for boolean statements, it is !=", false),
                    QuestionOption("Shortcut for if statements, it is a question mark", true),
                    QuestionOption("Shortcut for if statements, it is a !", false),
                    QuestionOption("Shortcut for expressions, it is an =", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "A compiler (or an assembler) converts source code into",
                options = arrayListOf(
                    QuestionOption("Load module", false),
                    QuestionOption("Executable program", true),
                    QuestionOption("Object module", false),
                    QuestionOption("Source code", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "When a programmer writes a program, the code is known as",
                options = arrayListOf(
                    QuestionOption("Source code", true),
                    QuestionOption("Object code", false),
                    QuestionOption("Object module", false),
                    QuestionOption("Load module", false),
                )
            )
        )

        questions.add(
            Question(
                id = questions.size.plus(1).toString(),
                paper = "1",
                question = "Which of the following control structures are looping statements? (I) DO…….WHILE (II) FOR…..NEXT (III) IF……THEN",
                options = arrayListOf(
                    QuestionOption("Only I", false),
                    QuestionOption("III only", false),
                    QuestionOption("I and II", true),
                    QuestionOption("II and III", false),
                )
            )
        )

        return questions
    }
}