package com.nada.jobsapp.data.api

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.nada.jobsapp.data.model.Job

@Dao
interface DaoDB {

    @Insert
    fun insert(job: Job)

    @Delete
    fun delete(job: Job)

    @Query("SELECT * FROM job")
    fun getAll(): List<Job>

}