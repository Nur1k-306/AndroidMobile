package ru.itis.course2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val screen1Fragment = Screen1_Fragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, screen1Fragment)
                .commit()
        }
    }
}


