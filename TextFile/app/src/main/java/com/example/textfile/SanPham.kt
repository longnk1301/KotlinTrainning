package com.example.textfile

class SanPham {
    var ma: Int = 0
    var ten: String = ""
    var dongia: Double = 0.0

    constructor(ma: Int, ten: String, dongia: Double) {
        this.ma = ma
        this.ten = ten
        this.dongia = dongia
    }

    override fun toString(): String {
        return "$ma/t$ten/$dongia"
    }
}
