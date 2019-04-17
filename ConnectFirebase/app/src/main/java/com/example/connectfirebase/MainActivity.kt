package com.example.connectfirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    var database : DatabaseReference

    init {
        database = FirebaseDatabase.getInstance().reference
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database.child("MonHoc").setValue("Android")
    }
}
