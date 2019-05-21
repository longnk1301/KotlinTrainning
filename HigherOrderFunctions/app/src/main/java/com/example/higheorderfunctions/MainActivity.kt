package com.example.higheorderfunctions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

//Higher order function là hàm có thông số đầu vào là 1 hàm khác, hoặc return về 1 hàm khác
class Lock() {
    fun lock() {
        println("I locked the process")
    }

    fun unlock() {
        println("I unlocked the process")
    }
}

var bodyFunction = fun():Int {
    val taskId = Random().nextInt()
    println("This is the body function. TaskId = $taskId")
    return taskId
}

fun doATask(lock: Lock, body: () -> Int): Int {
    lock.lock()
    try {
        return body()
    }
    finally {
        lock.unlock()
    }
}

//Ex2: function that takes functions as parameters, returns a value
val compare: (Int, Int) -> Boolean = { x, y -> x < y }
fun getMaxValueInCollection(collection: Collection<Int>, less: (Int, Int) -> Boolean): Int? {
    var maxValue: Int? = null
    for (item in collection)
        if (maxValue == null || less(maxValue, item))
            maxValue = item
    return maxValue
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doATask(Lock(), bodyFunction)

        //Ex2:
        var ints:Collection<Int> = listOf(1,2,3,4,5,10)
        var maxValue = getMaxValueInCollection(ints, compare)
        println("maxValue = $maxValue")
    }
}
