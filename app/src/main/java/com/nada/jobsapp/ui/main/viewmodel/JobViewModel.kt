package com.nada.jobsapp.ui.main.viewmodel

import androidx.lifecycle.*
import com.nada.jobsapp.data.model.Job
import com.nada.jobsapp.data.repository.JobRoomRepository
import kotlinx.coroutines.launch

class JobViewModel(private val repository: JobRoomRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allJobs: LiveData<List<Job>> = repository.allJobs.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(word: Job) = viewModelScope.launch {
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: JobRoomRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JobViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return JobViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}