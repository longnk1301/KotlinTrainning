package com.example.lifecycle

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.lifecycle.databinding.ActivityMainBinding
import com.example.lifecycle.view.MainViewModel
import com.example.lifecycle.view.RepositoryRecyclerViewAdapter

class MainActivity : AppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java) //lifecycle
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = RepositoryRecyclerViewAdapter(viewModel.repositories, this)
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
