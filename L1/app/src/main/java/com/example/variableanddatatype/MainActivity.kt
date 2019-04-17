package com.example.variableanddatatype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*variable and datatype
        var a : String = ""
        a = "Hello!"
        a.toInt()
        val b : String = "Xin chao"*/


        /*null Safety
        // ? can null
        // !! determiner 1 variable cannot = null
        var name : String? = "abc"
        name = null

        var name1 : String = null!!
        name1 = "haha"*/


        /*//if else
        var a : Int = 10
        var b : Int = 15

        if (a > b) {
            Log.d("AAA", "A" + a)
        } else {
            Log.d("BBB", "B" + b)
        }*/

        /*//when
            var a : Int = 15
            when(a) {
                1,2,3 -> Log.d("AA", "HAHA")
                4,5,6 -> Log.d("AA", "HHHHHH")
                in 7..9 -> Log.d("AA", "cccc")
                else -> Log.d("AA", "null...")
            }*/

        /*//While
            same ...*/

        /*//For
        for ( i in 0..10) {
            Log.d("AA", "Hello" + 1)
        }

        var a : Int = 5
        for (i in 0 until a ) {
            Log.d("AA", "Hello" + i)
        } //0,1,2,3,4

        for (i in a downTo 0 ) {
            Log.d("AA", "Hello" + i)
        } //5,4,3,2,1,0

        for (i in 0..a step 2) {
            Log.d("AA", "Hello" + i)
        }*/

        /*//Array
        var mangSo : IntArray = intArrayOf(1,2,3,4,5)
        mangSo.get(1)

        var mangChar : List<String> = listOf("a", "v", "c")
        mangChar.get(1)

        var mangChar2 : ArrayList<String> = ArrayList()
        mangChar2.add("aaa")
        mangChar2.add("bbb")
        mangChar2.add("ccc")

        //count
        mangChar2.size

        //delete element in array
        mangChar2.remove("aaa")
        mangChar2.removeAt(1)

        //edit element in array
        mangChar2.set(1, "ddd")*/

        //Function
        ShowName("aaaa")
    }

    fun ShowName(name : String) {
        Log.d("SSS", "HAHAHAHAH" + name)
    }
}
