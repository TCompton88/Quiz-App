package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

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

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        submitBtn?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()

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

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        //Adds option TextViews to array
        optionOne?.let{
            options.add(0, it)
        }
        optionTwo?.let{
            options.add(1, it)
        }
        optionThree?.let{
            options.add(2, it)
        }
        optionFour?.let{
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#08ABBF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(view: TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelectedOptionPos = selectedOptionNum
        view.setTextColor(Color.parseColor("#363A43"))
        view.setTypeface(view.typeface, Typeface.BOLD)
        view.background = ContextCompat.getDrawable(this,
        R.drawable.selected_option_border)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                optionOne?.let{
                    selectedOptionView(it, 1)
                }
            }
            R.id.optionTwo -> {
                optionTwo?.let{
                    selectedOptionView(it, 2)
                }
            }
            R.id.optionThree -> {
                optionThree?.let{
                    selectedOptionView(it, 3)
                }
            }
            R.id.optionFour -> {
                optionFour?.let{
                    selectedOptionView(it, 4)
                }
            }

            R.id.submitBtn ->{
                // TODO "Implement submission function"
                if(mSelectedOptionPos == 0){
                    mCurrentPos++

                    when{
                        mCurrentPos <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else ->{
                            Toast.makeText(this, "You made it",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                } else{
                    val question = mQuestionsList?.get(mCurrentPos - 1)

                    if(question!!.correctAnswer != mSelectedOptionPos){
                        answerView(mSelectedOptionPos, R.drawable.incorrect_option_border_bg)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPos == mQuestionsList!!.size){
                        submitBtn?.text = "Finish"
                    } else{
                        submitBtn?.text = "Next"
                    }

                    mSelectedOptionPos = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(this,
                drawableView)
            }

            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }

            3 -> {
                optionThree?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }

            4 -> {
                optionFour?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
        }
    }
}