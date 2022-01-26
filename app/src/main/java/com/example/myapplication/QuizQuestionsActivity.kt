package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    //Variables
    private var progressBar : ProgressBar? = null
    private var progressText : TextView? = null
    private var theQuestion : TextView? = null
    private var flagImage : ImageView? = null

    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressText)
        theQuestion = findViewById(R.id.theQuestion)
        flagImage = findViewById(R.id.flagImage)

        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)

        val questionsList = Constants.getQuestions()
        Log.i("QuestionsList size is", "${questionsList.size}")

        for(i in questionsList){
            Log.e("Questions", i.question)
        }

        var currentPosition = 1
        val question : Question = questionsList[currentPosition - 1]
        progressBar?.progress = currentPosition
        progressText?.text = "$currentPosition / ${progressBar?.max}"
        theQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
    }
}