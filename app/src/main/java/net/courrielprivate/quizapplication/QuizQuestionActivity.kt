package net.courrielprivate.quizapplication

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import net.courrielprivate.quizapplication.databinding.ActivityQuizQuestionBinding


private var indexQuestion: Int = 1 //Defaut pour la position de la premiere question
private var mQuestionList: ArrayList<QuestionModel>? = null
private var indexReponseQuestion: Int = 0


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var quizQuestionPageBinding: ActivityQuizQuestionBinding

    ///Cette fonction est créée automatiquement par Android lors de la création de la classe d'activité.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quizQuestionPageBinding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(quizQuestionPageBinding.root)

        mQuestionList = Constante.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {

        val question = mQuestionList!!.get(indexQuestion - 1)

        defaultOptionsView()
//Verifier si la position de la question est la derniere. Si dernière alors je change le texte du bouton
        if (indexQuestion == mQuestionList!!.size) {
            quizQuestionPageBinding.btnSubmit.text = "Terminé"
        } else {
            quizQuestionPageBinding.btnSubmit.text = "Soumettre"
        }

        quizQuestionPageBinding.progressBarHorizontal.progress = indexQuestion
        quizQuestionPageBinding.tvProgress.text =
            "$indexQuestion" + "/" + quizQuestionPageBinding.progressBarHorizontal.max

        quizQuestionPageBinding.tvQuestion.text = question.question
        quizQuestionPageBinding.ivImage.setImageResource(question.image)
        quizQuestionPageBinding.textViewOptionOne.text = question.optionOne
        quizQuestionPageBinding.textViewOptionTwo.text = question.optionTwo
        quizQuestionPageBinding.textViewOptionThree.text = question.optionThree
        quizQuestionPageBinding.textViewOptionFour.text = question.optionFour

    }

    /// Une fonction pour définir l'affichage des options par défaut lorsque la nouvelle question est chargée ou lorsque la réponse est resélectionnée.
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, quizQuestionPageBinding.textViewOptionOne)
        options.add(1, quizQuestionPageBinding.textViewOptionTwo)
        options.add(2, quizQuestionPageBinding.textViewOptionThree)
        options.add(3, quizQuestionPageBinding.textViewOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.text_view_option_one -> {
                selectedOptionView(quizQuestionPageBinding.textViewOptionOne, selectedOptionNum = 1)
            }
            R.id.text_view_option_two -> {
                selectedOptionView(quizQuestionPageBinding.textViewOptionTwo, selectedOptionNum = 2)
            }
            R.id.text_view_option_three -> {
                selectedOptionView(
                    quizQuestionPageBinding.textViewOptionThree,
                    selectedOptionNum = 3
                )
            }
            R.id.text_view_option_four -> {
                selectedOptionView(
                    quizQuestionPageBinding.textViewOptionFour,
                    selectedOptionNum = 4
                )
            }
            R.id.btn_submit -> {
                //Permet le changement de question
                if (indexReponseQuestion == 0) {
                    indexQuestion++

                    when {
                        indexQuestion <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(this, "Test Terminé", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(indexQuestion - 1)
                    //Bouton apparait en rouge si fausse réponse
                    if (question!!.CorrectAnswer != indexReponseQuestion) {
                        answerView(indexReponseQuestion, R.drawable.wrong_option_border_bg)
                    }
                    //Dans tous les cas je fais apparaitre le bouton en vert
                    answerView(question.CorrectAnswer, R.drawable.correct_option_border_bg)

                    if (indexQuestion == mQuestionList!!.size) {
                        quizQuestionPageBinding.btnSubmit.text = "Terminé"
                    } else {
                        quizQuestionPageBinding.btnSubmit.text = "Question suivante"
                    }
                    //Je reinitialise à 0 la reponse pour la prochaine question
                    indexReponseQuestion = 0
                }

            }
        }
    }

    //Methode utlisée pour encadrer la bonne reponse
    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                quizQuestionPageBinding.textViewOptionOne.background =
                    ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                quizQuestionPageBinding.textViewOptionTwo.background =
                    ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                quizQuestionPageBinding.textViewOptionThree.background =
                    ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                quizQuestionPageBinding.textViewOptionThree.background =
                    ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    /// Une fonction pour définir la vue de l'option sélectionnée.
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {// Reset des boutons
        defaultOptionsView()
        indexReponseQuestion = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

}