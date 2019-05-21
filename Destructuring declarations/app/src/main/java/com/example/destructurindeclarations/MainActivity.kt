package com.example.destructurindeclarations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //Destructuring Declaration only work with "data class"
    data class Customer(var name: String, val age: Int)

    //Funtions that return multiple values
    data class Result(val x: Int, val y: Int, val z: Int)
    fun calculatedVector(): Result {
        //calculators ....
        return Result(1, 5, 6)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var customer = Customer("Longnk", 22)
        var (name, age) = customer
        println("Name = $name, Age = $age")

        var customer2 = Customer("Quynh Anh", 22)
        var customers = listOf<Customer>(customer, customer2)

        for ((name, age) in customers) {
            println("Name = $name ||||| Age = $age")
        }

        var (x1, y1, z1) = calculatedVector()
        println("x1 = $x1, y1 = $y1, z1 = $z1 ")

        //map
        var userObject = mapOf<String, Any?>("name" to "Long Khanh", "age" to 22)
        for ((key, value) in userObject) {
            println("key = $key, value = $value")
        }
    }
}
