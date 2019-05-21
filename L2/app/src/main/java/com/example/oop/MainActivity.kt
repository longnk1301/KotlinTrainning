package com.example.oop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var st1 : Student = Student("Long", "Ha noi", 2000)

//        st1.name = "Long"
//        st1.address = "AAA"
//        st1.born = 1997

//        st1.setName("LongABC")
//        st1.setAddress("ha Nooi")
//        st1.setBorn(1997)

        Log.d("AAA", st1.getName() + " - " + st1.getAddress() + " - " + st1.getBorn() + " - " + st1.getAge())

        val transport: Transport = Transport("LMW", "Black", 4)

        Log.d("AAA", transport.name + " - " + transport.color)
        Log.d("AAA", "Transport: ${transport.name} - ${transport.color} - ${transport.wheel} ")

        for (i in 1 until  10) {
            Log.d("AAA", i.toString())
        }

        val map = mapOf("a" to 12, "b" to 2, "c" to 3)

        Log.d("AAA", map["a"].toString())

        val files = File("Test").listFiles()

        Log.d("AAA", files?.size.toString())

        var str = "hello kotlin let"
        str.let { println("$it!!")}
        println(str)

        var m = 1
        var a = m.also { it + 1 }.also { it + 1 }
        println(a)

        var person: Person = Person("Anupam", "Kotlin")

        person.apply { this.tutorial = "Swift" }
        println(person)

        val listWithNulls: List<String?> = listOf("Kotlin", null, "HÂHHA")
        for (item in listWithNulls) {
            item?.let { println(it) } // prints Kotlin and ignores null
        }

        val stra = "abcd"
        for (c in stra) {
            Log.d("AAA", c.toString())
        }

        val text = """
            |Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            |(Benjamin Franklin)
            """.trimMargin("|")

        Log.d("AAA", text)
    }
}
