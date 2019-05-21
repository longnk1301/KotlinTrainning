package com.example.exdeleted

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {

    interface BirdInterface {
        fun flyAndFindFood()
    }

    class Eager(val age: Int) : BirdInterface {
        override fun flyAndFindFood() {
            println("I am an eager. I am $age years old. I am flying and finding food")
        }
    }

    class Cuckoo(b: BirdInterface): BirdInterface by b {
//        override fun flyAndFindFood() {
//            println("I am an Cuckoo. I am flying and finding food")
//        }
    }


    //delegated properties
    class User {
        var todayTask: String by DelegatedUser()
    }

    class DelegatedUser {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thanks for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, s: String) {
           println("assigned to '${property.name}' in $thisRef. Details: $s")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eager = Eager(10)
        eager.flyAndFindFood()
        // cuckoo give eager execute flyAndFindFood()
        var cuckoo = Cuckoo(eager)
        cuckoo.flyAndFindFood() //I am an Cuckoo. I am flying and finding food


        //delegated properties
        var user = User()
        println(user.todayTask)
        user.todayTask = "hahahaahhahahah"
    }
}
