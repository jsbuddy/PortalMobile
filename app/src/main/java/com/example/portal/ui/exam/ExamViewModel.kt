package com.example.portal.ui.exam

import android.os.CountDownTimer
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.portal.data.model.Paper
import com.example.portal.data.model.Question
import com.example.portal.data.repository.ExamRepository
import timber.log.Timber
import java.util.concurrent.TimeUnit

class ExamViewModel @ViewModelInject constructor(
    private val repository: ExamRepository
) : ViewModel() {
    var initialized: Boolean = false
    lateinit var questions: List<Question>
    val timer: MutableLiveData<String> by lazy { MutableLiveData<String>("") }
    val current: MutableLiveData<Int> by lazy { MutableLiveData<Int>(0) }
    val answers: MutableLiveData<HashMap<String, Int>> by lazy {
        MutableLiveData<HashMap<String, Int>>(hashMapOf())
    }

    fun initialize(paper: Paper) {
        questions = repository.getPaperQuestions(paper.id)
        countdown(paper.duration).start()
        initialized = true
    }

    private fun countdown(duration: Int) =
        object : CountDownTimer(TimeUnit.HOURS.toMillis(duration.toLong()), 1000) {
            override fun onTick(millis: Long) {
                val hours = TimeUnit.MILLISECONDS.toHours(millis)
                val minutes = TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
                timer.postValue("$hours:$minutes:$seconds")
            }

            override fun onFinish() {
                timer.postValue("Completed")
            }
        }

    fun nextQuestion() {
        current.postValue(current.value?.plus(1))
    }

    fun previousQuestion() {
        current.postValue(current.value?.minus(1))
    }

    fun addAnswer(i: Int) {
        val temp = HashMap((answers.value) as HashMap<String, Int>)
        temp[questions[current.value!!].id] = i
        answers.postValue(temp)
    }

    fun getCorrectAnswers(): Int {
        var correct = 0
        questions.forEach { question ->
            val answer = answers.value?.get(question.id)
            if (answer != null && question.options[answer - 1].correct) correct++
        }
        return correct
    }

    fun getRemains(): Int {
        return questions.size - answers.value!!.size
    }
}