package com.example.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //nhan du lieu truyen tu main activity
        val intent = intent
//        val param:String = intent.getStringExtra("data")

//        val param:Int = intent.getIntExtra("data", 123)

//        val mangSo : IntArray = intent.getIntArrayExtra("data")
//        textView.text = mangSo[0].toString()

//        textView.text = param.toString()

        val fruit:Fruits = intent.getSerializableExtra("data") as Fruits
        textView.text = fruit.name + " - " + fruit.price
    }
}
