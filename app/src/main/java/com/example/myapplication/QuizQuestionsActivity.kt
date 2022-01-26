package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    //Comparison Variables
    private var mCurrentPos: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPos: Int = 0

    //Variables
    private var progressBar : ProgressBar? = null
    private var progressText : TextView? = null
    private var theQuestion : TextView? = null
    private var flagImage : ImageView? = null

    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null

    private var submitBtn: Button? = null

    @SuppressLint("SetTextI18n")
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

        submitBtn = findViewById(R.id.submitBtn)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question: Question = mQuestionsList!![mCurrentPos - 1]
        flagImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPos
        progressText?.text = "$mCurrentPos / ${progressBar?.max}"
        theQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrentPos == mQuestionsList!!.size){
            submitBtn?.text = "Finish"
        }else{
            submitBtn?.text = "Submit"
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}