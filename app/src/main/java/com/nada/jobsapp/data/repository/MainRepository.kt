package com.nada.jobsapp.data.repository

import com.nada.jobsapp.data.api.JobHelper

class MainRepository (private val jobHelper: JobHelper) {

    suspend fun getJobsData() = jobHelper.getJobsData()

}