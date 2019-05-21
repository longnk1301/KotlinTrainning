package com.example.lambdaandanonymous

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    //lambda
        //c1:
            val sum = { x: Double, y: Double -> x + y }
        //c2:
            val sum2: (Double, Double) -> Double = { x, y -> x + y }

    //anonymous
        var sum3 = fun(x: Double, y: Double): Double {
            return x + y
        }
    //anonymous function without return value
        var sayHello = fun(personName: String ) {
        println("This is an anonymous function")
        println("Hello $personName")
    }

    //Observable properties
    class User(name: String) {
        var currentAddress: String by Delegates.observable("no address") {
            //when currentAddress changed
            prop, oldAddress, newAddress -> run {
                println("Address is changing")
            println("From $oldAddress -> $newAddress")
            println("property's name = ${prop.name}")
            }
        }
    }

    //Storing Properties in a mAP = like to "store in a josn with Joey-value pairs
    var userObject =  mutableMapOf<String, Any?>("name" to "Long", "age" to 22 )

    class Customer(val mapObject: Map<String, Any?>) {
        val name: String by mapObject
        val age: Int by mapObject
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("Sum = ${sum(10.1, 9.2)}")
        println("Sum2 = ${sum2(112.5, 44.2)}")

        println("Sum2 = ${sum3(12.5, 4.2)}")
        sayHello("Quynh Anh")

        //Observable properties
        val user = User("Quynh Anh")
        user.currentAddress = "1234 Peen Awenuew\t" + "Pittsbungh, PA 15286\t" + "United States"


        //Storing Properties in a mAP = like to "store in a josn with Joey-value pairs
        println("User's details. Name = ${userObject.getValue("name")} | age - ${userObject.getValue("age")}")
        userObject.set("age", 23)
        println("User's details. Name = ${userObject.getValue("name")} | age - ${userObject.getValue("age")}")

        val customer = Customer(mapOf(
            "name" to "Long", "age" to 24
        ))
        println("Customer's details. Name = ${customer.name} | age = ${customer.age}")
    }
}
