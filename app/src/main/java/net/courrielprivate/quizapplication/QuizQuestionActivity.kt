package net.courrielprivate.quizapplication

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import net.courrielprivate.quizapplication.databinding.ActivityQuizQuestionBinding


private var mCurrentPosition: Int = 1
private var mQuestionList: ArrayList<QuestionModel>? = null
private var mSelectedOptionPosition: Int = 0

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var myBinding: ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myBinding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        mQuestionList = Constante.getQuestions()
        setQuestion()

        myBinding.tvOptionOne.setOnClickListener { this }
        myBinding.tvOptionTwo.setOnClickListener { this }
        myBinding.tvOptionThree.setOnClickListener { this }
        myBinding.tvOptionFour.setOnClickListener { this }
    }

    private fun setQuestion() {
        mCurrentPosition = 1
        val question = mQuestionList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        myBinding.progressBarHorizontal.progress = mCurrentPosition
        myBinding.tvProgress.text = "$mCurrentPosition" + "/" + myBinding.progressBarHorizontal.max

        myBinding.tvQuestion.text = question!!.question
        myBinding.ivImage.setImageResource(question.image)
        myBinding.tvOptionOne.text = question.optionOne
        myBinding.tvOptionTwo.text = question.optionTwo
        myBinding.tvOptionThree.text = question.optionThree
        myBinding.tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, myBinding.tvOptionOne)
        options.add(1, myBinding.tvOptionTwo)
        options.add(2, myBinding.tvOptionThree)
        options.add(3, myBinding.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }


    }

    override fun onClick(v: View?) {
        when (v?.id)
        {
            R.id.tv_option_one ->{selectedOptionView(myBinding.tvOptionOne, selectedOptionNum = 1)}
            R.id.tv_option_two ->{selectedOptionView(myBinding.tvOptionTwo, selectedOptionNum = 2)}
            R.id.tv_option_three ->{selectedOptionView(myBinding.tvOptionThree, selectedOptionNum = 3)}
            R.id.tv_option_four ->{selectedOptionView(myBinding.tvOptionFour, selectedOptionNum = 4)}


        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int)
    {// Reset des boutons
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

}