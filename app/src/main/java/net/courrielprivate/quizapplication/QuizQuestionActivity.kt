package net.courrielprivate.quizapplication

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import net.courrielprivate.quizapplication.databinding.ActivityQuizQuestionBinding


private var mCurrentPosition: Int = 1
private var mQuestionList: ArrayList<QuestionModel>? = null
private var mSelectedOptionPosition: Int = 0


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var myBinding1: ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myBinding1 = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(myBinding1.root)

        mQuestionList = Constante.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {
        mCurrentPosition = 1
        val question = mQuestionList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        myBinding1.progressBarHorizontal.progress = mCurrentPosition
        myBinding1.tvProgress.text =
            "$mCurrentPosition" + "/" + myBinding1.progressBarHorizontal.max

        myBinding1.tvQuestion.text = question.question
        myBinding1.ivImage.setImageResource(question.image)
        myBinding1.tvOptionOne.text = question.optionOne
        myBinding1.tvOptionTwo.text = question.optionTwo
        myBinding1.tvOptionThree.text = question.optionThree
        myBinding1.tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, myBinding1.tvOptionOne)
        options.add(1, myBinding1.tvOptionTwo)
        options.add(2, myBinding1.tvOptionThree)
        options.add(3, myBinding1.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(myBinding1.tvOptionOne, selectedOptionNum = 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(myBinding1.tvOptionTwo, selectedOptionNum = 2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(myBinding1.tvOptionThree, selectedOptionNum = 3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(myBinding1.tvOptionFour, selectedOptionNum = 4)
            }


        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {// Reset des boutons
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

}