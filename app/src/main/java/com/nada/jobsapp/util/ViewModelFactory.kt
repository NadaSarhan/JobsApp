package com.nada.jobsapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nada.jobsapp.data.api.JobHelper
import com.nada.jobsapp.data.repository.MainRepository
import com.nada.jobsapp.ui.main.viewmodel.MainViewModel

class ViewModelFactory (private val apiHelper: JobHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}