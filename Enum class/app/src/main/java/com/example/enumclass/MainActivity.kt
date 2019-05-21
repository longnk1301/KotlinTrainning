package com.example.enumclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

enum class CompassDirection {
    EAST, WEST, SOUTH, NORTH
}

enum class Color(val red:Int, val green: Int, val blue: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0,0,255)
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("North enum = ${CompassDirection.NORTH}")
        println(Color.BLUE.toString())
        println("Color details = ${Color.GREEN.name}, ordinal: ${Color.GREEN.ordinal}")
        print(Color.valueOf("RED"))

        for (color in Color.values()) {
            print(color)
        }
    }
}
