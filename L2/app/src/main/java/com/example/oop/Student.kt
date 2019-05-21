package com.example.oop

class Student(ten : String, diachi : String, namsinh : Int) {
    private var name : String = ""
    private var address : String = ""
    private var born : Int = 1997

    init {
        name = ten
        address = diachi
        born = namsinh

        setBorn(born)
    }

//    constructor(ten : String, diachi : String, namsinh : Int) {
//        name = ten
//        address = diachi
//        born = namsinh
//    }

    fun setName(value : String) {
        name = value
    }

    fun getName() : String {
        return name
    }

    fun setAddress(value : String) {
        address = value
    }

    fun getAddress() : String {
        return address
    }

    fun setBorn(year : Int) {
        if (year > 1997) {
            born = 1997
        } else {
            born = year
        }
    }

    fun getBorn() : Int {
        return born
    }

    fun getAge() : Int {
        return 2019 - born
    }
}