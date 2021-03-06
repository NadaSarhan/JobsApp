package com.nada.jobsapp.data.model

import com.google.gson.annotations.SerializedName

data class Job(

    @SerializedName("id")
    val id: String,

    @SerializedName("company")
    val company: String,

    @SerializedName("company_logo")
    val companyLogo: String,

    @SerializedName("company_url")
    val companyUrl: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("how_to_apply")
    val howToApply: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("url")
    val url: String

)