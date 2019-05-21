package com.example.lifecycle.view

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.lifecycle.data.OnDataReadyCallback
import com.example.lifecycle.data.RepoModel

class MainViewModel : ViewModel(){
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField("old data")
    val isLoading = ObservableField(false)

//    var repositories = ArrayList<Repository>()

    fun refresh() {
        isLoading.set(true)
        repoModel.refreshData( object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }

    fun loadRepositories() {
//        isLos
    }
}