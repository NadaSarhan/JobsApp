package com.nada.jobsapp.ui.main.viewstate

import com.nada.jobsapp.data.model.Job

sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class Users(val user: List<Job>) : MainState()
    data class Error(val error: String?) : MainState()

}
