package com.nada.jobsapp.data.api

import com.nada.jobsapp.data.model.Job
import retrofit2.Call
import retrofit2.http.GET

interface JobHelper {

    suspend fun getJobsData(): List<Job>

}