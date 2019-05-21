package com.example.textfile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")

        var a = fruits.filter { it.startsWith("a") }
        var b = fruits.sortedBy { it }
        var c = fruits.map{ it.toUpperCase() }
        var d = fruits.forEach { println(it) }

        Log.d("AAA", d.toString())
    }
}
