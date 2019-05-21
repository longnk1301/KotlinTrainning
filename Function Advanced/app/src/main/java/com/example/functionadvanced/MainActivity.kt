package com.example.functionadvanced

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Top level function
        println("Top level function" + getCurrentDate())

        //Lambda function
        var message = {
            println("Kotlin is awesome :D")
        }
        message()

        val msg = { str: String -> print("$str - ")
            println("End lambda function")
        }
        msg("Start lambda")

        //Higher-order function ?? higher excute before toplevel and lambda ???
        fun printSummary(number1: Int, number2: Int, summaryFunction: (Int, Int) -> Int) {
            val sum = summaryFunction(number1, number2)
            print("Sum of $number1 and $number2 is $sum")
        }

        printSummary(10, 10) { a, b -> a + b }
    }

}
