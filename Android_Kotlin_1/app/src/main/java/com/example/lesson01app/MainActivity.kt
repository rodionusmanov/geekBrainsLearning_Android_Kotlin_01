package com.example.lesson01app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lesson01app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data class Cat(val name: String, val weight: Int)
        val cat = Cat("Усатый", 5)

       /* var dog = object {
            var name = "Слюнявый"
            var weight = 20
        }*/

        val newCat = cat.copy(name = "Усатый")

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("ResourceAsColor")
            override fun onClick(v: View) {
                if (button.text == "button") {
                    button.setText("Кнопка")
                } else {
                    button.setText("button")
                }

                findViewById<TextView>(R.id.cat_name).setText(newCat.name)
                findViewById<TextView>(R.id.cat_weight).setText(newCat.weight.toString())
            }
        })
    }
}