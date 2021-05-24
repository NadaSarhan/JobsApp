package com.nada.jobsapp.data.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nada.jobsapp.data.model.Job
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Job::class], version = 1, exportSchema = false)
abstract class JobsRoomDatabase : RoomDatabase() {

    abstract fun  jobDatabaseDao(): DaoDB

    companion object {

        @Volatile
        private var INSTANCE: JobsRoomDatabase? = null

        fun getInstance(context: Context, scope: CoroutineScope): JobsRoomDatabase {
            synchronized(this) {

                // if the INSTANCE is not null, then return it,
                // if it is, then create the database

//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        JobsRoomDatabase::class.java,
//                        "sleep_history_database"
//                    )
//                        .addCallback(JobDatabaseCallback(scope))
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance

                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        JobsRoomDatabase::class.java,
                        "word_database"
                    )
                        .addCallback(JobDatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                    // return instance
                    instance

            }
        }
    }

    private class JobDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.jobDatabaseDao())

                    var jobDao = database.jobDatabaseDao()

                }
            }
        }

        suspend fun populateDatabase(jobDao: DaoDB) {
            // Delete all content here.
            jobDao.getAll()

        }

    }

}