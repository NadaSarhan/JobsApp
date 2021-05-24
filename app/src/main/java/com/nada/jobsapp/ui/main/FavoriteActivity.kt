package com.nada.jobsapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nada.jobsapp.R
import com.nada.jobsapp.data.api.JobsRoomDatabase
import com.nada.jobsapp.data.repository.JobsApplication
import com.nada.jobsapp.ui.main.adapter.JobListAdapter
import com.nada.jobsapp.ui.main.adapter.MainAdapter
import com.nada.jobsapp.ui.main.viewmodel.JobViewModel
import com.nada.jobsapp.ui.main.viewmodel.MainViewModel
import com.nada.jobsapp.ui.main.viewmodel.WordViewModelFactory
import kotlinx.coroutines.CoroutineScope
//import androidx.fragment.app.viewModels
import androidx.fragment.app.Fragment

class FavoriteActivity : AppCompatActivity() {

    private var adapter = MainAdapter(arrayListOf())

//    private val JobViewModel: JobViewModel by viewModels {
//        WordViewModelFactory((application as JobsApplication).repository)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFavoriteJobs)
        val adapter = JobListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        getDatabase()

    }

    fun getDatabase() {

//        JobViewModel.allJobs.observe(this) { words ->
//            // Update the cached copy of the words in the adapter.
//            words.let { adapter.addData(it) }
//        }

    }


}