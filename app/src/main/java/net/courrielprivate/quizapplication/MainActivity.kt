package net.courrielprivate.quizapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.courrielprivate.quizapplication.databinding.ActivityMainBinding

private lateinit var myBinding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(myBinding.root)
    }
}