package com.example.listsetmap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbers: MutableList<Int> = mutableListOf(1,2,3) //can write
        val readOnlyNumbers: List<Int> = numbers // can't write

        println(numbers)
        numbers.add(4)
        println(" numbers $numbers")
        println("readOnlyNumbers = $readOnlyNumbers")

        val strings = mutableSetOf("a", "b", "c", "d", "f")
        if (strings.contains("g")) {
            println("this set contains g")
        } else {
            println("this set not contains g")
        }

        println("strings $strings")
        println("sortedDescending ${strings.sortedDescending()}")

        //Take snapshot of a collection at a particular point in time
        val floatMutableList: MutableList<Float> = mutableListOf(1.0F, 2.0F, 3.0F)
        //toList copy a snapshot
        val backupfloatList: List<Float> = floatMutableList.toList()
        floatMutableList.add(4.0F)
        println("floatMutableList = $floatMutableList")
        println("backupfloatList = $backupfloatList")

        println("first element of floatMutableList = ${floatMutableList.first()}")
        println("last element of floatMutableList = ${floatMutableList.last()}")
        val listWithNullElement: MutableList<Int?> = mutableListOf(1, 2, null, 3, 4)
//        println("list = ${listWithNullElement.requireNoNulls()}")

        var mutableHashMap = mutableMapOf <String, Int>("x" to 1, "y" to 2)
//        mutableHashMap["x"] = 100
        mutableHashMap.set("x", 200)
        println("mutableHashMap $mutableHashMap")


        //Range


    }
}
