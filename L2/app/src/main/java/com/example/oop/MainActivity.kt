package com.example.oop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var st1 : Student = Student("Long", "Ha noi", 1997)

//        st1.name = "Long"
//        st1.address = "AAA"
//        st1.born = 1997

//        st1.setName("LongABC")
//        st1.setAddress("ha Nooi")
//        st1.setBorn(1997)

        Log.d("AAA", st1.getName() + " - " + st1.getAddress() + " - " + st1.getBorn() + " - " + st1.getAge())

        val transport: Transport = Transport("LMW", "Black", 4)

        Log.d("AAA", transport.name + " - " + transport.color)
    }
}
