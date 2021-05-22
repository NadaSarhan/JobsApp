package com.nada.jobsapp.data.api

import com.nada.jobsapp.data.model.Job

class JobHelperImpl (private val jobService: JobsServices) : JobHelper {

    override suspend fun getJobsData(): List<Job> {
        return jobService.getJobsData()
    }

}