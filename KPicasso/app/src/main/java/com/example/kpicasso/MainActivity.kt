package com.example.kpicasso

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "http://juncart.artp.cc/userfiles/21/8226d1b1e8b64137823aafe80114e97c_1600.jpg"

        Picasso.get()
            .load(url)
            .placeholder(R.drawable.loadding)
            .error(R.drawable.no_not)
            .into(imgHinh);
    }
}
