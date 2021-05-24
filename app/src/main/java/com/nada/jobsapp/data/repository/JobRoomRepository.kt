package com.nada.jobsapp.data.repository

import androidx.annotation.WorkerThread
import com.nada.jobsapp.data.api.DaoDB
import com.nada.jobsapp.data.model.Job
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class JobRoomRepository(private val daoDB: DaoDB) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allJobs: Flow<List<Job>> = daoDB.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(job: Job) {
        daoDB.insert(job)
    }

}