package net.courrielprivate.quizapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import net.courrielprivate.quizapplication.databinding.ActivityMainBinding


private lateinit var myBinding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        //Retrait de la bar des notification - Mode FULLSCREEN
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        myBinding.btnStart.setOnClickListener {
            if (myBinding.inputText.text.toString().isEmpty()) {
                Toast.makeText(this, "Veuillez entrer votre nom", Toast.LENGTH_LONG).show()
            }else
            {
                val intent = Intent(this,QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}