package com.example.lesson01app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lesson01app.R
import java.lang.StringBuilder
import kotlin.random.Random

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

        val buttonCycles = findViewById<Button>(R.id.button_cycles)
        buttonCycles.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val foreachTV = findViewById<TextView>(R.id.foreach_textview)

                val numbers = List(2) { Random.nextInt(0, 99) }
                var sg = ""

                numbers.forEach {
                    sg += it.toString() + " "
                }
                foreachTV.setText(sg)

                sg = ""
                repeat(numbers[0]){
                    sg+= numbers[1].toString() + " "
                }
                findViewById<TextView>(R.id.repeat_textview).setText(sg)

                sg = ""
                if (numbers[0] < numbers[1]){
                for (i in numbers[0]..numbers[1]){
                    sg+= i.toString() + " "
                }} else {
                    for (i in numbers[0] downTo numbers[1]){
                        sg+= i.toString() + " "
                }}
                findViewById<TextView>(R.id.fori_textview).setText(sg)
            }
        })
    }
}