package com.nada.jobsapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nada.jobsapp.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nada.jobsapp.data.api.JobHelperImpl
import com.nada.jobsapp.data.api.JobsServices
import com.nada.jobsapp.data.api.RetrofitBuilder
import com.nada.jobsapp.data.model.Job
import com.nada.jobsapp.ui.main.adapter.MainAdapter
import com.nada.jobsapp.ui.main.intent.MainIntent
import com.nada.jobsapp.ui.main.viewmodel.MainViewModel
import com.nada.jobsapp.ui.main.viewstate.MainState
import com.nada.jobsapp.util.ViewModelFactory
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class HomeActivity : AppCompatActivity(){

    private lateinit var mainViewModel: MainViewModel
    private var adapter = MainAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupUI()
        setupViewModel()
        observeViewModel()
        setupClicks()

    }

    private fun setupClicks() {
        lifecycleScope.launch {
            mainViewModel.userIntent.send(MainIntent.FetchJob)
        }
    }

    private fun setupUI() {
        recyclerViewHomeJobs.layoutManager = LinearLayoutManager(this)
        recyclerViewHomeJobs.run {
            addItemDecoration(
                DividerItemDecoration(
                    recyclerViewHomeJobs.context,
                    (recyclerViewHomeJobs.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
        recyclerViewHomeJobs.adapter = adapter
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                JobHelperImpl(
                    RetrofitBuilder().getRetrofit().create(JobsServices::class.java)
                )
            )
        ).get(MainViewModel::class.java)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            mainViewModel.state.collect {
                when (it) {
                    is MainState.Idle -> {

                    }

                    is MainState.Users -> {
                        renderList(it.user)
                    }

                    is MainState.Error -> {
                        Toast.makeText(this@HomeActivity, it.error, Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }

    private fun renderList(users: List<Job>) {
        recyclerViewHomeJobs.visibility = View.VISIBLE
        users.let { listOfUsers -> listOfUsers.let { adapter.addData(it) } }
        adapter.notifyDataSetChanged()
    }

    public fun onClick() {
        Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, FavoriteActivity::class.java)
        startActivity(intent)
    }

}