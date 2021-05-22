package com.nada.jobsapp.data.api

import com.nada.jobsapp.data.model.Job
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsServices {

    @GET("positions.json?description=api")
    suspend fun getJobsData(): List<Job>

}