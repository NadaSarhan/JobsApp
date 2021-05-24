package com.nada.jobsapp.data.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nada.jobsapp.data.model.Job

@Database(entities = [Job::class], version = 1, exportSchema = false)
abstract class JobsRoomDatabase : RoomDatabase() {

    abstract val jobDatabaseDao: DaoDB

    companion object {

        @Volatile
        private var INSTANCE: JobsRoomDatabase? = null

        fun getInstance(context: Context): JobsRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JobsRoomDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}