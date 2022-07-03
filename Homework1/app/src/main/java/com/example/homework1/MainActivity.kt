package com.example.homework1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var name: EditText? = null
    var height: EditText? = null
    var weight: EditText? = null
    var age: EditText? = null

    var btn: Button? = null

    var output: TextView? = null

    var error: Boolean = false

    fun value_check(value: Double, left_lim: Int, right_lim: Int): Boolean = (value > left_lim) and
            (value < right_lim)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editName)
        height = findViewById(R.id.editHeight)
        weight = findViewById(R.id.editWeight)
        age = findViewById(R.id.editAge)

        btn = findViewById(R.id.Submit)
        output = findViewById(R.id.output_window)

        val numElements = listOf(height, weight)


        btn?.setOnClickListener {
            name?.setHintTextColor(getColor(R.color.hint))
            for (i in 0..1){
                numElements[i]?.setTextColor(getColor(R.color.text))
                numElements[i]?.setHintTextColor(getColor(R.color.hint))
            }
            weight?.setTextColor(getColor(R.color.text))
            weight?.setHintTextColor(getColor(R.color.hint))

            val numElementTexts = listOf(height?.text.toString(), weight?.text.toString())

            if(name?.text.toString()==""){
                error = true
                name?.setHintTextColor(getColor(R.color.red))
            }

            for (i in 0..1) {
                if (numElementTexts[i] == "") {
                    error = true

                    numElements[i]?.setHintTextColor(getColor(R.color.red))
                } else if (!value_check(
                        numElementTexts[i].toDouble(),
                        0, 250
                    )
                ) {
                    error = true
                    numElements[i]?.setTextColor(getColor(R.color.red))
                }
            }

            if (age?.text.toString()==""){
                error = true
                age?.setHintTextColor(getColor(R.color.red))
            } else if (!value_check(age?.text.toString().toDouble(), 0, 150)){
                error = true
                age?.setTextColor(getColor(R.color.red))
            }

            if (error) {
                output?.setTextColor(getColor(R.color.red))
                output?.text = "Данные введены некорректно."
                error = false
            }
            else {
                output?.setTextColor(getColor(R.color.purple_700))
                val value: Double = numElementTexts[0].toDouble() + numElementTexts[1].toDouble() +
                        age?.text.toString().toDouble() + name?.text.toString()[0].code
                output?.text = "Ответ: $value"
            }

        }
    }

}