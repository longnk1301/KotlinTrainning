package com.example.ungdunghoctoan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAdd.setOnClickListener {
            var sothu1 : Int = (edittext1.text.toString()).toInt()
            var sothu2 : Int = (edittext2.text.toString()).toInt()
            var ketqua : Int = sothu1 + sothu2
            result.text = ketqua.toString()
        }

        buttonSub.setOnClickListener {
            var sothu1 : Int = (edittext1.text.toString()).toInt()
            var sothu2 : Int = (edittext2.text.toString()).toInt()
            var ketqua : Int = sothu1 - sothu2
            result.text = ketqua.toString()
        }

        buttonMutil.setOnClickListener {
            var sothu1 : Int = (edittext1.text.toString()).toInt()
            var sothu2 : Int = (edittext2.text.toString()).toInt()
            var ketqua : Int = sothu1 * sothu2
            result.text = ketqua.toString()
        }

        buttonDiv.setOnClickListener {
            var sothu1 : Int = (edittext1.text.toString()).toInt()
            var sothu2 : Int = (edittext2.text.toString()).toInt()
            var ketqua : Int = sothu1 / sothu2
            result.text = ketqua.toString()
        }
    }
}
