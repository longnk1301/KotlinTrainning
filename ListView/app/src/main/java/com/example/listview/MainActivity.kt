package com.example.listview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.line_food.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayFoods: ArrayList<Foods> = ArrayList()
            arrayFoods.add(Foods("Bánh mỳ pate trứng", R.drawable.image1, "20.000vnd"))
            arrayFoods.add(Foods("Bún chả lá vừng", R.drawable.image2, "15.000vnd"))
            arrayFoods.add(Foods("Phở Bò không hành", R.drawable.image3, "39.300vnd"))
            arrayFoods.add(Foods("Cơm rang dưa bò", R.drawable.image4, "40.112vnd"))
            arrayFoods.add(Foods("Cơm xả ớt", R.drawable.image5, "32.000vnd"))

        listView.adapter = CustomAdapter(this@MainActivity, arrayFoods)

        buttonIntent.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, SecondActivity::class.java)
//            intent.putExtra("data", "Hello world")
//            intent.putExtra("data", 1998)
//            var arrayNumber: IntArray = intArrayOf(123, 546, 444)
//            intent.putExtra("data", arrayNumber)

            val fruit:  Fruits = Fruits("Táo", 10000)

            intent.putExtra("data", fruit)
            startActivity(intent)

        }
    }
}
