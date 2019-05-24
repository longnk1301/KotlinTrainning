package com.example.addfragmentintoactivity.ui

import android.databinding.BindingAdapter
import android.widget.ImageView


object DataBindingAdapters {

    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}